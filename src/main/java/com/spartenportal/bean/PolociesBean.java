package com.spartenportal.bean;

import java.util.Date;


public class PolociesBean {
	private Integer policyId;

	private String policyName;
	
	private String policyType;
	
	private Date uploadDate;
	
	private Date modifyDate;
	
	private String policyPath;

	public Integer getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getPolicyPath() {
		return policyPath;
	}

	public void setPolicyPath(String policyPath) {
		this.policyPath = policyPath;
	}

	
}
