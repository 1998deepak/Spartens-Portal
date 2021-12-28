package com.spartenportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.User;
import com.spartenportal.service.UserService;

@RestController
public class FinanceController {

	@Autowired
	UserService userservice;

	// API to get all employee deatils
	@RequestMapping(value = "/financeUserList")
	public ModelAndView employeeDetails(ModelAndView mv, Model m) {
		String message = "List Of Users. Check For Update/Delete.";
		List<User> userList = userservice.getUserList();
//		List<User> userList2 = null ;
//		for (User user : userList) {
//			if(user.getClientCompanyName() != null)
//				userList2.add(user);
//		}
		m.addAttribute("userList", userList);
		mv.addObject("message", message);
		return mv;
	}

	@RequestMapping(value = "/AttendanceSheet")
	public ModelAndView viewAttendanceSheet(ModelAndView mv, Model m) {
		return mv;
	}

	@RequestMapping(value = "/financePanel")
	public ModelAndView viewFinancePanel(ModelAndView mv, Model m) {
		return mv;
	}

	@RequestMapping(value = "/financeUserInfo/{userId}")
	public ModelAndView viewFinanceUserInfo(@PathVariable(name = "userId") int userId,ModelAndView mv, Model m) {
		UserBean user = userservice.getById(userId);
//		List<Docs> docs = documentservice.getDocsByuserIdFk(userId);
		m.addAttribute("user", user);
//		m.addAttribute("docs", docs);
		mv = new ModelAndView("financeUserInfo");
		return mv;
	}
}
