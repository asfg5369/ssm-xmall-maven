package com.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ssm.pojo.Users;
import com.ssm.service.IUsersService;

@Controller
public class AdminController {
	@Autowired
	private IUsersService iUsersService;
	
	@RequestMapping("/")
	public String index(Model model) {
		Wrapper<Users> wrapper = new EntityWrapper<>();
		List<Users> list = iUsersService.selectList(wrapper);
		model.addAttribute("list", list);
		return "index";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("loginValify")
	@ResponseBody
	public Map<String, Object> login(HttpServletRequest request) {
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		Map<String, Object> map = new HashMap<>();
		if (username == null || password == null || username == "" || password == "") {
			map.put("status", 500);
			map.put("message", "用户名或者密码不能为空!");
		} else {
			map.put("status", 200);
			map.put("message", "登录成功");
		}
		return map;
	}
	
	@RequestMapping("/getRoles")
	public String getRoles(){
		System.out.println("getRoles");
		return "role-list";
	}
}
