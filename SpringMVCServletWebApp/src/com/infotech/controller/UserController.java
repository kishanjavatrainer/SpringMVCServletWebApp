package com.infotech.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.infotech.model.User;

@Controller
public class UserController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String registerPage(){
		return "register";
	}
	
	@RequestMapping(value="/registerSuccess",method=RequestMethod.POST)
	public ModelAndView registerSuccess(HttpServletRequest request,HttpServletResponse response){
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		int age = Integer.parseInt(request.getParameter("age"));
		User user = new User(userName, age, email, country);
		ModelAndView modelAndView = new ModelAndView("registerSuccess");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
}
