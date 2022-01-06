package com.spartenportal.service;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.spartenportal.bean.DocsBean;
import com.spartenportal.entity.Docs;
import com.spartenportal.entity.User;

/*
 * Service class for Documents
 * author Ankita
 * date 22/11/2021
 */

public interface DocumentsService {

	public List<Docs> getDocsByuserIdFk(int userId);
	
	public Optional<Docs> getFile(Integer fileId);

	public List<Docs> getFiles();

	public boolean saveFile(MultipartFile file ,DocsBean docsBean , User user);
	
	public boolean deleteDocs(int docId);
}
