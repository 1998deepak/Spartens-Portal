package com.spartenportal.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
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
import com.spartenportal.entity.Docs;
import com.spartenportal.entity.User;
import com.spartenportal.service.DocumentsService;
import com.spartenportal.service.UserService;


/*
 * Rest controller for documents
 * author Ankita
 * date 22/11/2021
 */

@RestController
public class DocumentsController {

	@Autowired
	DocumentsService documentservice;
	
	@Autowired
	UserService userservice;
	
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
			user.setUserid(userIdfk);
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
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Integer fileId){
		Docs doc = documentservice.getFile(fileId).get();
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(doc.getDocType()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+doc.getDocName()+"\"")
				.body(new ByteArrayResource(doc.getData()));
	}
	
	// method to delete document
		@RequestMapping(value = "/deleteDoc/{docId}")
		public ModelAndView deleteDoc(@PathVariable(name = "docId") int docId, ModelAndView mv, Model m,HttpServletRequest request) throws IOException {
			String message ="Document Deleted Successfully";
			documentservice.deleteDocs(docId);
			int userIdfk=(int) request.getSession().getAttribute("userId");
			List<Docs> docs = documentservice.getDocsByuserIdFk(userIdfk);
			mv = new ModelAndView("doc");
			mv.addObject("message1", message);
			m.addAttribute("docs", docs);
			return mv;
		}
}
