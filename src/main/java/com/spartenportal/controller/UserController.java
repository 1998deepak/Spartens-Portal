package com.spartenportal.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
import com.spartenportal.excelexporter.ExcelExporter;
import com.spartenportal.mapper.UserMapper;
import com.spartenportal.repository.UserRepository;
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
	UserRepository userRepo;

	Random random = new Random(1000);

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
//		sendAutoMail();
		return mv;

	}

	// API to send Auto Mail to all employee working on client side
	@RequestMapping(value = "/sendAutoMail")
	public ResponseEntity<?> sendAutoMail() {
		List<User> users = userservice.getUserList();
		userservice.sendAutoMailFinance(users);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/checklogin")
	public ModelAndView loginUser(@RequestParam(name = "username") String username,
			@RequestParam(name = "password") String password, @ModelAttribute("roles") RolesBean roles, ModelAndView mv,
			Model m, HttpServletRequest request) {
		HttpSession session = request.getSession();
		String wrongmessage = "";
		String sucessmessage = "";
		User user = userservice.findByUserNameAndPassword(username, password);
		
		if (user != null) {
			UserBean userBean = userMapper.mapToBean(user);
			String roleName = roles.getRoleName();
			Roles role = roleService.findByRoleName(roleName);
			int match = userservice.checkAuthority(user.getUserid(), role.getRoleId());
			if (match > 0 || userBean.getRoleName().equals("Super Admin")) {
				if (roleName.equals("Admin")) {
					session.setAttribute("userId", user.getUserid());
					session.setAttribute("firstName", user.getFirstName());
					sucessmessage = "Login Sucessfull!";
					m.addAttribute("sucessmessage", sucessmessage);
					mv = new ModelAndView("hrHomepage");
					m.addAttribute(session);
				} else if (roleName.equals("Finance")) {
					session.setAttribute("userId", user.getUserid());
					session.setAttribute("firstName", user.getFirstName());
					sucessmessage = "Login Sucessfull!";
					m.addAttribute("sucessmessage", sucessmessage);
					mv = new ModelAndView("financePanel");
					m.addAttribute(session);
				} else if (roleName.equals("Employee")) {
					session.setAttribute("userId", user.getUserid());
					session.setAttribute("firstName", user.getFirstName());
					session.setAttribute("companyName", user.getClientCompanyName());
					sucessmessage = "Login Sucessfull!";
					m.addAttribute("sucessmessage", sucessmessage);
					mv = new ModelAndView("userDashboard");
					m.addAttribute(session);
				}
			} else if (roleName.equals("Employee")) {
				session.setAttribute("userId", user.getUserid());
				session.setAttribute("firstName", user.getFirstName());
				session.setAttribute("companyName", user.getClientCompanyName());
				sucessmessage = "Login Sucessfull!";
				m.addAttribute("sucessmessage", sucessmessage);
				mv = new ModelAndView("userDashboard");
				m.addAttribute(session);
			} else {
				wrongmessage = "Credential Failed";
				m.addAttribute("wrongmessage", wrongmessage);
				viewHomePage(mv, m);
				mv = new ModelAndView("userLogin");
			}
		} else {
			wrongmessage = "Credential Failed";
//			session.setAttribute("wrongmessage", wrongmessage);
			m.addAttribute("wrongmessage", wrongmessage);
			viewHomePage(mv, m);
			mv = new ModelAndView("userLogin");
		}
		
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

		String message = "<html><body>Hello " + user.getFirstName() + " " + user.getLastName()
				+ ",  <br><br>Welcome to Krios Info Solutions Pvt Ltd, Pune  !!<br><br>"
				+ "Congratulations on being part of our dynamic team!  The entire office welcomes you and we hope to have a long and successful journey together. <br><br>"
				+ "As discussed with you, please fill all your data in the employement form on our krios portal "
				+ "and upload mention documents.<br><br>Krios Portal Link : www.kriosportal.com<br><br>"
				+ "---------------------------------<br>" + " Login Details<br>"
				+ "---------------------------------<br>" + " UserName : " + user.getUserName() + "<br> Password : "
				+ user.getPassword() + "<br>----------------------------------"
				+ "<br><br> Please feel free to ask if you have any questions or queries.  <br><br> Thanks & Regards,<br> HR Executive";
		userservice.sendEmail(user.getEmail(), message, "Krios Employement Form");
		userservice.saveUser(user, rolesBean);
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

	@GetMapping("/export")
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
		response.setHeader(headerKey, headerValue);

		List<User> listUsers = userservice.getUserList();

		ExcelExporter excelExporter = new ExcelExporter(listUsers);

		excelExporter.export(response);
	}

	// email id from open handler
	@RequestMapping("/forgotemailform")
	public ModelAndView openEmailForm(ModelAndView mv) {
		return mv;
	}

	@PostMapping("/send-otp")
	public ModelAndView sendOTP(@RequestParam("email") String email, HttpSession sessionOTP, ModelAndView mv, Model m) {

		// genrating otp of 4 digit

		int otp = random.nextInt(999999);
		// write code for send otp to email
		String subject = "OTP From Krios Info Solutions Pvt Ltd, Pune ";
		String message = "" + "<div style='border:1px solid #e2e2e2;padding:20px'>" + "<h1>" + "OTP is :" + "<b>" + otp
				+ "</b>" + "</h1>" + "</div>";
		String to = email;

		User user = this.userRepo.getUserByUserEmail(email);
		if (user == null) {
			// send error message
			m.addAttribute("message2", "User Does Not Exits with this email..!!");
			mv = new ModelAndView("forgotemailform");
			return mv;
		} else {
			boolean flag = this.userservice.resetPasswordEamil(subject, message, to);

			if (flag) {
				sessionOTP.setAttribute("myotp", otp);
				sessionOTP.setAttribute("email", email);
				mv = new ModelAndView("verifyotp");
				return mv;
			} else {
				m.addAttribute("message1", "Check your Email id");
				mv = new ModelAndView("forgotemailform");
				return mv;
			}

		}
	}

	// verify otp
	@PostMapping("/verify-otp")
	public ModelAndView verifyOtp(@RequestParam("otp") int otp, HttpSession sessionOTP, ModelAndView mv, Model m) {

		int myOtp = (Integer) sessionOTP.getAttribute("myotp");
		String email = (String) sessionOTP.getAttribute("email");
		if (myOtp == otp) {
			// Password change form

			User user = this.userRepo.getUserByUserEmail(email);
			if (user == null) {
				// send error message
				m.addAttribute("message2", "User Does Not Exits with this email..!!");
				mv = new ModelAndView("forgotemailform");
				return mv;
			} else {
				// send change password form
			}
			mv = new ModelAndView("passwordchangeform");
			return mv;
		} else {

			m.addAttribute("message1", "YOU Have Enter Wrong otp");
			mv = new ModelAndView("verifyotp");
			return mv;
		}

	}

	// change password
	@PostMapping("/change-password")
	public ModelAndView changePassword(@RequestParam("newpassword") String newpassword, HttpSession sessionOTP,
			ModelAndView mv, Model m) {
		String email = (String) sessionOTP.getAttribute("email");
		User user = this.userRepo.getUserByUserEmail(email);
		user.setPassword(newpassword);
		this.userRepo.save(user);
		m.addAttribute("message", "Change password succesfully..!!");
		List<RolesBean> roles = new ArrayList<>();
		roles = roleService.fetchRoleList();
		m.addAttribute("roles", roles);
		mv = new ModelAndView("userLogin");
		return mv;

	}
	
	// API to send Remainder to HR regarding of information of employee's who will complete 3 months in company
		@GetMapping(value="/remainderMailForThreeMonths")
		public ResponseEntity<?> remainderMailForThreeMonths() {
			List<User> users = userservice.getUserList();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar calender = Calendar.getInstance();
			Date date = new Date();
			String todaysDate = dateFormat.format(date);
			for(User user : users) {
				Date empJoiningDate = user.getJoinTime();
				//String joiningDate = dateFormat.format(empJoiningDate);
				
				calender.setTime(empJoiningDate);
				calender.add(Calendar.MONTH, 3);
				Date threeMonthsCompletionDate = calender.getTime();
				String threeMonthAnniversary = dateFormat.format(threeMonthsCompletionDate);
				
				calender.setTime(threeMonthsCompletionDate);
				calender.add(Calendar.DAY_OF_YEAR, -14);
				Date remainderDate = calender.getTime();
				String remainderDateToHr = dateFormat.format(remainderDate);
				
				if(todaysDate.equals(remainderDateToHr)) {
					String subject = "Reaminder for Three Month Completion ..!";
					String message = "<html>"
							+ "One of our Kriosian "
							+ "<br><b>"+user.getFirstName()+" "+user.getLastName()+"</b> will successfully complete"
									+ " Three Months after Two weeks ."
									+ "<br> Three Month Anniversay on <b>"+threeMonthAnniversary+"</b>"
							+ "</html>";
					String to = "sejalshelke4783@gmail.com";	 // replace this mail Id with HR's mail ID
					userservice.sendIntimateMail(to, message,  subject);
				}else {
					continue;
				}
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		
		
		// API to send Remainder to HR regarding of information of employee's who will complete 6 months in company
			@GetMapping(value="/remainderMailForSixMonths")
			public ResponseEntity<?> remainderMailForSixMonths() {
				List<User> users = userservice.getUserList();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Calendar calender = Calendar.getInstance();
				Date date = new Date();
				String todaysDate = dateFormat.format(date);
				for(User user : users) {
					Date empJoiningDate = user.getJoinTime();
					//String joiningDate = dateFormat.format(empJoiningDate);
					
					calender.setTime(empJoiningDate);
					calender.add(Calendar.MONTH, 6);
					Date sixMonthsCompletionDate = calender.getTime();
					String sixMonthAnniversary = dateFormat.format(sixMonthsCompletionDate);
					
					calender.setTime(sixMonthsCompletionDate);
					calender.add(Calendar.DAY_OF_YEAR, -14);
					Date remainderDate = calender.getTime();
					String remainderDateToHr = dateFormat.format(remainderDate);
					
					if(todaysDate.equals(remainderDateToHr)) {
						String subject = "Reaminder for Six Month Completion ..!";
						String message = "<html>"
								+ "One of our Kriosian "
								+ "<br><b>"+user.getFirstName()+" "+user.getLastName()+"</b> will successfully complete"
										+ " Six Months after Two Weeks ."
										+ "<br> Six Month Anniversary on <b>"+sixMonthAnniversary+"</b>"
								+ "</html>";
						String to = "sejalshelke4783@gmail.com";  // replace this mail Id with HR's mail ID
						userservice.sendIntimateMail(to, message,  subject);
					}else {
						continue;
					}
				}
				return new ResponseEntity<>(HttpStatus.OK);
			}
}
