package com.spartenportal.serviceimpl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.UserMapper;
import com.spartenportal.repository.UserRepository;
import com.spartenportal.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	private JavaMailSender send ;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		User user = userRepo.findByUserNameAndPassword(userName, password);
		return user;
	}
	
	@Override
	public void sendEmail(String to, String body, String topic)
	{
		System.out.println("sending..........!");
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("krioshr66@gmail.com");
		mail.setTo(to);
		mail.setSubject(topic);
		mail.setText(body);
		
		send.send(mail);
		System.out.println("send mail...........!");
	}

	@Override
	public ResponseEntity<?> saveUser(User user) {
		userRepo.save(user);
		return new ResponseEntity<>("success",HttpStatus.OK);	
	}


	@Override
	public ResponseEntity<?> updateUser(User user) {
		userRepo.saveAndFlush(user);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}


	@Override
	public void deleteUser(User user) {
		userRepo.delete(user);
	}


	@Override
	public List<User> getUserList() {
		return userRepo.findAll();
	}


	@Override
	public List<User> getUsersByRole(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public UserBean getById(int id) {
		UserBean response = null;
		Optional<User> userData = userRepo.findById(id);
		if (userData.isPresent()) {
			UserBean udata = userMapper.mapToBean(userData.get());
			response = udata;
			
		} else {
			throw  new ResponseStatusException(HttpStatus.BAD_REQUEST," User Record Not Found");
		}
		return response;
	}


	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);		
	}
}