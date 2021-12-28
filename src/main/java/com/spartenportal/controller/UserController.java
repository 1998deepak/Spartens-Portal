package com.spartenportal.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spartenportal.bean.RolesBean;
import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.Roles;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.UserMapper;
import com.spartenportal.service.RoleService;
import com.spartenportal.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userservice;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	RoleService roleService;

	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "/userForm2")
	public ModelAndView viewuserform(ModelAndView mv, Model m) {
		return mv;
	}


	// method default mapping to redirect to login page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView viewHomePage(ModelAndView mv, Model m) {
		List<RolesBean> roles = new ArrayList<>();
		roles = roleService.fetchRoleList();
		m.addAttribute("roles", roles);
		mv = new ModelAndView("userLogin");
		sendAutoMail();
		return mv;

	}

	// API to send Auto Mail to all employee working on client side
	@RequestMapping(value = "/sendAutoMail")
	public ResponseEntity<?> sendAutoMail() {
		List<User> users = userservice.getUserList();
		Calendar cal = Calendar.getInstance();
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
		int todaysDate = cal.get(Calendar.DAY_OF_MONTH);
		// replace lastDayOfMonth with todays date (eg : 24 ) for testing
		if (28 == todaysDate) {
			for (User user : users) {
				if (user.getClientCompanyName() != null) {
					String mailTo = user.getEmail();
					SimpleMailMessage msg = new SimpleMailMessage();
					msg.setTo(mailTo);
					msg.setSubject("Remainder from Krios ISPL");
					msg.setText("Dear " + user.getFirstName() + " , \n" + "\nJust an Testing Mail \n" + "\nShare your "
							+ user.getClientCompanyName() + " attendance with us.\n"
							+ "\nRegarding any concerns feel free to contact us on 9999999999\r\n"
							+ "\n\nThanks & Regards," + "\n Finance HR Team");
					javaMailSender.send(msg);
				} else {
					continue;
				}
			}
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/checklogin")
	public ModelAndView loginUser(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, @ModelAttribute("roles") RolesBean roles, ModelAndView mv,
			Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String message = "";
		User user = userservice.findByUserNameAndPassword(username, password);
		if (user != null) {
			String roleName = roles.getRoleName();
			Roles role = roleService.findByRoleName(roleName);
			int match = userservice.checkAuthority(user.getUserid(), role.getRoleId());
			if (match > 0) {
				if (roleName.equals("Admin")) {
					// System.out.println(match);
					session.setAttribute("userId", user.getUserid());
					session.setAttribute("firstName", user.getFirstName());
					message = "Login Sucessfull!";
					mv = new ModelAndView("hrHomepage");
					m.addAttribute(session);

				} else if (roleName.equals("Finance")) {

					session.setAttribute("userId", user.getUserid());
					session.setAttribute("firstName", user.getFirstName());
					message = "Login Sucessfull!";
					mv = new ModelAndView("financePanel");
					m.addAttribute(session);

				}

				else if (roleName.equals("Employee")) {

					session.setAttribute("userId", user.getUserid());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("companyName", user.getClientCompanyName());
					message = "Login Sucessfull!";
					mv = new ModelAndView("userDashboard");
					m.addAttribute(session);

				}

			} else if (roleName.equals("Employee")) {
				session.setAttribute("userId", user.getUserid());
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("companyName", user.getClientCompanyName());
				message = "Login Sucessfull!";
				mv = new ModelAndView("userDashboard");
				m.addAttribute(session);

			}

			else {
				message = "Credential Failed";
				viewHomePage(mv, m);
				mv = new ModelAndView("userLogin");
			}

		}

		else {
			message = "Credential Failed";
			viewHomePage(mv, m);
			mv = new ModelAndView("userLogin");
		}
		m.addAttribute("message", message);

		return mv;
	}

	// API to logout from sessions
	@RequestMapping(value = "/logout")
	public ModelAndView logout(ModelAndView mv, Model m, HttpServletRequest request) {
		request.getSession().invalidate();
		List<RolesBean> roles = new ArrayList<>();
		roles = roleService.fetchRoleList();
		m.addAttribute("roles", roles);
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

	@RequestMapping(value = "/saveUser")
	public ModelAndView registerStudent(ModelAndView mv, @ModelAttribute("user") User user,
			@ModelAttribute("rolesBean") RolesBean rolesBean) throws Exception {
		System.out.println("in save user api");
		rolesBean.setRoleName("Employee");
		userservice.saveUser(user, rolesBean);
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

	// API to update user
	@PostMapping(value = "/updateUser")
	public ModelAndView updateUser(@ModelAttribute("user") User user, ModelAndView mv, HttpServletRequest request)
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
