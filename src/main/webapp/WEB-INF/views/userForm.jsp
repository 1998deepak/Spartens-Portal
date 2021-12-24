<!--  jsp page for user form
  author : Deepak
  Date : 24/11/2021
  version : 1.0 -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>User Form</title>
<link rel="icon" href="./images/Krios-icon-header.png"
	type="image/icon type">
</head>
<style>
.mydiv {
	width: 1100px;
	padding: 10px;
	border: 0.5px;
	-webkit-box-shadow: 0 30px 60px 0;
}

button {
	background-color: Green;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

table, th, td {
	border: 1px;
}

th, td {
	padding: 2px;
}
</style>
<body>

	<div>
		<jsp:include page="./components/userNavbar.jsp" />
	</div>
	<br><br><br>
	<div align="center">
		<font color="blue" size="10px">Employment Form</font> <br> <br>
		<br>
	</div>
	<br>
	<div style="position: absolute; left: 150px; top: 200px;" class="mydiv">
		<br> <br>
			<form action="/updateUser" method="post">
				<b>
					<div class="panel-group" id="accordion">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-parent="#accordion"
										href="#collapse1"><span
										class="glyphicon glyphicon-circle-arrow-down"></span><font
										color="blue" size="3px">&nbsp&nbsp Personal Details (To
											be filled as per your Aaadhar Card/PAN Details/Passport)</font></a>
								</h4>
							</div>
							<div id="collapse1" class="panel-collapse collapse in">
								<div class="panel-body">
									<table>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Last Name</td>
											<td><input type="text" class="form-control"
												placeholder="Enter Last Name" name="lastName"
												value="${user.getLastName()}"></td>
											<td align="right">Middle Name</td>
											<td><input type="text" class="form-control"
												placeholder="Enter Middle Name" name="middleName"
												value="${user.getMiddleName()}"></td>
											<td align="right">First Name</td>
											<td><input type="text" class="form-control"
												placeholder="Enter First Name" name="firstName"
												value="${user.getFirstName()}"></td>
										</tr>

										<tr>
											<td colspan="1">Date Of Birth</td>
											<td><input type="date" name="birthDate"
												class="form-control" value="${user.getBirthDate()}">
											</td>
										</tr>
										<tr>
											<td colspan="1">Place Of Birth
											<td><input type="text" placeholder="Place" name="place"
												class="form-control" value="${user.getPlace()}"></td>
											<td align="left"></td>
											<td></td>
											<td align="right">Marital Status</td>
											<td><input type="text" class="form-control"
												name="maritalStatus" placeholder="Marital Status"
												value="${user.getMaritalStatus()}"></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Gender</td>
											<td><input class="form-check-input" type="radio"
												name="gender" id="flexRadioDefault1" checked value="Male">Male
												<input class="form-check-input" type="radio" name="gender"
												id="flexRadioDefault2" value="Female">Female</td>
											<td></td>
											<td colspan="2" align="right">Blood Group</td>
											<td><input type="text" class="form-control"
												name="bloodGroup" placeholder="Blood Group"
												value="${user.getBloodGroup()}"></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Present Address</td>
											<td><input type="text" class="form-control"
												name="presentAddress" placeholder="Present Address"
												value="${user.getPresentAddress()}"></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Tel(R)</td>
											<td><input type="number" name="telephone"
												class="form-control" placeholder="Telephone Number"
												value=""></td>
											<td align="right">Mobile</td>
											<td><input type="text" class="form-control"
												name="mobile" placeholder="Mobile Number"></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Email-ID</td>
											<td><input type="email" class="form-control"
												name="email" placeholder="Email" value="${user.getEmail()}"></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Permanent Address</td>
											<td><input type="text" class="form-control"
												name="permanentAddress" placeholder="Permanent Address"
												value="${user.getPresentAddress()}">
											</td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Permanent Tel(R)</td>
											<td><input type="text" name="permanentTelephone"
												class="form-control"
												placeholder="Permanent Telephone Number"
												value="${user.getPermanentTelephone() }"></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td></td>
										</tr>
										<tr>
											<td colspan="6">Any relatives in Krios Info Solution Pvt
												Ltd., or its group companies? If yes, give details</td>
										<tr>
											<td>Name</td>
											<td><input type="text" class="form-control"
												placeholder="Enter Full Name" name="relativeName"
												value="${user.getRelativeName()}"></td>
											<td>Position</td>
											<td><input type="text" class="form-control"
												placeholder="Enter Position" name="relativePosition"
												value="${user.getRelativePosition()}"></td>
											<td>Relationship</td>
											<td><input type="text" class="form-control"
												placeholder="Enter Relationship"
												name="relativesRelationship"
												value="${user.getRelativesRelationship()}"></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>

										<tr>
											<td colspan="7"><hr style="color: black; height: 10px;"></td>
										</tr>
										<tr>
											<td colspan="6"><font color="blue" size="3px">ID
													Proof Details</font></td>
										</tr>
										<tr>
											<td><br></td>
										</tr>
										<tr>
											<td>Aadhar Card No</td>
											<td><input type="text" name="adharNumber"
												value="${user.getAdharNumber()}" class="form-control"></td>
											<td>PAN No</td>
											<td><input type="text" name="panNumber"
												value="${user.getPanNumber()}" class="form-control"></td>
										</tr>

									</table>
								</div>
							</div>
							<div class="panel panel-default">
								<div class="panel-heading">
									<h4 class="panel-title">
										<a data-toggle="collapse" data-parent="#accordion"
											href="#collapse2"><span
											class="glyphicon glyphicon-circle-arrow-down"></span><font
											color="blue" size="3px">&nbsp&nbsp Bank Details</font></a>
									</h4>
								</div>
								<div id="collapse2" class="panel-collapse collapse">
									<div class="panel-body">
										<table>
											<tr>
												<td>Account Holder Name</td>
												<td><input type="text" name="holderName"
													value="${user.getHolderName()}" class="form-control"></td>
											</tr>
											<tr>
												<td>Bank Name</td>
												<td><input type="text" name="bankName"
													value="${user.getBankName()}" class="form-control"></td>
											</tr>
											<tr>
												<td>Bank Account No</td>
												<td><input type="number" name="accountNumber"
													value="${user.getAccountNumber()}" class="form-control"></td>
											</tr>
											<tr>
												<td>Bank Branch Name</td>
												<td><input type="text" name="branchName"
													value="${user.getBranchName()}" class="form-control"></td>
											</tr>
											<tr>
												<td>IFSC Code</td>
												<td><input type="text" name="ifscCode"
													value="${user.getIfscCode()}" class="form-control"></td>
											</tr>
											<tr>
												<td colspan="4">If you have your PF Account Number &
													UAN No(If you want to continue existing Account)</td>
											<tr>
												<td>PF Account Number</td>
												<td><input type="text" name="pfAccountNumber"
													value="${user.getPfAccountNumber()}" class="form-control"></td>
												<td>UAN No</td>
												<td><input type="text" name="uanNumber"
													value="${user.getUanNumber()}" class="form-control"></td>
											</tr>
											<tr>
												<td><br></td>
											</tr>
											<tr>
												<td><br></td>
											</tr>
										</table>
									</div>
								</div>
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#accordion"
												href="#collapse3"><span
												class="glyphicon glyphicon-circle-arrow-down"></span><font
												color="blue" size="3px">&nbsp&nbsp Family Background</font></a>
										</h4>
									</div>
									<div id="collapse3" class="panel-collapse collapse">
										<div class="panel-body">
											<table>
												<tr>
													<td><br></td>
												</tr>
												<tr>
													<th></th>
													<th>Name</th>
													<th align="left">Contact details</th>
													<th>Education</th>
													<th>Occupation</th>
												</tr>
												<tr>
													<td>Father</td>
													<td><input type="text" name="fatherName"
														value="${user.getFatherName()}" class="form-control"></td>
													<td><input type="text" name="fatherContactNumber"
														value="${user.getFatherContactNumber()}"
														class="form-control"></td>
													<td><input type="text" name="fatherEducation"
														value="${user.getFatherEducation()}" class="form-control"></td>
													<td><input type="text" name="fatherOccupation"
														value="${user.getFatherOccupation()}" class="form-control"></td>
												</tr>
												<tr>
													<td>Mother</td>
													<td><input type="text" name="motherName"
														value="${user.getMotherName()}" class="form-control"></td>
													<td><input type="text" name="motherContactNumber"
														value="${user.getMotherContactNumber()}"
														class="form-control"></td>
													<td><input type="text" name="motherEducation"
														value="${user.getMotherEducation()}" class="form-control"></td>
													<td><input type="text" name="motherOccupation"
														value="${user.getMotherOccupation()}" class="form-control"></td>
												</tr>
												<tr>
													<td>Wife/Husband</td>
													<td><input type="text" name="wOrHName"
														value="${user.getwOrHName()}" class="form-control"></td>
													<td><input type="text" name="wOrHContactNumber"
														value="${user.getwOrHContactNumber()}"
														class="form-control"></td>
													<td><input type="text" name="wOrHEducation"
														value="${user.getwOrHEducation()}" class="form-control"></td>
													<td><input type="text" name="wOrHOccupation"
														value="${user.getwOrHOccupation()}" class="form-control"></td>
												</tr>
												<tr>
													<td>Children</td>
													<td><input type="text" name="childrenName"
														value="${user.getChildrenName()}" class="form-control"></td>
													<td><input type="text" name="childrenContactNumber"
														value="${user.getChildrenContactNumber()}"
														class="form-control"></td>
													<td><input type="text" name="childrenEducation"
														value="${user.getChildrenEducation()}"
														class="form-control"></td>
													<td><input type="text" name="childrenOccupation"
														value="${user.getChildrenOccupation()}"
														class="form-control"></td>
												</tr>
												<tr>
													<td>Brother(s)</td>
													<td><input type="text" name="brotherName"
														value="${user.getBrotherName()}" class="form-control"></td>
													<td><input type="text" name="brotherContactNumber"
														value="${user.getBrotherContactNumber()}"
														class="form-control"></td>
													<td><input type="text" name="brotherEducation"
														value="${user.getBrotherEducation()}" class="form-control"></td>
													<td><input type="text" name="brotherOccupation"
														value="${user.getBrotherOccupation()}"
														class="form-control"></td>
												</tr>
												<tr>
													<td>Sister(s)</td>
													<td><input type="text" name="sisterName"
														value="${user.getSisterName()}" class="form-control"></td>
													<td><input type="text" name="sisterNumber"
														value="${user.getSisterNumber()}" class="form-control"></td>
													<td><input type="text" name="sisterEducation"
														value="${user.getSisterEducation()}" class="form-control"></td>
													<td><input type="text" name="sisterOccupation"
														value="${user.getSisterOccupation()}" class="form-control"></td>
												</tr>
												<tr>
													<td><br></td>
												</tr>
												<tr>
													<td><br></td>
												</tr>
											</table>
										</div>
									</div>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h4 class="panel-title">
												<a data-toggle="collapse" data-parent="#accordion"
													href="#collapse4"><span
													class="glyphicon glyphicon-circle-arrow-down"></span><font
													color="blue" size="3px">&nbsp&nbsp Education: List
														in order starting with Xth Standard</font></a>
											</h4>
										</div>
										<div id="collapse4" class="panel-collapse collapse">
											<div class="panel-body">
												<table>
													<tr>
														<td><br></td>
													</tr>
													<tr>
														<th rowspan="2">School/College/<br> University
														</th>
														<th align="right">Period</th>
														<th rowspan="2">Degree/Diploma</th>
														<th rowspan="2">Specialization</th>
														<th rowspan="2">%</th>
														<th rowspan="2">Class/Div</th>
													</tr>
													<tr>
														<td>FROM &nbsp&nbsp &nbsp&nbsp TO</td>

													</tr>
													<tr>
														<td></td>
													</tr>
													<tr>

														<td>S.S.C.</td>
														<td><input type="number" name="periodFrom"
															placeholder="From" value="${user.getPeriodFrom()}">
															<input type="number" name="periodTo" placeholder="To"
															value="${user.getPeriodTo()}"></td>
														<td><input type="text" name="degreeOrDiploma"
															value="${user.getDegreeOrDiploma()}"></td>
														<td><input type="text" name="specialization"
															value="${user.getSpecialization()}"></td>
														<td><input type="number" name="percentage"
															value="${user.getPercentage()}"></td>
														<td><input type="text" name="classOrDiv"
															value="${user.getClassOrDiv()}"></td>

													</tr>
													<tr>
														<td></td>
													</tr>
													<tr>
														<td>H.S.C.</td>
														<td><input type="number" name="hscPeriodFrom"
															placeholder="From" value="${user.getHscPeriodFrom()}">
															<input type="number" name="hscPeriodTo" placeholder="To"
															value="${user.getPeriodTo()}"></td>
														<td><input type="text" name="hscDegreeOrDiploma"
															value="${user.getHscDegreeOrDiploma()}"></td>
														<td><input type="text" name="hscSpecialization"
															value="${user.getHscSpecialization()}"></td>
														<td><input type="number" name="hscPercentage"
															value="${user.getHscPercentage()}"></td>
														<td><input type="text" name="hscclassOrDiv"
															value="${user.getHscclassOrDiv()}"></td>

													</tr>
													<tr>
														<td></td>
													</tr>
													<tr>
														<td>Degree</td>
														<td><input type="number" name="degreePeriodFrom"
															placeholder="From" value="${user.getDegreePeriodFrom()}">
															<input type="number" name="degreePeriodTo"
															placeholder="To" value="${user.getDegreePeriodTo()}"></td>
														<td><input type="text" name="degreeDegreeOrDiploma"
															value="${user.getDegreeDegreeOrDiploma()}"></td>
														<td><input type="text" name="degreeSpecialization"
															value="${user.getDegreeSpecialization()}"></td>
														<td><input type="number" name="degreePercentage"
															value="${user.getDegreePercentage()}"></td>
														<td><input type="text" name="degreeClassOrDiv"
															value="${user.getDegreeClassOrDiv()}"></td>

													</tr>
												</table>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#collapse5"><span
														class="glyphicon glyphicon-circle-arrow-down"></span><font
														color="blue" size="3px">&nbsp&nbsp Computer
															Knowledge</font></a>
												</h4>
											</div>
											<div id="collapse5" class="panel-collapse collapse">
												<div class="panel-body">
													<table>
														<tr>
															<td><br></td>
														</tr>
														<tr>
															<td>Programming Language</td>
															<td><input type="text" name="programingLanguages"
																value="${user.getProgramingLanguages()}"></td>
														</tr>
														<tr>
															<td>Application(s) Software / Packages</td>
															<td><input type="text" name="applicationSoftware"
																value="${user.getApplicationSoftware()}"></td>
														</tr>
														<tr>
															<td>Certifications (Mention version & date)</td>
															<td><input type="text" name="cert_Version"
																value="${user.getCert_Date()}"> &nbsp&nbsp <input
																type="date" name="cert_Date"></td>
														</tr>

														<tr>
															<td><br></td>
														</tr>
													</table>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapse6"><span
															class="glyphicon glyphicon-circle-arrow-down"></span><font
															color="blue" size="3px">&nbsp&nbsp Career
																Objectives </font></a>
													</h4>
												</div>
												<div id="collapse6" class="panel-collapse collapse">
													<div class="panel-body">
														<table>
															<tr>
																<td><br></td>
															</tr>
															<tr>
																<td>Any plans for future studies? if yes, give
																	details</td>
																<td><input type="text" name="futureStudy"
																	value="${user.getFutureStudy()}"></td>
															</tr>
															<tr>
																<td>State your career objectives for the next three
																	years (please be specific)</td>
																<td><input type="text" name="careerObjective"
																	value="${user.getCareerObjective()}"></td>
															</tr>

															<tr>
																<td><br></td>
															</tr>
														</table>
													</div>
												</div>
												<div class="panel panel-default">
													<div class="panel-heading">
														<h4 class="panel-title">
															<a data-toggle="collapse" data-parent="#accordion"
																href="#collapse7"><span
																class="glyphicon glyphicon-circle-arrow-down"></span><font
																color="blue" size="3px">&nbsp&nbsp Languages
																	Known</font></a>
														</h4>
													</div>
													<div id="collapse7" class="panel-collapse collapse">
														<div class="panel-body">
															<table>
																<tr>
																	<td><br></td>
																</tr>
																<tr align="center">
																	<th>Languages</th>
																	<th>Read</th>
																	<th>Write</th>
																	<th>Speak</th>
																	<th>Comprehend</th>
																	<th>Mother tongue</th>
																</tr>
																<tr>
																	<td>Marathi</td>
																	<td><input type="text" name="m_Read"
																		value="${user.getM_Read()}"></td>
																	<td><input type="text" name="m_Write"
																		value="${user.getM_Write()}"></td>
																	<td><input type="text" name="m_Speak"
																		value="${user.getM_Speak()}"></td>
																	<td><input type="text" name="m_Comprehend"
																		value="${user.getM_Comprehend()}"></td>
																	<td><input type="text" name="m_MotherTongue"
																		value="${user.getM_MotherTongue()}"></td>
																</tr>
																<tr>
																	<td>Hindi</td>
																	<td><input type="text" name="h_Read"
																		value="${user.getH_Read()}"></td>
																	<td><input type="text" name="h_Write"
																		value="${user.getH_Write()}"></td>
																	<td><input type="text" name="h_Speak"
																		value="${user.getH_Speak()}"></td>
																	<td><input type="text" name="h_Comprehend"
																		value="${user.getH_Comprehend()}"></td>
																	<td><input type="text" name="h_MotherTongue"
																		value="${user.getH_MotherTongue()}"></td>
																</tr>
																<tr>
																	<td>English</td>
																	<td><input type="text" name="e_Read"
																		value="${user.getE_Read()}"></td>
																	<td><input type="text" name="e_Write"
																		value="${user.getE_Write()}"></td>
																	<td><input type="text" name="e_Speak"
																		value="${user.getE_Speak()}"></td>
																	<td><input type="text" name="e_Comprehend"
																		value="${user.getE_Comprehend()}"></td>
																	<td><input type="text" name="e_MotherTongue"
																		value="${user.getE_MotherTongue()}"></td>
																</tr>
																<tr>
																	<td>Other</td>
																	<td><input type="text" name="o_Read"
																		value="${user.getO_Read()}"></td>
																	<td><input type="text" name="o_Write"
																		value="${user.getO_Write()}"></td>
																	<td><input type="text" name="o_Speak"
																		value="${user.getO_Speak()}"></td>
																	<td><input type="text" name="o_Comprehend"
																		value="${user.getO_Comprehend()}"></td>
																	<td><input type="text" name="o_MotherTongue"
																		value="${user.getO_MotherTongue()}"></td>
																</tr>
																<tr>
																	<td><br></td>
																</tr>
															</table>
														</div>
													</div>
													<div class="panel panel-default">
														<div class="panel-heading">
															<h4 class="panel-title">
																<a data-toggle="collapse" data-parent="#accordion"
																	href="#collapse8"><span
																	class="glyphicon glyphicon-circle-arrow-down"></span><font
																	color="blue" size="3px">&nbsp&nbsp Employment
																		History</font></a>
															</h4>
														</div>
														<div id="collapse8" class="panel-collapse collapse">
															<div class="panel-body">
																<table>
																	<tr>
																		<td><br></td>
																	</tr>
																	<tr>
																		<td>Technical Skills</td>
																		<td><input type="text" name="tech_Skill1"
																			value="${user.getTech_Skill1()}"></td>
																		<td>Other Skills</td>
																		<td><input type="text" name="otherSkill1"
																			value="${user.getOtherSkill1()}"></td>
																	</tr>
																	<tr>
																		<td>Total experience in years</td>
																		<td><input type="text" name="experience"
																			value="${user.getExperience()}"></td>
																		<td>Relevant Experience</td>
																		<td><input type="text" name="relevantExperience"
																			value="${user.getRelevantExperience()}"></td>
																	</tr>

																	<tr>
																		<td><br></td>
																	</tr>
																</table>
															</div>
														</div>
													</div>
												</div>
												<div class="panel panel-default">
													<div class="panel-heading">
														<h4 class="panel-title">
															<a data-toggle="collapse" data-parent="#accordion"
																href="#collapse9"><span
																class="glyphicon glyphicon-circle-arrow-down"></span><font
																color="blue" size="3px">&nbsp&nbsp Previous
																	Employment Details</font></a>
														</h4>
													</div>
													<div id="collapse9" class="panel-collapse collapse">
														<div class="panel-body">
															<table>
																<tr>
																	<td><br></td>
																</tr>
																<tr>
																	<td>Employer</td>
																	<td><input type="text" name="employer"
																		value="${user.getEmployer()}"></td>
																	<td>Type of business</td>
																	<td><input type="text" name="businessType"
																		value="${user.getBusinessType()}"></td>
																</tr>
																<tr>
																	<td>Address</td>
																	<td><textarea rows="4" cols="25"
																			name="emp_Address" value="${user.getEmp_Address()}"></textarea></td>
																</tr>
																<tr>
																	<td>Reason for seeking change/leaving</td>
																	<td><textarea rows="4" cols="25"
																			name="reson_Change" value="${user.getReson_Change()}"></textarea></td>
																</tr>
																<tr>
																	<td>Period of Service</td>
																	<td>From <input type="date" name="serviceFrom"
																		value="${user.getServiceFrom()}"></td>
																	<td></td>
																	<td>TO <input type="date" name="serviceTo"
																		value="${user.getServiceTo()}"></td>
																</tr>
																<tr>
																	<td>Salary Drawn (CTC)</td>
																	<td><input type="text" name="drawnCTC"
																		value="${user.getDrawnCTC()}"></td>
																</tr>
																<tr>
																	<td>Ph. No. (s)</td>
																	<td><input type="text" name="emp_phone"
																		value="${user.getEmp_phone()}"></td>
																</tr>
																<tr>
																	<td>Designation</td>
																	<td><input type="text" name="designation"
																		value="${user.getDesignation()}"></td>
																</tr>
																<tr>
																	<td>Name of immediate senior</td>
																	<td><input type="text" name="seniorName"
																		value="${user.getSeniorName()}"></td>
																</tr>
																<tr>
																	<td>Designation of immediate senior</td>
																	<td><input type="text" name="seniorDesignation"
																		value="${user.getSeniorDesignation()}"></td>
																</tr>
																<tr>
																	<td><br></td>
																</tr>
															</table>
															<br> <br>
															<table>
																<tr>
																	<td>Current CTC</td>
																	<td><input type="text" name="currentCTC"
																		value="${user.getCurrentCTC()}"></td>
																	<td>Expected CTC</td>
																	<td><input type="text" name="expectedCTC"
																		value="${user.getExpectedCTC()}"></td>
																</tr>
																<tr>
																	<td>Joining Time required</td>
																	<td><input type="date" name="joinTime"
																		value="${user.getJoinTime()}"></td>
																</tr>
																<tr>
																	<td>Do you need Relocation? Yes / No(if eligible)</td>
																	<td><input type="text" name="relocation"
																		value="${user.getRelocation()}"></td>
																</tr>
																<tr>
																	<td><br></td>
																</tr>
															</table>
														</div>
													</div>
												</div>
											</div>
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#accordion"
															href="#collapse10"><span
															class="glyphicon glyphicon-circle-arrow-down"></span><font
															color="blue" size="3px">&nbsp&nbsp Previous Jobs</font></a>
													</h4>
												</div>
												<div id="collapse10" class="panel-collapse collapse">
													<div class="panel-body">
														<table>
															<tr>
																<td colspan="3">Start with your present job and
																	work backwards. Account for time whenever unemployed.</td>
															</tr>
															<tr>
																<td><br></td>
															</tr>
															<tr>
																<td rowspan="2">Sr.No</td>
																<td rowspan="2">Name and Address of Employer
																	(Please also give Telephone Nos.)</td>
																<td>Period</td>
																<td rowspan="2">Designation</td>
																<td rowspan="2">Last Salary Drawn</td>
															</tr>
															<tr>
																<td>From &nbsp&nbsp &nbsp&nbsp &nbsp&nbsp TO</td>
															</tr>
															<tr>
																<td>1</td>
																<td><input type="text" name="employerName1"
																	placeholder="Name" value="${user.getEmployerName1()}">
																	<input type="text" name="employerAddress1"
																	placeholder="Address"
																	value="${user.getEmployerAddress1()}"></td>
																<td><input type="date" name="employerFrom1"
																	value="${user.getEmployerFrom1()}"> <input
																	type="date" name="employerTo1"
																	value="${user.getEmployerTo1()}"></td>
																<td><input type="text" name="employerDesignation1"
																	placeholder="Designation"
																	value="${user.getEmployerDesignation1()}"></td>
																<td><input type="text" name="lastSalary1"
																	placeholder="Last Salary"
																	value="${user.getLastSalary1()}"></td>
															</tr>
															<tr>
																<td></td>
															</tr>
															<tr>
																<td>2</td>
																<td><input type="text" name="employerName2"
																	placeholder="Name" value="${user.getEmployerName2()}">
																	<input type="text" name="employerAddress2"
																	placeholder="Address"
																	value="${user.getEmployerAddress2()}"></td>
																<td><input type="date" name="employerFrom2"
																	value="${user.getEmployerFrom2()}"> <input
																	type="date" name="employerTo2"
																	value="${user.getEmployerTo2()}"></td>
																<td><input type="text" name="employerDesignation2"
																	placeholder="Designation"
																	value="${user.getEmployerDesignation2()}"></td>
																<td><input type="text" name="lastSalary2"
																	placeholder="Last Salary"
																	value="${user.getLastSalary2()}"></td>
															</tr>
															<tr>
																<td><br></td>
															</tr>
															<tr>
																<td>Hobbies & Interests</td>
																<td><textarea rows="3" cols="25" name="hobbies"
																		value="${user.getHobbies()}"></textarea></td>
															</tr>
															<tr>
																<td><br></td>
															</tr>
														</table>
													</div>
												</div>
											</div>
										</div>
										<div class="panel panel-default">
											<div class="panel-heading">
												<h4 class="panel-title">
													<a data-toggle="collapse" data-parent="#accordion"
														href="#collapse11"><span
														class="glyphicon glyphicon-circle-arrow-down"></span><font
														color="blue" size="3px">&nbsp&nbsp Passport / Visa
															Details (If available)</font></a>
												</h4>
											</div>
											<div id="collapse11" class="panel-collapse collapse">
												<div class="panel-body">
													<table>
														<tr>
															<td>Passport No</td>
															<td><input type="text" name="passportNo"
																value="${user.getPassportNo()}"></td>
															<td>Place of Issue</td>
															<td><input type="text" name="issuePlace"
																value="${user.getIssuePlace()}"></td>
														</tr>
														<tr>
															<td>Date of Issue</td>
															<td><input type="date" name="issueDate"
																value="${user.getIssueDate()}"></td>
															<td>Date of Expiry</td>
															<td><input type="date" name="expiryDate"
																value="${user.getExpiryDate()}"></td>
														</tr>
														<tr>
															<td>Nationality</td>
															<td><input type="text" name="nationality"
																value="${user.getNationality()}"></td>
															<td>ECNR Status</td>
															<td><input type="text" name="statusECNR"
																value="${user.getStatusECNR()}"></td>
														</tr>
														<tr>
															<td>PAN No</td>
															<td><input type="text" name="panNo"
																value="${user.getPanNo()}"></td>
														</tr>
														<tr>
															<td>If not, have you applied for a Passport?</td>
															<td><input type="text" name="notPassport"
																value="${user.getNotPassport()}"></td>
														</tr>
														<tr>
															<td>Place and Date of Application</td>
															<td><input type="date" name="app_Date"
																value="${user.getApp_Date()}"></td>
															<td><input type="text" name="app_Place"
																placeholder="Place" value="${user.getApp_Place()}"></td>
														</tr>
														<tr>
															<td>Countries travelled abroad</td>
															<td><input type="text" name="travelledCountries"
																value="${user.getTravelledCountries()}"></td>
														</tr>
														<tr>
															<td>Have you been refused Visa any time? If yes,
																give details</td>
															<td><input type="text" name="refuseVisa"
																value="${user.getRefuseVisa()}"></td>
														</tr>
														<tr>
															<td><br></td>
														</tr>
													</table>
												</div>
											</div>
										</div>
									</div>
									<br>
									<br>
									<table>
										<div style="position: absolute; left: 500px;">

											<button type="submit" class="button btn-primary">SAVE</button>
										</div>
									
									</table>
									</div>
									<br>
									<br>
									<br>
									<br>
								</div>
							</div>
						
					</div>
				</b><br>
				<br>
				<br>
				</div></div>
			</form>
		
	</div>
</body>
</html>