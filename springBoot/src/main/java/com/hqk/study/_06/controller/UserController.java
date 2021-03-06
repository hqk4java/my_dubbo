package com.hqk.study._06.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hqk.study._06.model.BasicUser;
import com.hqk.study._06.service.BasicUserService;

@Controller
public class UserController {

	@Autowired
	private BasicUserService basicUserService;
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public void getUserInfo() {
		List<BasicUser> selectList = basicUserService.selectList();
		for (BasicUser basicUser : selectList) {
			System.out.println(basicUser.toString());
		}
	}
	
	@RequestMapping("/insertUser")
	@ResponseBody
	public void insertUser() {
		BasicUser user  = new BasicUser();
		user.setPassword("123456");
		user.setUserName("test");
		basicUserService.insertUser(user);
	}
	
	@RequestMapping("getFtl")
	public ModelAndView returnView() {
		ModelAndView view = new ModelAndView();
/*		List<BasicUser> selectList = basicUserService.selectList();
		view.addObject("selectList", selectList);*/
		view.setViewName("index.ftl");
		return view;
	}
	
	@RequestMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView();
		List<BasicUser> selectList = basicUserService.selectList();
		view.addObject("selectList", selectList);
		view.setViewName("/index.jsp");
		return view;
	}
}
