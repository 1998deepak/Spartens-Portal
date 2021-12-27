package com.spartenportal.entity;

import java.util.Date;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

public class AttendanceSheet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sheetId;

	private String sheetName;
	
	private String sheetType;

	private Date currentDate;
	
	private Date modifyDate;
	
	@Lob
	private byte[] sheet;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userid")
	private User user;

	public Integer getSheetId() {
		return sheetId;
	}

	public void setSheetId(Integer sheetId) {
		this.sheetId = sheetId;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getSheetType() {
		return sheetType;
	}

	public void setSheetType(String sheetType) {
		this.sheetType = sheetType;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public byte[] getSheet() {
		return sheet;
	}

	public void setSheet(byte[] sheet) {
		this.sheet = sheet;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
