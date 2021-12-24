package com.spartenportal.serviceimpl;

import java.io.File;
import java.io.IOException;
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
	public Docs saveFile(MultipartFile file ,DocsBean docsBean , User user) {
		//String docname = file.getOriginalFilename();
		try {
			docsBean.setDocName(file.getOriginalFilename());
			docsBean.setDocType(file.getContentType());
			docsBean.setData(file.getBytes());
			//Docs doc = new Docs(docname, file.getContentType(), file.getBytes());
			Docs doc = docsMapper.mapToEntity(docsBean, user);
			return docRepository.save(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
	public void deleteDocs(int docId) {
		// TODO Auto-generated method stub
		docRepository.deleteById(docId);;
	}
}
