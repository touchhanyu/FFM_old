package com.ffm.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserAction {
	@RequestMapping(value = "/useradd", method = RequestMethod.POST)
	public String userAdd() {
		return "";
	}
}