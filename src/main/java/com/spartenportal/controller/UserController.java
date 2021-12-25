package com.spartenportal.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.UserMapper;
import com.spartenportal.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping(value = "/userForm2")
	public ModelAndView viewuserform(ModelAndView mv, Model m) {
		return mv;
	}

	// method to check login details
	@PostMapping(value = "/checklogin")
	public ModelAndView loginUser(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, @RequestParam(name = "role") String role, ModelAndView mv,
			Model m, HttpServletRequest request) {
		if (role.equals("employee")) {
			User user = userservice.findByUserNameAndPassword(username, password);
			String message;
			if (user == null) {
				message = "Login failed! Incorrect Username OR Password";
				mv = new ModelAndView("userLogin");
				mv.addObject("message", message);
			} else if ((user.getUserName().equals(username)) && (user.getPassword().equals(password))) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getUserid());
				session.setAttribute("firstName", user.getFirstName());
				message = "Login Sucessfull!";
				mv = new ModelAndView("userDashboard");
				m.addAttribute(session);
			}
		} else if (role.equals("admin")) {
			User user = userservice.findByUserNameAndPassword(username, password);
			String message;
			if ((user.getUserName() == null) && (user.getPassword() == null)) {
				message = "Login failed! Incorrect UserName OR Password";
				mv = new ModelAndView("userLogin");
				mv.addObject("message", message);
			} else if ((user.getUserName().equals(username)) && (user.getPassword().equals(password))) {
				HttpSession session = request.getSession();
				session.setAttribute("userId", user.getUserid());
				session.setAttribute("firstName", user.getFirstName());
				message = "Login Sucessfull!";
				mv = new ModelAndView("hrHomepage");
				m.addAttribute(session);
			}
		}
		return mv;
	}

	// API to logout from sessions
	@RequestMapping(value = "/logout")
	public ModelAndView logout(ModelAndView mv, HttpServletRequest request) {
		request.getSession().invalidate();
		mv = new ModelAndView("userLogin");
		return mv;
	}

	// api to show user dashboard
	@RequestMapping(value = "/userDashboard")
	public ModelAndView viewMainScreen(ModelAndView mv) {
		String message = "Welcome User!";
		mv.addObject("message", message);
		return mv;
	}

	// method to show userForm
	@RequestMapping(value = "/userForm")
	public ModelAndView userForm(ModelAndView mv, Model m) {
		System.out.println("in user api");
		return mv;
	}


	// method to create user
	@RequestMapping(value = "/saveUser")
	public ModelAndView registerStudent(ModelAndView mv, @ModelAttribute("user") User user) throws Exception {
		System.out.println("in save user api");
		userservice.saveUser(user);
		String message = "Hello " + user.getFirstName() + " " + user.getLastName()
				+ ",  \n\nWelcome to Krios Info Solutions Pvt Ltd, Pune  !!\r\n"
				+ "\nCongratulations on being part of our dynamic team!  The entire office welcomes you and we hope to have a long and successful journey together. \r\n"
				+ "\nAs discussed with you, please fill all your data in the employement form on our krios portal "
				+ "and upload mention documents.\n\nKrios Portal Link : www.kriosportal.com\n\n"
				+ "---------------------------------\n" + " Login Details\n" + "---------------------------------\n"
				+ " UserName : " + user.getUserName() + "\n Password : " + user.getPassword()
				+ "\n----------------------------------"
				+ "\n\n Please feel free to ask if you have any questions or queries.  \n\n Thanks & Regards,\n HR Executive";
		userservice.sendEmail(user.getEmail(), message, "Krios Employement Form");

		String message2 = "user added sucesfully and mail sent";
		mv.addObject(message2);
		mv = new ModelAndView("addUserForm");
		return mv;
	}

	// method to get single user data
	@RequestMapping(value = "/editUser")
	public ModelAndView editUser(ModelAndView mv, Model m, HttpServletRequest request) {
		int userId = (int) request.getSession().getAttribute("userId");
		UserBean user = userservice.getById(userId);
		mv = new ModelAndView("userForm2");
		m.addAttribute("user", user);
		return mv;
	}

	//API to update user
	@PostMapping(value = "/updateUser")
	public ModelAndView updateUser(@ModelAttribute("user") User user, ModelAndView mv,HttpServletRequest request)
			throws NumberFormatException, IOException {
		int userId = (int) request.getSession().getAttribute("userId");
		
		UserBean user2 = userservice.getById(userId);
		User user3 = userMapper.mapToEntity(user2);
		user.setUserName(user3.getUserName());
		user.setPassword(user3.getPassword());
		user.setUserid(userId);
		userservice.updateUser(user);
		mv = new ModelAndView("userForm2");
		return mv;
	}
}
