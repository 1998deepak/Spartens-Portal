package com.spartenportal.mapper;

import org.springframework.stereotype.Component;

import com.spartenportal.bean.DocsBean;
import com.spartenportal.entity.Docs;
import com.spartenportal.entity.User;


@Component
public class DocsMapper {
	
	public DocsBean mapToBean(Docs docs) {
		DocsBean docsBean = new DocsBean();
		docsBean.setDocId(docs.getDocId());
		docsBean.setDocName(docs.getDocName());
		docsBean.setDocType(docs.getDocType());
		docsBean.setDocPath(docs.getDocPath());
		docsBean.setUploadDate(docs.getUploadDate());
		docsBean.setUserid(docs.getUser().getUserid());
		return docsBean;
	}

	public Docs mapToEntity(DocsBean docsBean , User user) {
		Docs docs = new Docs();
		docs.setDocId(docsBean.getDocId());
		docs.setDocName(docsBean.getDocName());
		docs.setDocType(docsBean.getDocType());
		docs.setDocPath(docsBean.getDocPath());
		docs.setUploadDate(docsBean.getUploadDate());
		docs.setUser(user);
		return docs;
	}
}
