package com.spartenportal.bean;

import java.util.Date;

public class UserBean {
	private Integer userid;

	// Personal Details//

	private String userName;

	private String password;

	private String lastName;

	private String firstName;

	private String middleName;

	private String place;

	private Date birthDate;

	private String maritalStatus;

	private String gender;

	private String bloodGroup;

	private String presentAddress;

	private Integer telephone;

	private Long mobile;

	private String email;

	private String permanentAddress;

	private Integer permanentTelephone;

	// relative in krios

	private String relativeName;

	private String relativePosition;

	private String relativesRelationship;

	// ID Proof details //

	private Integer adharNumber;

	private String panNumber;

	// Bank Details //

	private String holderName;

	private String bankName;

	private Long accountNumber;

	private String branchName;

	private String ifscCode;

	private Long pfAccountNumber;

	private Integer uanNumber;

	// Family details //
	// Father//

	private String fatherName;

	private Long fatherContactNumber;

	private String fatherEducation;

	private String fatherOccupation;

	// Mother//

	private String motherName;

	private Long motherContactNumber;

	private String motherEducation;

	private String motherOccupation;

	// Wife/Husband//

	private String wOrHName;

	private Long wOrHContactNumber;

	private String wOrHEducation;

	private String wOrHOccupation;

	// Children//

	private String childrenName;

	private Long childrenContactNumber;

	private String childrenEducation;

	private String childrenOccupation;

	// Brother//

	private String brotherName;

	private Long brotherContactNumber;

	private String brotherEducation;

	private String brotherOccupation;

	// Sister//

	private String sisterName;

	private Long sisterNumber;

	private String sisterEducation;

	private String sisterOccupation;

	// Education//

	// SSC//

	private String schoolName;

	private Integer periodFrom;

	private Integer periodTo;

	private String degreeOrDiploma;

	private String specialization;

	private Integer percentage;

	private String classOrDiv;

	// HSC//

	private String collageName;

	private Integer hscPeriodFrom;

	private Integer hscPeriodTo;

	private String hscDegreeOrDiploma;

	private String hscSpecialization;

	private Integer hscPercentage;

	private String hscclassOrDiv;

	// Degree//

	private String universityName;

	private Integer degreePeriodFrom;

	private Integer degreePeriodTo;

	private String degreeDegreeOrDiploma;

	private String degreeSpecialization;

	private Integer degreePercentage;

	private String degreeClassOrDiv;

	// Computer Knowledge//

	private String programingLanguages;

	private String applicationSoftware;

	private String cert_Version;

	private Date cert_Date;

	// Career Objective//

	private String futureStudy;

	private String careerObjective;

	// Language Known//
	// Marathi//

	private String m_Read;

	private String m_Write;

	private String m_Speak;

	private String m_Comprehend;

	private String m_MotherTongue;

	// Hindi//

	private String h_Read;

	private String h_Write;

	private String h_Speak;

	private String h_Comprehend;

	private String h_MotherTongue;

	// English//

	private String e_Read;

	private String e_Write;

	private String e_Speak;

	private String e_Comprehend;

	private String e_MotherTongue;

	// Other//

	private String otherLanguage;

	private String o_Read;

	private String o_Write;

	private String o_Speak;

	private String o_Comprehend;

	private String o_MotherTongue;

	// Employment History//

	private String tech_Skill1;

	private String tech_Skill2;

	private String otherSkill1;

	private Integer experience;

	private Integer relevantExperience;

	// Previous Employment Details //

	private String employer;

	private String businessType;

	private String emp_Address;

	private String reson_Change;

	private String serviceFrom;

	private String serviceTo;

	private Integer drawnCTC;

	private Long emp_phone;

	private String designation;

	private String seniorName;

	private String seniorDesignation;

	private Integer currentCTC;

	private Integer expectedCTC;

	private Date joinTime;

	private String relocation;

	// Previous Jobs//
	// Employer 1//

	private String employerName1;

	private String employerAddress1;

