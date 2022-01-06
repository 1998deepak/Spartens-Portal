package com.spartenportal.controller;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.AttendanceSheet;
import com.spartenportal.entity.User;
import com.spartenportal.service.AttendanceSheetService;
import com.spartenportal.service.UserService;

@RestController
public class FinanceController {

	@Autowired
	UserService userservice;
	
	@Autowired
	AttendanceSheetService attendanceSheetService;


	// API to get all employee deatils
	@RequestMapping(value = "/financeUserList")
	public ModelAndView financeUserList(ModelAndView mv,  Model m) {
		String message = "List Of Users. Check For Update/Delete.";
		
//		List<User> userList = userservice.getUserList();
//		List<User> financeuserList = new ArrayList<User>();
//		for (User user : userList) {
//			if(user.getClientCompanyName() != null)
//			{
//				financeuserList.add(user);
//			}
//		}
//		m.addAttribute("userList", financeuserList);
		String todaysDate = findTodaysDate();
		sortUserList(mv, "Any", todaysDate, m);
		mv.addObject("todaysDate", todaysDate);
		mv.addObject("message", message);
		return mv;
	}

	@GetMapping("/findTodaysDate")
	public String findTodaysDate() {
		Calendar c= Calendar.getInstance();
		int cyear = c.get(Calendar.YEAR);
		int cmonth = c.get(Calendar.MONTH)+1;
		String todaysDate = cyear+"-"+cmonth;
		return todaysDate;
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
		List<AttendanceSheet> sheets = attendanceSheetService.getSheetByuserIdFk(userId);
		m.addAttribute("sheets", sheets);
		mv = new ModelAndView("financeUserInfo");
		return mv;
	}
	
	@PostMapping(value = "/sortUserList")
	public ModelAndView sortUserList(ModelAndView mv , @RequestParam("uploadStatus") String uploadStatus ,
			@RequestParam("uploadDate") String uploadDate , Model m) {
		int userCount = 0;
		int pendingCount = 0;
		int completedCount = 0;
		String todaysDate = findTodaysDate();
		List<User> userList1 = new ArrayList<>();
		userList1 = userservice.getUserList();
		List<User> sortedUserList = new ArrayList<User>();
		List<AttendanceSheet> financeUserList = new ArrayList<>();
		financeUserList = attendanceSheetService.sortAttendanceSheet(uploadDate);
		List<User> userList = new ArrayList<User>();
		for (User user : userList1) {
			if(user.getClientCompanyName() != null)
			{
				userList.add(user);
			}
		}
		List<User> usersList = new ArrayList<User>();
		for (User user : userList) {
			usersList.add(user);
			userCount++;
		}
		if(uploadStatus.equalsIgnoreCase("Any")) {
			m.addAttribute("userList", usersList);
		}
		else if(uploadStatus.equalsIgnoreCase("Pending")) {
			for (User user : userList) {
				for(AttendanceSheet attendanceSheet : financeUserList) {
					if(user.getUserid() == attendanceSheet.getUser().getUserid())
					{
						sortedUserList.add(user);
					}
				}
			}
			usersList.removeAll(sortedUserList);
			m.addAttribute("userList", usersList);
		}
		else if(uploadStatus.equalsIgnoreCase("Completed")) {
			for (User user : userList) {
				for(AttendanceSheet attendanceSheet : financeUserList) {
					if(user.getUserid() == attendanceSheet.getUser().getUserid())
					{
						sortedUserList.add(user);
					}
				}
			}
			m.addAttribute("userList", sortedUserList);
		}
		for (User user : userList) {
			for(AttendanceSheet attendanceSheet : financeUserList) {
				if(user.getUserid() == attendanceSheet.getUser().getUserid())
				{
					completedCount++;
				}
			}
		}
		pendingCount = userCount - completedCount;

		m.addAttribute("todaysDate", todaysDate);
		m.addAttribute("userCount", userCount);
		m.addAttribute("pendingCount", pendingCount);
		m.addAttribute("completedCount", completedCount);
		mv = new ModelAndView("financeUserList");
		return mv;
	}
}
