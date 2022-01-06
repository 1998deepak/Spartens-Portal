package com.spartenportal.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "policies")
public class Policies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer policyId;

	private String policyName;
	
	private String policyType;
	
	@Temporal(TemporalType.DATE)
	private Date uploadDate;
	
	@Temporal(TemporalType.DATE)
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