	private String employerFrom1;

	private String employerTo1;

	private String employerDesignation1;

	private Float lastSalary1;

	// Employer 2//

	private String employerName2;

	private String employerAddress2;

	private String employerFrom2;

	private String employerTo2;

	private String employerDesignation2;

	private Float lastSalary2;

	private String hobbies;

	// Passport / Visa details //

	private Integer passportNo;

	private String issuePlace;

	private Date issueDate;

	private Date expiryDate;

	private String nationality;

	private String statusECNR;

	private String panNo;

	private String notPassport;

	private String app_Place;

	private Date app_Date;

	private String travelledCountries;

	private String refuseVisa;

	private String validVisa;

	private Boolean isActive;

	private Date currentDate;

	private Date modifyDate;

	private String clientCompanyName;
	
	// getters and setters
	public Integer getUserid() {
		return userid;
	}

	
	public String getClientCompanyName() {
		return clientCompanyName;
	}


	public void setClientCompanyName(String clientCompanyName) {
		this.clientCompanyName = clientCompanyName;
	}


	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public Integer getPermanentTelephone() {
		return permanentTelephone;
	}

	public void setPermanentTelephone(Integer permanentTelephone) {
		this.permanentTelephone = permanentTelephone;
	}

	public String getRelativeName() {
		return relativeName;
	}

	public void setRelativeName(String relativeName) {
		this.relativeName = relativeName;
	}

	public String getRelativePosition() {
		return relativePosition;
	}

	public void setRelativePosition(String relativePosition) {
		this.relativePosition = relativePosition;
	}

	public String getRelativesRelationship() {
		return relativesRelationship;
	}

	public void setRelativesRelationship(String relativesRelationship) {
		this.relativesRelationship = relativesRelationship;
	}

