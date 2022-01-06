package com.spartenportal.serviceimpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spartenportal.entity.Policies;
import com.spartenportal.repository.PoliciesRepository;
import com.spartenportal.service.PoliciesService;


@Service
public class PoliciesServiceImpl implements PoliciesService {

	@Autowired
	PoliciesRepository policyRepo;

	@Override
	public boolean uploadFile(MultipartFile file) {
		String uploadDir = "E:\\Uploaded Documents";
		uploadDir =uploadDir+File.separator+"Policies";
		Policies policy = new Policies();
		policy.setPolicyName(file.getOriginalFilename());
		policy.setPolicyType(file.getContentType());
		policy.setPolicyPath(uploadDir+File.separator+file.getOriginalFilename());
		policy.setUploadDate(new Date());
		File f1 = new File(uploadDir);  
	      //Creating a folder using mkdir() method  
	      boolean bool = f1.mkdir();  
		boolean flag = false;
		try {
			
			Files.copy(file.getInputStream(), Paths.get(f1 + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			flag = true;
			policyRepo.save(policy);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	@Override
	public Optional<Policies> getPolcies(Integer fileId) {
		return policyRepo.findById(fileId);
	}

	@Override
	public List<Policies> getAllPolicies() {
		// TODO Auto-generated method stub
		return policyRepo.findAll();
	}

	@Override
	public boolean deleteFile(Integer fileId) {
		Policies policy = policyRepo.getById(fileId);
		File file = new File(policy.getPolicyPath());
		if(file.delete())
		{
			policyRepo.deleteById(fileId);
			return true;	
		}
		else {
		return false;
		}
	}
}
