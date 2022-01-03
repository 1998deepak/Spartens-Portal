package com.spartenportal.serviceimpl;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spartenportal.bean.DocsBean;
import com.spartenportal.entity.Docs;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.DocsMapper;
import com.spartenportal.repository.DocRepository;
import com.spartenportal.service.DocumentsService;

/*
 * Service implementaion class for Documents
 * author Ankita
 * date 22/11/2021
 */
@Service
public class DocumentsServiceImpl implements DocumentsService {

	@Autowired
	private DocRepository docRepository;
	
	@Autowired
	DocsMapper docsMapper;

	@Override
	public boolean saveFile(MultipartFile file ,DocsBean docsBean , User user) {
		String uploadDir = "E:\\Uploaded Documents";
		uploadDir =uploadDir+File.separator+user.getFirstName()+" "+user.getMiddleName()+" "+user.getLastName();
		boolean flag = false;
		try {
			docsBean.setDocName(file.getOriginalFilename());
			docsBean.setDocType(file.getContentType());
			docsBean.setDocPath(uploadDir+File.separator+file.getOriginalFilename());
			docsBean.setUploadDate(new Date());
			Docs doc = docsMapper.mapToEntity(docsBean, user);
			File f1 = new File(uploadDir);  
		      //Creating a folder using mkdir() method  
		      boolean bool = f1.mkdir();  
			
			Files.copy(file.getInputStream(), Paths.get(f1 + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			flag = true;
			 docRepository.save(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Optional<Docs> getFile(Integer fileId) {
		return docRepository.findById(fileId);
	}

	@Override
	public List<Docs> getFiles() {
		System.out.println("in service");
		return docRepository.findAll();
	}

	@Override
	public List<Docs> getDocsByuserIdFk(int userId) {
		// TODO Auto-generated method stub
		return docRepository.getDocsByuserId(userId);
	}

	@Override
	public boolean deleteDocs(int docId) {
		Docs docs = docRepository.getById(docId);
		File file = new File(docs.getDocPath());
		if(file.delete())
		{
			docRepository.deleteById(docId);
			return true;	
		}
		else {
		return false;
		}		
	}
}