	public Integer getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(Integer adharNumber) {
		this.adharNumber = adharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public Long getPfAccountNumber() {
		return pfAccountNumber;
	}

	public void setPfAccountNumber(Long pfAccountNumber) {
		this.pfAccountNumber = pfAccountNumber;
	}

	public Integer getUanNumber() {
		return uanNumber;
	}

	public void setUanNumber(Integer uanNumber) {
		this.uanNumber = uanNumber;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public Long getFatherContactNumber() {
		return fatherContactNumber;
	}

	public void setFatherContactNumber(Long fatherContactNumber) {
		this.fatherContactNumber = fatherContactNumber;
	}

	public String getFatherEducation() {
		return fatherEducation;
	}

	public void setFatherEducation(String fatherEducation) {
		this.fatherEducation = fatherEducation;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public Long getMotherContactNumber() {
		return motherContactNumber;
	}

	public void setMotherContactNumber(Long motherContactNumber) {
		this.motherContactNumber = motherContactNumber;
	}

	public String getMotherEducation() {
		return motherEducation;
	}

	public void setMotherEducation(String motherEducation) {
		this.motherEducation = motherEducation;
	}

	public String getMotherOccupation() {
		return motherOccupation;
	}

	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}

	public String getwOrHName() {
		return wOrHName;
	}

	public void setwOrHName(String wOrHName) {
		this.wOrHName = wOrHName;
	}

	public Long getwOrHContactNumber() {
		return wOrHContactNumber;
	}

	public void setwOrHContactNumber(Long wOrHContactNumber) {
		this.wOrHContactNumber = wOrHContactNumber;
	}

	public String getwOrHEducation() {
		return wOrHEducation;
	}

	public void setwOrHEducation(String wOrHEducation) {
		this.wOrHEducation = wOrHEducation;
	}

	public String getwOrHOccupation() {
		return wOrHOccupation;
	}

	public void setwOrHOccupation(String wOrHOccupation) {
		this.wOrHOccupation = wOrHOccupation;
	}

	public String getChildrenName() {
		return childrenName;
	}

	public void setChildrenName(String childrenName) {
		this.childrenName = childrenName;
	}

	public Long getChildrenContactNumber() {
		return childrenContactNumber;
	}

	public void setChildrenContactNumber(Long childrenContactNumber) {
		this.childrenContactNumber = childrenContactNumber;
	}

	public String getChildrenEducation() {
		return childrenEducation;
	}

	public void setChildrenEducation(String childrenEducation) {
		this.childrenEducation = childrenEducation;
	}

	public String getChildrenOccupation() {
		return childrenOccupation;
	}

	public void setChildrenOccupation(String childrenOccupation) {
		this.childrenOccupation = childrenOccupation;
	}

	public String getBrotherName() {
		return brotherName;
	}

	public void setBrotherName(String brotherName) {
		this.brotherName = brotherName;
	}

	public Long getBrotherContactNumber() {
		return brotherContactNumber;
	}

	public void setBrotherContactNumber(Long brotherContactNumber) {
		this.brotherContactNumber = brotherContactNumber;
	}

	public String getBrotherEducation() {
		return brotherEducation;
	}

	public void setBrotherEducation(String brotherEducation) {
		this.brotherEducation = brotherEducation;
	}

	public String getBrotherOccupation() {
		return brotherOccupation;
	}

	public void setBrotherOccupation(String brotherOccupation) {
		this.brotherOccupation = brotherOccupation;
	}

	public String getSisterName() {
		return sisterName;
	}

	public void setSisterName(String sisterName) {
		this.sisterName = sisterName;
	}

	public Long getSisterNumber() {
		return sisterNumber;
	}

	public void setSisterNumber(Long sisterNumber) {
		this.sisterNumber = sisterNumber;
	}

	public String getSisterEducation() {
		return sisterEducation;
	}

	public void setSisterEducation(String sisterEducation) {
		this.sisterEducation = sisterEducation;
	}

	public String getSisterOccupation() {
		return sisterOccupation;
	}

	public void setSisterOccupation(String sisterOccupation) {
		this.sisterOccupation = sisterOccupation;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Integer getPeriodFrom() {
		return periodFrom;
	}

	public void setPeriodFrom(Integer periodFrom) {
		this.periodFrom = periodFrom;
	}

	public Integer getPeriodTo() {
		return periodTo;
	}

	public void setPeriodTo(Integer periodTo) {
		this.periodTo = periodTo;
	}

	public String getDegreeOrDiploma() {
		return degreeOrDiploma;
	}

	public void setDegreeOrDiploma(String degreeOrDiploma) {
		this.degreeOrDiploma = degreeOrDiploma;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public String getClassOrDiv() {
		return classOrDiv;
	}

	public void setClassOrDiv(String classOrDiv) {
		this.classOrDiv = classOrDiv;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	public Integer getHscPeriodFrom() {
		return hscPeriodFrom;
	}

	public void setHscPeriodFrom(Integer hscPeriodFrom) {
		this.hscPeriodFrom = hscPeriodFrom;
	}

	public Integer getHscPeriodTo() {
		return hscPeriodTo;
	}

	public void setHscPeriodTo(Integer hscPeriodTo) {
		this.hscPeriodTo = hscPeriodTo;
	}

	public String getHscDegreeOrDiploma() {
		return hscDegreeOrDiploma;
	}

	public void setHscDegreeOrDiploma(String hscDegreeOrDiploma) {
		this.hscDegreeOrDiploma = hscDegreeOrDiploma;
	}

	public String getHscSpecialization() {
		return hscSpecialization;
	}

	public void setHscSpecialization(String hscSpecialization) {
		this.hscSpecialization = hscSpecialization;
	}

	public Integer getHscPercentage() {
		return hscPercentage;
	}

	public void setHscPercentage(Integer hscPercentage) {
		this.hscPercentage = hscPercentage;
	}

	public String getHscclassOrDiv() {
		return hscclassOrDiv;
	}

	public void setHscclassOrDiv(String hscclassOrDiv) {
		this.hscclassOrDiv = hscclassOrDiv;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Integer getDegreePeriodFrom() {
		return degreePeriodFrom;
	}

	public void setDegreePeriodFrom(Integer degreePeriodFrom) {
		this.degreePeriodFrom = degreePeriodFrom;
	}

	public Integer getDegreePeriodTo() {
		return degreePeriodTo;
	}

	public void setDegreePeriodTo(Integer degreePeriodTo) {
		this.degreePeriodTo = degreePeriodTo;
	}

	public String getDegreeDegreeOrDiploma() {
		return degreeDegreeOrDiploma;
	}

	public void setDegreeDegreeOrDiploma(String degreeDegreeOrDiploma) {
		this.degreeDegreeOrDiploma = degreeDegreeOrDiploma;
	}

	public String getDegreeSpecialization() {
		return degreeSpecialization;
	}

	public void setDegreeSpecialization(String degreeSpecialization) {
		this.degreeSpecialization = degreeSpecialization;
	}

	public Integer getDegreePercentage() {
		return degreePercentage;
	}

	public void setDegreePercentage(Integer degreePercentage) {
		this.degreePercentage = degreePercentage;
	}

	public String getDegreeClassOrDiv() {
		return degreeClassOrDiv;
	}

	public void setDegreeClassOrDiv(String degreeClassOrDiv) {
		this.degreeClassOrDiv = degreeClassOrDiv;
	}

	public String getProgramingLanguages() {
		return programingLanguages;
	}

	public void setProgramingLanguages(String programingLanguages) {
		this.programingLanguages = programingLanguages;
	}

	public String getApplicationSoftware() {
		return applicationSoftware;
	}

	public void setApplicationSoftware(String applicationSoftware) {
		this.applicationSoftware = applicationSoftware;
	}

	public String getCert_Version() {
		return cert_Version;
	}

	public void setCert_Version(String cert_Version) {
		this.cert_Version = cert_Version;
	}

	public Date getCert_Date() {
		return cert_Date;
	}

	public void setCert_Date(Date cert_Date) {
		this.cert_Date = cert_Date;
	}

	public String getFutureStudy() {
		return futureStudy;
	}

	public void setFutureStudy(String futureStudy) {
		this.futureStudy = futureStudy;
	}

	public String getCareerObjective() {
		return careerObjective;
	}

	public void setCareerObjective(String careerObjective) {
		this.careerObjective = careerObjective;
	}

	public String getM_Read() {
		return m_Read;
	}

	public void setM_Read(String m_Read) {
		this.m_Read = m_Read;
	}

	public String getM_Write() {
		return m_Write;
	}

	public void setM_Write(String m_Write) {
		this.m_Write = m_Write;
	}

	public String getM_Speak() {
		return m_Speak;
	}

	public void setM_Speak(String m_Speak) {
		this.m_Speak = m_Speak;
	}

	public String getM_Comprehend() {
		return m_Comprehend;
	}

	public void setM_Comprehend(String m_Comprehend) {
		this.m_Comprehend = m_Comprehend;
	}

	public String getM_MotherTongue() {
		return m_MotherTongue;
	}

	public void setM_MotherTongue(String m_MotherTongue) {
		this.m_MotherTongue = m_MotherTongue;
	}

	public String getH_Read() {
		return h_Read;
	}

	public void setH_Read(String h_Read) {
		this.h_Read = h_Read;
	}

	public String getH_Write() {
		return h_Write;
	}

	public void setH_Write(String h_Write) {
		this.h_Write = h_Write;
	}

	public String getH_Speak() {
		return h_Speak;
	}

	public void setH_Speak(String h_Speak) {
		this.h_Speak = h_Speak;
	}

	public String getH_Comprehend() {
		return h_Comprehend;
	}

	public void setH_Comprehend(String h_Comprehend) {
		this.h_Comprehend = h_Comprehend;
	}

	public String getH_MotherTongue() {
		return h_MotherTongue;
	}

	public void setH_MotherTongue(String h_MotherTongue) {
		this.h_MotherTongue = h_MotherTongue;
	}

	public String getE_Read() {
		return e_Read;
	}

	public void setE_Read(String e_Read) {
		this.e_Read = e_Read;
	}

	public String getE_Write() {
		return e_Write;
	}

	public void setE_Write(String e_Write) {
		this.e_Write = e_Write;
	}

	public String getE_Speak() {
		return e_Speak;
	}

	public void setE_Speak(String e_Speak) {
		this.e_Speak = e_Speak;
	}

	public String getE_Comprehend() {
		return e_Comprehend;
	}

	public void setE_Comprehend(String e_Comprehend) {
		this.e_Comprehend = e_Comprehend;
	}

	public String getE_MotherTongue() {
		return e_MotherTongue;
	}

	public void setE_MotherTongue(String e_MotherTongue) {
		this.e_MotherTongue = e_MotherTongue;
	}

	public String getOtherLanguage() {
		return otherLanguage;
	}

	public void setOtherLanguage(String otherLanguage) {
		this.otherLanguage = otherLanguage;
	}

	public String getO_Read() {
		return o_Read;
	}

	public void setO_Read(String o_Read) {
		this.o_Read = o_Read;
	}

	public String getO_Write() {
		return o_Write;
	}

	public void setO_Write(String o_Write) {
		this.o_Write = o_Write;
	}

	public String getO_Speak() {
		return o_Speak;
	}

	public void setO_Speak(String o_Speak) {
		this.o_Speak = o_Speak;
	}

	public String getO_Comprehend() {
		return o_Comprehend;
	}

	public void setO_Comprehend(String o_Comprehend) {
		this.o_Comprehend = o_Comprehend;
	}

	public String getO_MotherTongue() {
		return o_MotherTongue;
	}

	public void setO_MotherTongue(String o_MotherTongue) {
		this.o_MotherTongue = o_MotherTongue;
	}

	public String getTech_Skill1() {
		return tech_Skill1;
	}

	public void setTech_Skill1(String tech_Skill1) {
		this.tech_Skill1 = tech_Skill1;
	}

	public String getTech_Skill2() {
		return tech_Skill2;
	}

	public void setTech_Skill2(String tech_Skill2) {
		this.tech_Skill2 = tech_Skill2;
	}

	public String getOtherSkill1() {
		return otherSkill1;
	}

	public void setOtherSkill1(String otherSkill1) {
		this.otherSkill1 = otherSkill1;
	}

	public Integer getExperience() {
		return experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getRelevantExperience() {
		return relevantExperience;
	}

	public void setRelevantExperience(Integer relevantExperience) {
		this.relevantExperience = relevantExperience;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getEmp_Address() {
		return emp_Address;
	}

	public void setEmp_Address(String emp_Address) {
		this.emp_Address = emp_Address;
	}

	public String getReson_Change() {
		return reson_Change;
	}

	public void setReson_Change(String reson_Change) {
		this.reson_Change = reson_Change;
	}

	public String getServiceFrom() {
		return serviceFrom;
	}

	public void setServiceFrom(String serviceFrom) {
		this.serviceFrom = serviceFrom;
	}

	public String getServiceTo() {
		return serviceTo;
	}

	public void setServiceTo(String serviceTo) {
		this.serviceTo = serviceTo;
	}

	public Integer getDrawnCTC() {
		return drawnCTC;
	}

	public void setDrawnCTC(Integer drawnCTC) {
		this.drawnCTC = drawnCTC;
	}

	public Long getEmp_phone() {
		return emp_phone;
	}

	public void setEmp_phone(Long emp_phone) {
		this.emp_phone = emp_phone;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getSeniorName() {
		return seniorName;
	}

	public void setSeniorName(String seniorName) {
		this.seniorName = seniorName;
	}

	public String getSeniorDesignation() {
		return seniorDesignation;
	}

	public void setSeniorDesignation(String seniorDesignation) {
		this.seniorDesignation = seniorDesignation;
	}

	public Integer getCurrentCTC() {
		return currentCTC;
	}

	public void setCurrentCTC(Integer currentCTC) {
		this.currentCTC = currentCTC;
	}

	public Integer getExpectedCTC() {
		return expectedCTC;
	}

	public void setExpectedCTC(Integer expectedCTC) {
		this.expectedCTC = expectedCTC;
	}

	public Date getJoinTime() {
		return joinTime;
	}

	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	public String getRelocation() {
		return relocation;
	}

	public void setRelocation(String relocation) {
		this.relocation = relocation;
	}

	public String getEmployerName1() {
		return employerName1;
	}

	public void setEmployerName1(String employerName1) {
		this.employerName1 = employerName1;
	}

	public String getEmployerAddress1() {
		return employerAddress1;
	}

	public void setEmployerAddress1(String employerAddress1) {
		this.employerAddress1 = employerAddress1;
	}

	public String getEmployerFrom1() {
		return employerFrom1;
	}

	public void setEmployerFrom1(String employerFrom1) {
		this.employerFrom1 = employerFrom1;
	}

	public String getEmployerTo1() {
		return employerTo1;
	}

	public void setEmployerTo1(String employerTo1) {
		this.employerTo1 = employerTo1;
	}

	public String getEmployerDesignation1() {
		return employerDesignation1;
	}

	public void setEmployerDesignation1(String employerDesignation1) {
		this.employerDesignation1 = employerDesignation1;
	}

	public Float getLastSalary1() {
		return lastSalary1;
	}

	public void setLastSalary1(Float lastSalary1) {
		this.lastSalary1 = lastSalary1;
	}

	public String getEmployerName2() {
		return employerName2;
	}

	public void setEmployerName2(String employerName2) {
		this.employerName2 = employerName2;
	}

	public String getEmployerAddress2() {
		return employerAddress2;
	}

	public void setEmployerAddress2(String employerAddress2) {
		this.employerAddress2 = employerAddress2;
	}

	public String getEmployerFrom2() {
		return employerFrom2;
	}

	public void setEmployerFrom2(String employerFrom2) {
		this.employerFrom2 = employerFrom2;
	}

	public String getEmployerTo2() {
		return employerTo2;
	}

	public void setEmployerTo2(String employerTo2) {
		this.employerTo2 = employerTo2;
	}

	public String getEmployerDesignation2() {
		return employerDesignation2;
	}

	public void setEmployerDesignation2(String employerDesignation2) {
		this.employerDesignation2 = employerDesignation2;
	}

	public Float getLastSalary2() {
		return lastSalary2;
	}

	public void setLastSalary2(Float lastSalary2) {
		this.lastSalary2 = lastSalary2;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public Integer getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(Integer passportNo) {
		this.passportNo = passportNo;
	}

	public String getIssuePlace() {
		return issuePlace;
	}

	public void setIssuePlace(String issuePlace) {
		this.issuePlace = issuePlace;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStatusECNR() {
		return statusECNR;
	}

	public void setStatusECNR(String statusECNR) {
		this.statusECNR = statusECNR;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public String getNotPassport() {
		return notPassport;
	}

	public void setNotPassport(String notPassport) {
		this.notPassport = notPassport;
	}

	public String getApp_Place() {
		return app_Place;
	}

	public void setApp_Place(String app_Place) {
		this.app_Place = app_Place;
	}

	public Date getApp_Date() {
		return app_Date;
	}

	public void setApp_Date(Date app_Date) {
		this.app_Date = app_Date;
	}

	public String getTravelledCountries() {
		return travelledCountries;
	}

	public void setTravelledCountries(String travelledCountries) {
		this.travelledCountries = travelledCountries;
	}

	public String getRefuseVisa() {
		return refuseVisa;
	}

	public void setRefuseVisa(String refuseVisa) {
		this.refuseVisa = refuseVisa;
	}

	public String getValidVisa() {
		return validVisa;
	}

	public void setValidVisa(String validVisa) {
		this.validVisa = validVisa;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
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

}
