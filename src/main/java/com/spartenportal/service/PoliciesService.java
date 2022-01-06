package com.spartenportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.spartenportal.entity.Policies;


public interface PoliciesService {

	public boolean uploadFile(MultipartFile file);

	public Optional<Policies> getPolcies(Integer fileId);
	
	public List<Policies> getAllPolicies();
	
	public boolean deleteFile(Integer fileId);
}
