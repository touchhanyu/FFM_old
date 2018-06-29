package com.ffm.security.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffm.common.util.COMUtil;
import com.ffm.common.util.SysUtil;
import com.ffm.security.util.VerifyCodeUtil;
import com.ffm.sys.dto.ControllerResult;
import com.ffm.sys.model.SysUser;
import com.ffm.sys.service.UserLogin;

@Controller
@RequestMapping("/login")
public class LoginAction {
	@Autowired
	private UserLogin userLogin;
	private Logger logger = LogManager.getLogger();

	@RequestMapping("loginPage")
	public String loginPage() {
		return "/login/Login";
	}

	@RequestMapping("verifyCode")
	public void verifyCode(HttpServletResponse response) {
		ServletOutputStream os = null;
		try {
			os = response.getOutputStream();
			String code = VerifyCodeUtil.generate(os);
			Subject subject = SecurityUtils.getSubject();
			Session session = subject.getSession(true);
			session.setAttribute("verifyCode", code);
			logger.info("verifyCode[%s]", code);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	@ResponseBody
	public ControllerResult login(SysUser user, @RequestParam("autologin") String autologin,
			@RequestParam("verifycode") String verifyCode, HttpServletResponse response) throws IOException {
		Subject subject = SecurityUtils.getSubject();
		if (user.getName() == null || user.getName().length() == 0)
			return new ControllerResult(false, "用户名不能为空！");
		if (user.getPassword() == null || user.getPassword().length() == 0)
			return new ControllerResult(false, "密码不能为空！");
		if (verifyCode == null || verifyCode.length() == 0)
			return new ControllerResult(false, "验证码不能为空！");
		Session session = subject.getSession();
		String _verifyCode = (String) session.getAttribute("verifyCode");
		logger.info("verifyCode:" + _verifyCode);
		if (!verifyCode.equalsIgnoreCase(_verifyCode))
			return new ControllerResult(false, "验证码错误！");
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
		try {
			subject.login(token);
		} catch (UnknownAccountException e) {
			int retryCount = (int) session.getAttribute("retryCount");
			String msg = "";
			if (retryCount == 0) {
				msg = "用户名或密码错误！帐号将被锁定15分钟";
			} else {
				msg = "用户名或密码错误！还可尝试" + retryCount + "次";
			}
			return new ControllerResult(false, msg);
		} catch (IncorrectCredentialsException e) {
			int retryCount = (int) session.getAttribute("retryCount");
			String msg = "";
			if (retryCount == 0) {
				msg = "用户名或密码错误！帐号将被锁定15分钟";
			} else {
				msg = "用户名或密码错误！还可尝试" + retryCount + "次";
			}
			return new ControllerResult(false, msg);
		} catch (ExcessiveAttemptsException e) {
			return new ControllerResult(false, "密码错误次数过多！");
		}
		session = subject.getSession();
		session.setAttribute("user", user);
		if ("on".equals(autologin)) {// 自动登录标志
			SysUtil.addCookie(response, user.getName(), user.getPassword());
		}
		return new ControllerResult(true, null);
	}

	@RequestMapping("registerPage")
	public String register() {
		return "/login/Register";
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public String register(SysUser user, HttpServletResponse response) {
		Date date = new Date();
		String currentTime = COMUtil.currentTime();
		Md5Hash md5Hash = new Md5Hash(user.getPassword());
		String password = md5Hash.toHex();
		user.setPassword(password);
		user.setMakeDate(date);
		user.setMakeTime(currentTime);
		user.setAuthority("1");
		try {
			this.userLogin.register(user);
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword());
			subject.login(token);
			Session session = subject.getSession(true);
			session.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SysUtil.addCookie(response, user.getName(), password);// 添加cookie
		return "/home/Home";
	}
}