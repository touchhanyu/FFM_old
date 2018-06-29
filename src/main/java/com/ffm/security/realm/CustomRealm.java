package com.ffm.security.realm;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.ffm.common.dict.LoginStatus;
import com.ffm.sys.model.SysUser;
import com.ffm.sys.service.UserLogin;

public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private UserLogin login;

	/**
	 * 授权
	 * 
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		return info;
	}

	/**
	 * 认证
	 * 
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		SysUser user = new SysUser();
		user.setName(username);
		List<SysUser> list = this.login.login(user);
		if (list.size() == 0)
			throw new UnknownAccountException();
		user = list.get(0);
		if (LoginStatus.LOCKED == user.getStatus())
			throw new LockedAccountException();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
		return info;
	}

}