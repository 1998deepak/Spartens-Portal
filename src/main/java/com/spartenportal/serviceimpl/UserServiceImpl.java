package com.spartenportal.serviceimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.spartenportal.bean.RolesBean;
import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.Roles;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.RolesMapper;
import com.spartenportal.mapper.UserMapper;
import com.spartenportal.repository.RolesRepository;
import com.spartenportal.repository.UserRepository;
import com.spartenportal.service.UserService;
import java.util.Properties;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.time.Month;
import java.time.LocalDate;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Value("${finance.username}")
	private String financeUsername;

	@Value("${finance.password}")
	private String financepassword;

	@Value("${hr.username}")
	private String hrUsername;

	@Value("${hr.password}")
	private String hrpassword;

	@Autowired
	private JavaMailSender send;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	RolesMapper rolesMapper;

	@Autowired
	RolesRepository rolesRepository;

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		User user = userRepo.findByUserNameAndPassword(userName, password);
		return user;
	}

	@Override
	public void sendEmail(String to, String body, String topic) {
		System.out.println("sending..........!");
		String from = hrUsername;
		// Variable for gmail
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(hrUsername, hrpassword);
			}
		});

		session.setDebug(true);

		// Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		String[] cc = { "deepaktiwade19@gmail.com" };

		try {

			// from email
			m.setFrom(from);
			for (int i = 0; i < cc.length; i++) {
				m.addRecipients(Message.RecipientType.CC, cc[i]);
			}
			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			m.setSubject(topic);

			// adding text to message
			// m.setText(message);
			m.setContent(body, "text/html");

			// send

			// Step 3 : send the message using Transport class
			Transport.send(m);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public ResponseEntity<?> saveUser(User user, RolesBean roleBean) {
		Roles roles = rolesMapper.mapToEntity(roleBean);
		List<Roles> role = rolesRepository.findByName(roles.getRoleName());
		user.setRoles(role);
		userRepo.save(user);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateUser(User user) {
		user.setModifyDate(new Date());
		userRepo.saveAndFlush(user);
		return new ResponseEntity<>("success", HttpStatus.OK);
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
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, " User Record Not Found");
		}
		return response;
	}

	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);
	}

	@Override
	public int checkAuthority(int userId, int roleId) {
		// TODO Auto-generated method stub
		int res;
		Optional<Integer> data = userRepo.checkAuthority(userId, roleId);
		if (data.isPresent()) {
			res = 1;
		} else
			res = 0;
		return res;
	}

	@Override
	public void sendAutoMailFinance(List<User> users) {
		Calendar cal = Calendar.getInstance();
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
		int todaysDate = cal.get(Calendar.DAY_OF_MONTH);
		Date d = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
		String date = formatter.format(d);
		LocalDate currentDate = LocalDate.parse(date);

		// Get month from date
		Month month = currentDate.getMonth();

		// Get year from date
		int year = currentDate.getYear();
		String from = financeUsername;
		// Variable for gmail
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(financeUsername, financepassword);
			}
		});

		session.setDebug(true);
		
		String[] cc = { "yogesh.daspute@kriosispl.com" };
		// replace lastDayOfMonth with todays date (eg : 24 ) for testing
		if (lastDayOfMonth == todaysDate) {
			for (User user : users) {
				if (user.getClientCompanyName() != null) {
					String mailTo = user.getEmail();
					
					// Step 2 : compose the message [text,multi media]
					MimeMessage m = new MimeMessage(session);

					try {

						// from email
						m.setFrom(from);
						for (int i = 0; i < cc.length; i++) {
							m.addRecipients(Message.RecipientType.CC, cc[i]);
						}
						// adding recipient to message
						m.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));

						// adding subject to message
						m.setSubject("Remainder from Krios ISPL");

						// adding text to message
						// m.setText(message);
						String body = "<html><body>Dear " + user.getFirstName() + " ,<br><br>" + "Request you to submit "
								+ month +" "+ year +" "+user.getClientCompanyName()+" "+"timesheet to us for further processing." + "<br><br>Feel free to reach us, in case of any queries.<br><br>Thanks & Regards,"
								+ "<br> Finance Team</body></html>";
						m.setContent(body, "text/html");

						// send

						// Step 3 : send the message using Transport class
						Transport.send(m);

					} catch (Exception e) {
						e.printStackTrace();
					}

				} else {
					continue;
				}
			}
		}
	}
	
	public boolean resetPasswordEamil(String subject,String message,String to) {
		// TODO Auto-generated method stub
		
		boolean f=false;
		
		String from=hrUsername;
		//Variable for gmail
		String host="smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES "+properties);
		
		//setting important information to properties object
		
		//host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//Step 1: to get the session object..
		Session session=Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication(hrUsername,hrpassword);
			}
			
			
			
		});
		
		session.setDebug(true);
		
		//Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);
		
		try {
		
		//from email
		m.setFrom(from);
		
		//adding recipient to message
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		//adding subject to message
		m.setSubject(subject);
	
		
		//adding text to message
		//m.setText(message);
		m.setContent(message,"text/html");
		
		//send 
		
		//Step 3 : send the message using Transport class
		Transport.send(m);
		
		System.out.println("Sent success...................");
		f=true;
		
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return f;
			
	}
	
	public void sendIntimateMail(String to, String body, String topic) {
		System.out.println("sending..........!");
		String from = financeUsername;
		// Variable for gmail
		String host = "smtp.kriosispl.in";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
//		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(financeUsername, financepassword);
			}
		});

		session.setDebug(true);

		// Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);

		try {

			// from email
			m.setFrom(from);

			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			m.setSubject(topic);

			// adding text to message
			// m.setText(message);
			m.setContent(body, "text/html");

			// send

			// Step 3 : send the message using Transport class
			Transport.send(m);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}