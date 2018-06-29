package com.ffm.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sys")
public class SysAction {

	@RequestMapping("main")
	public String main() {
		return "/home/main";
	}

	@RequestMapping("home")
	public String home() {
		return "/home/home";
	}

	@RequestMapping(value = "logout", method = RequestMethod.POST)
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		session.removeAttribute("user");
		subject.logout();
		return "/login/Login";
	}
}