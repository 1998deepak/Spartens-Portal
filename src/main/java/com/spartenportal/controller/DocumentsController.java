package com.spartenportal.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spartenportal.bean.DocsBean;
import com.spartenportal.bean.UserBean;
import com.spartenportal.entity.Docs;
import com.spartenportal.entity.Policies;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.UserMapper;
import com.spartenportal.repository.DocRepository;
import com.spartenportal.service.DocumentsService;
import com.spartenportal.service.UserService;


/*
 * Rest controller for documents
 * author Deepak
 * date 22/11/2021
 */

@RestController
public class DocumentsController {

	@Autowired
	DocumentsService documentservice;
	
	@Autowired
	UserService userservice;
	
	@Autowired
	DocRepository docrepo;
	
	@Autowired
	private UserMapper userMapper;
	
	//API get all documents and send to documents form
	@GetMapping("/doc")
	public ModelAndView  get(ModelAndView mv,Model m,HttpServletRequest request) {	
		int userIdfk=(int) request.getSession().getAttribute("userId");
		List<Docs> docs = documentservice.getDocsByuserIdFk(userIdfk);
		if(docs == null)
		{
			return mv;
		}
		else 
		{
			m.addAttribute("docs", docs);
		}
		return mv;
	}
	
	//API to save files in database
		@PostMapping("/uploadFiles")
		public ModelAndView uploadMultipleFiles(@RequestParam("files") MultipartFile[] files,ModelAndView mv,Model m,
				@ModelAttribute("user") User user, @ModelAttribute("docsBean") DocsBean docsBean,
				HttpServletRequest request) {
			int userIdfk=(int) request.getSession().getAttribute("userId");
//			user.setUserid(userIdfk);
			UserBean userBean = userservice.getById(userIdfk);
			user=userMapper.mapToEntity(userBean);
			for (MultipartFile file: files) {
				documentservice.saveFile(file,docsBean , user);	
			}
			List<Docs> docs = documentservice.getDocsByuserIdFk(userIdfk);
			String message = "Document uploaded Sucesfully";
			mv = new ModelAndView("doc");
			mv.addObject("message", message);
			m.addAttribute("docs", docs);
			return mv;
		}
	
	// API to download files that exist in database
	@GetMapping(value="/downloadFile/{fileId}",produces = MediaType.ALL_VALUE)
	public ResponseEntity<Object> downloadFile(@PathVariable Integer fileId)throws IOException {
		Docs docs = documentservice.getFile(fileId).get();
		File file = new File(docs.getDocPath());
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length())
				.contentType(MediaType.parseMediaType("application/txt")).body(resource);

		return responseEntity;
	}
	
	// method to delete document
		@RequestMapping(value = "/deleteDoc/{docId}")
		public ModelAndView deleteDoc(@PathVariable(name = "docId") int docId, ModelAndView mv, Model m,HttpServletRequest request) throws IOException {
			String message ="";
			boolean flag = documentservice.deleteDocs(docId);
			if(flag == true)
			{
				message ="File Deleted Sucesfully";
			}
			else {
				message ="File Deleted Sucesfully";
			}
			int userIdfk=(int) request.getSession().getAttribute("userId");
			List<Docs> docs = documentservice.getDocsByuserIdFk(userIdfk);
			mv = new ModelAndView("doc");
			mv.addObject("message1", message);
			m.addAttribute("docs", docs);
			return mv;
		}
		
		@RequestMapping("/viewDoc/{docId}")
		public ModelAndView getPdf(@PathVariable Integer docId,ModelAndView mv,Model m,HttpServletRequest request) throws Exception
		{
			Docs docs1 = documentservice.getFile(docId).get();
			Process p = Runtime
					   .getRuntime()
					   .exec("rundll32 url.dll,FileProtocolHandler "+docs1.getDocPath());
					p.waitFor();
					mv.addObject(p);
					int userIdfk=(int) request.getSession().getAttribute("userId");
					List<Docs> docs = documentservice.getDocsByuserIdFk(userIdfk);
					mv = new ModelAndView("doc");
					m.addAttribute("docs", docs);
			return mv;
		}
		
		
}
