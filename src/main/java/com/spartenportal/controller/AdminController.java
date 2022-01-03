package com.spartenportal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.Docs;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.UserMapper;
import com.spartenportal.service.DocumentsService;
import com.spartenportal.service.RoleService;
import com.spartenportal.service.UserService;

@RestController
public class AdminController {

	@Autowired
	UserService userservice;

	@Autowired
	DocumentsService documentservice;

	@Autowired
	RoleService roleService;

	@Autowired
	private UserMapper userMapper;

	// method to redirect to HR-dashboard
	@RequestMapping(value = "/hrHomepage")
	public ModelAndView adminHomePage(ModelAndView mv, Model m) {
		return mv;
	}

	// method to redirect to Update form
	@RequestMapping(value = "/viewForm/{userId}")
	public ModelAndView viewUserForm(@PathVariable(name = "userId") int userId, ModelAndView mv, Model m,
			HttpServletRequest request) {
		UserBean user = userservice.getById(userId);
		List<Docs> docs = documentservice.getDocsByuserIdFk(userId);
		HttpSession session = request.getSession();
		session.setAttribute("viewUserId", userId);
		m.addAttribute("user", user);
		m.addAttribute("docs", docs);
		mv = new ModelAndView("viewForm");
		return mv;
	}

	@RequestMapping("/viewDocAdmin/{docId}")
	public ModelAndView getPdfAdmin(@PathVariable Integer docId, ModelAndView mv, Model m, HttpServletRequest request)
			throws Exception {
		Docs docs1 = documentservice.getFile(docId).get();
		Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + docs1.getDocPath());
		p.waitFor();
		mv.addObject(p);
		int userIdfk = (int) request.getSession().getAttribute("viewUserId");
		UserBean user = userservice.getById(userIdfk);
		List<Docs> docs = documentservice.getDocsByuserIdFk(userIdfk);
		m.addAttribute("user", user);
		m.addAttribute("docs", docs);
		mv = new ModelAndView("viewForm");
		return mv;
	}

	// method to delete document
	@RequestMapping(value = "/deleteDocAdmin/{docId}")
	public ModelAndView deleteDoc(@PathVariable(name = "docId") int docId, ModelAndView mv, Model m,
			HttpServletRequest request) throws IOException {
		String message = "";
		boolean flag = documentservice.deleteDocs(docId);
		if (flag == true) {
			message = "File Deleted Sucesfully";
		} else {
			message = "File Deleted Sucesfully";
		}
		int userIdfk = (int) request.getSession().getAttribute("viewUserId");
		UserBean user = userservice.getById(userIdfk);
		List<Docs> docs = documentservice.getDocsByuserIdFk(userIdfk);
		m.addAttribute("user", user);
		m.addAttribute("docs", docs);
		mv = new ModelAndView("viewForm");
		return mv;
	}

	// method to delete employee
	@RequestMapping(value = "/deleteEmployee/{userId}")
	public ModelAndView deleteEmployee(@PathVariable(name = "userId") int userId, ModelAndView mv, Model m)
			throws IOException {
		String message = "Employee Deleted Successfully";
		userservice.deleteById(userId);
		List<User> userList = userservice.getUserList();
		mv = new ModelAndView("employeeDetails");
		mv.addObject("message1", message);
		m.addAttribute("userList", userList);
		return mv;
	}

	// method to redirect to Add user form
	@RequestMapping(value = "/addUserForm")
	public ModelAndView addUserForm(ModelAndView mv, Model m) {
		m.addAttribute("command", new User());
		return mv;
	}

	// API to get all employee deatils
	@RequestMapping(value = "/employeeDetails")
	public ModelAndView employeeDetails(ModelAndView mv, Model m) {
		String message = "List Of Users. Check For Update/Delete.";
		List<User> userList = userservice.getUserList();
		m.addAttribute("userList", userList);
		mv.addObject("message", message);
		return mv;
	}

	// get User for update
	@RequestMapping(value = "/updateForm/{userId}")
	public ModelAndView viewUpdateScreen(@PathVariable(name = "userId") int userId, ModelAndView mv, Model m,
			HttpServletRequest request) {
		UserBean user = userservice.getById(userId);
		HttpSession session = request.getSession();
		session.setAttribute("updateUserId", userId);
		m.addAttribute("user", user);
		mv = new ModelAndView("updateForm");
		return mv;
	}

	// API to update user
	@RequestMapping(value = "/updateAdminUser")
	public ModelAndView updateUser(@ModelAttribute("user") User user, ModelAndView mv, HttpServletRequest request)
			throws NumberFormatException, IOException {
		int updateUserId = (int) request.getSession().getAttribute("updateUserId");
		String message = "Data Updated sucessful";
		UserBean user2 = userservice.getById(updateUserId);
		User user3 = userMapper.mapToEntity(user2);
		user.setUserName(user3.getUserName());
		user.setPassword(user3.getPassword());
		user.setUserid(updateUserId);
		userservice.updateUser(user);
		mv = new ModelAndView("updateForm");
		mv.addObject("message", message);
		return mv;
	}
}
