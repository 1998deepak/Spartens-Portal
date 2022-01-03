package com.spartenportal.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.spartenportal.entity.Policies;
import com.spartenportal.service.PoliciesService;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@RestController
public class PoliciesController {

	@Autowired
	PoliciesService policiesService;

	@RequestMapping("/policiesForm")
	public ModelAndView policiesForm(ModelAndView mv, Model m) {
		List<Policies> policyList = policiesService.getAllPolicies();
		m.addAttribute("policyList", policyList);
		return mv;
	}

	@PostMapping("/upload-File")
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file,ModelAndView mv ,Model m) {
		if (file.isEmpty()) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is empty");
		}
		String msg ="";
		boolean flag = policiesService.uploadFile(file);
		if (flag) {
			msg="file uploaded sucesfully";
		}
		mv.addObject("msg", msg);
		List<Policies> policyList = policiesService.getAllPolicies();
		m.addAttribute("policyList", policyList);
		mv = new  ModelAndView("policiesForm");
		return mv;

	}

	@RequestMapping(value = "/downloadPolicy/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<Object> downloadFile(@PathVariable Integer fileId) throws IOException {
		Policies policy = policiesService.getPolcies(fileId).get();
		String filename = policy.getPolicyPath();
		File file = new File(filename);
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

	@GetMapping("/viewPolicy")
	public ModelAndView getAllPolicies(ModelAndView mv,Model m) {
		List<Policies> policyList = policiesService.getAllPolicies();
		m.addAttribute("policyList", policyList);
		return mv;

	}
	
	@RequestMapping(value ="/deletePolicy/{fileId}")
	public ModelAndView deletePolicy(@PathVariable Integer fileId,ModelAndView mv,Model m)
	{
		boolean flag=policiesService.deleteFile(fileId);
		String deleteMsg =null;
		if(flag == true)
		{
			deleteMsg ="File Deleted Sucesfully";
		}
		else {
			deleteMsg ="File Deleted Sucesfully";
		}
		List<Policies> policyList = policiesService.getAllPolicies();
		m.addAttribute("policyList", policyList);
		mv.addObject("deleteMsg", deleteMsg);
		mv = new  ModelAndView("policiesForm");
		return mv;	
	}
	
	@RequestMapping("/viewFile/{fileId}")
	public ModelAndView getPdf(@PathVariable Integer fileId,ModelAndView mv,Model m) throws Exception
	{
		Policies policy = policiesService.getPolcies(fileId).get();
		Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler "+policy.getPolicyPath());
				p.waitFor();
				mv.addObject(p);
				List<Policies> policyList = policiesService.getAllPolicies();
				m.addAttribute("policyList", policyList);
		mv = new ModelAndView("viewPolicy");
		return mv;
	}
	
	@RequestMapping("/viewPDF/{fileId}")
	public ModelAndView viewPdf(@PathVariable Integer fileId,ModelAndView mv,Model m) throws Exception
	{
		Policies policy = policiesService.getPolcies(fileId).get();
		Process p = Runtime
				   .getRuntime()
				   .exec("rundll32 url.dll,FileProtocolHandler "+policy.getPolicyPath());
				p.waitFor();
				mv.addObject(p);
				List<Policies> policyList = policiesService.getAllPolicies();
				m.addAttribute("policyList", policyList);
				mv = new ModelAndView("policiesForm");
		return mv;
	}
}
