package com.ffm.security.realm;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
	private static int ERRORPWDMAX = 5;// 最大密码错误次数
	private Cache<String, AtomicInteger> passwordRetryCache;

	public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
		this.passwordRetryCache = cacheManager.getCache("passwordRetryCache");
	}

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		String username = (String) token.getPrincipal();
		AtomicInteger retryCount = this.passwordRetryCache.get(username);
		if (retryCount == null) {
			retryCount = new AtomicInteger(0);
			this.passwordRetryCache.put(username, retryCount);
		}
		// 连续输入密码错误后禁止登录
		if (retryCount.incrementAndGet() > RetryLimitHashedCredentialsMatcher.ERRORPWDMAX)
			throw new ExcessiveAttemptsException();
		boolean match = super.doCredentialsMatch(token, info);
		if (match) {
			this.passwordRetryCache.remove(username);
		} else {
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession();
			session.setAttribute("retryCount", RetryLimitHashedCredentialsMatcher.ERRORPWDMAX - retryCount.get());
		}
		return match;
	}
}