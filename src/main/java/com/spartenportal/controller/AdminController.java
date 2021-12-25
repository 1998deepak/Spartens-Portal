package com.spartenportal.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
import com.spartenportal.service.UserService;

@RestController
public class AdminController {

	@Autowired
	UserService userservice;

	@Autowired
	DocumentsService documentservice;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private UserMapper userMapper;
	
	// method default mapping to redirect to login page
	@RequestMapping(value = "/")
	public ModelAndView viewHomePage(ModelAndView mv) {
		mv = new ModelAndView("userLogin");
		sendAutoMail();
		return mv;
	}

	// method to redirect to HR-dashboard
	@RequestMapping(value = "/hrHomepage")
	public ModelAndView adminHomePage(ModelAndView mv, Model m) {
		return mv;
	}

	// method to redirect to Update form
	@RequestMapping(value = "/viewForm/{userId}")
	public ModelAndView viewUserForm(@PathVariable(name = "userId") int userId, ModelAndView mv, Model m) {
		UserBean user = userservice.getById(userId);
		List<Docs> docs = documentservice.getDocsByuserIdFk(userId);
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

	// method to redirect to Reports page
//	@RequestMapping(value = "/reports")
//	public ModelAndView reportsPage(ModelAndView mv, Model m) {
//		m.addAttribute("total", userservice.countEmployee());
//		return mv;
//	}

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

	// API to get all employee deatils for sending mail
	@RequestMapping(value = "/sendMail")
	public ModelAndView sendMail(ModelAndView mv, Model m) {
		List<User> userList = userservice.getUserList();
		m.addAttribute("userList", userList);
		return mv;
	}

	// get User for update
	@RequestMapping(value = "/updateForm/{userId}")
	public ModelAndView viewUpdateScreen(@PathVariable(name = "userId") int userId, ModelAndView mv, Model m,HttpServletRequest request) {
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

	// API to update Client Company name
	@RequestMapping(value = "/UpdateCompanyName/{userId}/{clientCompanyName}")
	public ModelAndView UpdateCompanyName(@PathVariable(name = "userId") int userId,
			@PathVariable(name = "clientCompanyName") String clientCompanyName, ModelAndView mv, Model m) {
		UserBean userBean = userservice.getById(userId);
		User user =userMapper.mapToEntity(userBean);
		user.setClientCompanyName(clientCompanyName);
		userservice.updateUser(user);
		return mv;
	}

	// API to send Auto Mail to all employee working on client side
	@RequestMapping(value = "/sendAutoMail")
	public ResponseEntity<?> sendAutoMail(){
		List<User> users = userservice.getUserList();
		Calendar cal = Calendar.getInstance();
	    int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
	    int todaysDate = cal.get(Calendar.DAY_OF_MONTH);
	    // replace lastDayOfMonth with todays date (eg : 24 ) for testing
	    if(lastDayOfMonth == todaysDate) {
	    	for(User user : users) {
	    		if(user.getClientCompanyName() != null) {
	    			String mailTo = user.getEmail();
	    			SimpleMailMessage msg = new SimpleMailMessage();
	    	        msg.setTo(mailTo);
	    	        msg.setSubject("Remainder from Krios ISPL");
	    	        msg.setText("Dear "+user.getFirstName()+" , \n"
	    	        		+ "\nJust an Testing Mail \n"
	    	        		+ "\nShare your "+user.getClientCompanyName()+" attendance with us.\n"
	    	        		+ "\nRegarding any concerns feel free to contact us on 9999999999\r\n"
	    	        		+ "\n\nThanks & Regards,"
	    	        		+ "\n Finance HR Team");
	    	        javaMailSender.send(msg);
	    		}
	    		else {
	    			continue;
	    		}
	    	}
	    }
		return new ResponseEntity<>(HttpStatus.OK);
	}
} 
