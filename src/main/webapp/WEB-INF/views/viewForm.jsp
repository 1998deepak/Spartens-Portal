<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<link rel="icon" href="../images/Krios-icon-header.png" type="image/icon type">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<!-- Bootstrap Styles-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FontAwesome Styles-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- Morris Chart Styles-->
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- Custom Styles-->
<link href="assets/css/custom-styles.css" rel="stylesheet" />
<!-- Google Fonts-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<title>User Form</title>
</head>
<style>
body
{
background-color: #E8E8E8;
}
button {
	background-color: #34AB53;
	color: white;
	padding: 7px 12px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	border-radius: 10px 10px 10px 10px;
}

button:hover {
	opacity: 0.8;
}

#mydiv {
	width: 1200px;
	padding: 10px;
	border: 0.5px;
	-webkit-box-shadow: 0 30px 60px 0;
	margin: 20px;
	-webkit-border-radius: 10px 10px 10px 10px;
  border-radius: 10px 10px 10px 10px;
  background: #fff;
  padding: 30px;
  position: relative;
  padding: 0px;
  -webkit-box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  box-shadow: 0 30px 60px 0 rgba(0,0,0,0.3);
  text-align: left;
}
td {
	margin: 20px;
	font-size: 12px;
}

h1 {
	background-color: blue;
}

.form-control {
	width: 73%;
}
</style>
<body>
<div>
		<jsp:include page="./components/header2.jsp" />
	</div>

<!-- <div style="position: absolute; left: 50px; top: 20px;">
		<a href="/employeeDetails"><button >Back</button></a>
	</div><br><br> -->
		<div id="mydiv" style="position: absolute; left: 70px; top: 58px;  padding-top: 12px;padding-bottom: 10px;">
			<table>
				<tr>
					<td align="left"><font color="black" style="font-family: sans-serif;font-size: 15px; ">&nbsp;&nbsp; EMPLOYEE DETAILS</font></td>
					<td></td>
					<td align="right">
						<!-- Button trigger modal -->

						<div class=" container" style="position: absolute; left: 35px;o;top: -3px;"><button type="button" data-toggle="modal"
							data-target="#exampleModal"
							style="background-color: #42B5F4;">
							View Documents</button></div><!-- Modal -->
						<div class="modal fade" id="exampleModal" tabindex="-1"
							role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header" align="left">
										<h4 class="modal-title" id="exampleModalLabel">DOCUMENTS</h4>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
										<div>
											<table class="table table-hover">
												<thead>
													<tr class="table-active"
														style="border-top: 1px solid white; background-color: #36C5F0;">
														<th>Id</th>
														<th>Name</th>
														<th>Download Link</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${docs}" var="doc">
														<tr class="table-danger">
															<td>${doc.getDocId()}</td>
															<td>${doc.getDocName() }</td>
															<td><a href="/downloadFile/${doc.getDocId()}">Download</a></td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>

									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											style="background-color: red;" data-dismiss="modal">Close</button>
									</div>
								</div>
							</div>
						</div>
					</td>
					</tr></table>
		</div>
			<div style="position: absolute; left: 70px; top: 104px; "id="mydiv">
				<table class="table table-hover">
				<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Personal Details :</font></td></tr>
					<tr align="left">
						<td><label> Last Name :</label> ${user.getLastName()}</td>


						<td><label> First Name :</label> ${user.getMiddleName()}</td>


						<td><label> Middle Name :</label> ${user.getFirstName()}</td>


					</tr>
					<tr align="left">
					<td><label> Date Of Birth :</label> ${user.getBirthDate()}</td>
					<td><label> Place Of Birth :</label> ${user.getPlace()}</td>
					<td><label> Marital Status :</label> ${user.getMaritalStatus()}</td>
					</tr>
					<tr align="left">
						<td><label>Gender :</label> ${user.getGender()}</td>
						<td><label>Blood Group :</label> ${user.getBloodGroup()}</td>
						<td><label>Present Address :</label>
							${user.getPresentAddress()}</td>
					</tr>
					<tr align="left">
						<td><label>Tel(R) :</label></td>
						<td><label>Mobile :</label> ${user.getMobile()}</td>
						<td><label>Email-ID :</label> ${user.getEmail()}</td>
					</tr>
					<tr align="left">
						<td><label>Permanent Address :</label>
							${user.getPresentAddress()}</td>
						<td><label> Permanent Tel(R) :</label>
							${user.getPermanentTelephone()}</td>
						<td><label>Relative Name :</label> ${user.getRelativeName()}</td>
					</tr>
					<tr align="left">
						<td><label>Position :</label> ${user.getRelativePosition()}</td>
						<td><label>Relationship :</label>
							${user.getRelativesRelationship()}</td>
						<td><label>Aadhar Card No :</label> ${user.getAdharNumber()}</td>
					</tr>
					<tr align="left">
						<td><label>PAN No :</label> ${user.getPanNumber()}</td>
						</tr>
						<tr align="left"style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Bank Details :</font></td></tr>
						<tr align="left">
						<td><label>Account Holder Name :</label>
							${user.getHolderName()}</td>
						<td><label>Bank Name :</label> ${user.getBankName()}</td>
					</tr>
					<tr align="left">
						<td><label>Bank Account No :</label> ${user.getAccountNumber()}</td>
						<td><label>Bank Branch Name :</label> ${user.getBranchName()}</td>
						<td><label>IFSC Code :</label> ${user.getIfscCode()}</td>
					</tr>
					<tr align="left">

						<td><label>PF Account Number :</label>
							${user.getPfAccountNumber()}</td>
						<td><label>UAN No :</label> ${user.getUanNumber()}</td></tr>		
						<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Family Details :</font></td></tr>
						<tr align="left">
						<td><label>Father Name :</label> ${user.getFatherName()}</td>
					</tr>
					<tr align="left">

						<td><label>Father Contact Number :</label>
							${user.getFatherContactNumber()}</td>
						<td><label>Father Education :</label>
							${user.getFatherEducation()}</td>
						<td><label>Father Occupation :</label>
							${user.getFatherOccupation()}</td>
					</tr>
					<tr align="left">

						<td><label>Mother Name :</label> ${user.getMotherName()}</td>
						<td><label>Mother Contact Number :</label>
							${user.getMotherContactNumber()}</td>
						<td><label>Mother Education :</label>
							${user.getMotherEducation()}</td>
					</tr>
					<tr align="left">

						<td><label>Mother Occupation :</label>
							${user.getMotherOccupation()}</td>
						<td><label>W Or H Name :</label> ${user.getwOrHName()}</td>
						<td><label>WOrH Contact Number :</label>
							${user.getwOrHContactNumber()}</td>
					</tr>
					<tr align="left">

						<td><label>W Or H Education :</label>
							${user.getwOrHEducation()}</td>
						<td><label>W Or H Occupation :</label>
							${user.getwOrHOccupation()}</td>
						<td><label>Children Name :</label> ${user.getChildrenName()}</td>
					</tr>
					<tr align="left">

						<td><label>Children Contact Number :</label>
							${user.getChildrenContactNumber()}</td>
						<td><label>Children Education :</label>
							${user.getChildrenEducation()}</td>
						<td><label>Children Occupation :</label>
							${user.getChildrenOccupation()}</td>
					</tr>
					<tr align="left">

						<td><label>Brother Name :</label> ${user.getBrotherName()}</td>
						<td><label>Brother Contact Number :</label>
							${user.getBrotherContactNumber()}</td>
						<td><label>Brother Education :</label>
							${user.getBrotherEducation()}</td>
					</tr>
					<tr align="left">

						<td><label>brother Occupation :</label>
							${user.getBrotherOccupation()}</td>
						<td><label>Sister Name :</label> ${user.getSisterName()}</td>
						<td><label>Sister Number :</label> ${user.getSisterNumber()}</td>
					</tr>
					<tr align="left">

						<td><label>Sister Education :</label>
							${user.getSisterEducation()}</td>
						<td><label>Sister Occupation :</label>
							${user.getSisterOccupation()}</td>
							</tr>
							<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Education Details :</font></td></tr>
							<tr align="left">
						<td><label>S.S.C Period From :</label> ${user.getPeriodFrom()}
						</td>
					</tr>
					<tr align="left">

						<td><label>S.S.C Period To :</label> ${user.getPeriodTo()}</td>
						<td><label>S.S.C Degree of Diploma :</label>
							${user.getDegreeOrDiploma()}</td>
						<td><label>S.S.C Specialization :</label>
							${user.getSpecialization()}</td>
					</tr>
					<tr align="left">

						<td><label>S.S.C Percentage :</label> ${user.getPercentage()}</td>
						<td><label>S.S.C Class Or Division:</label>
							${user.getClassOrDiv()}</td>
						<td><label>H.S.C Period From :</label>
							${user.getHscPeriodFrom()}</td>
					</tr>
					<tr align="left">

						<td><label>H.S.C Period To :</label> ${user.getPeriodTo()}</td>
						<td><label>H.S.C Degree or Diploma :</label>
							${user.getHscDegreeOrDiploma()}</td>
						<td><label>H.S.C Specialization :</label>
							${user.getHscSpecialization()}</td>
					</tr>
					<tr align="left">

						<td><label>H.S.C Percentage :</label>
							${user.getHscPercentage()}</td>
						<td><label>H.S.C Class or Div :</label>
							${user.getHscclassOrDiv()}</td>
						<td><label>Degree Period From :</label>
							${user.getDegreePeriodFrom()}</td>
					</tr>
					<tr align="left">

						<td><label>Degree Period To :</label>
							${user.getDegreePeriodTo()}</td>
						<td><label>Degree Degree Or Diploma :</label>
							${user.getDegreeDegreeOrDiploma()}</td>
						<td><label>Degree Specialization :</label>
							${user.getDegreeSpecialization()}</td>
					</tr>
					<tr align="left">

						<td><label>Degree Percentage :</label>
							${user.getDegreePercentage()}</td>
						<td><label>Degree Class Or Div :</label>
							${user.getDegreeClassOrDiv()}</td>
							</tr>
							<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Computer Knowledge :</font></td></tr>
							<tr align="left">
						<td><label>Programming Language :</label>
							${user.getProgramingLanguages()}</td>
					</tr>
					<tr align="left">

						<td><label>Application Software/Packages :</label>
							${user.getApplicationSoftware()}</td>
						<td><label>Certifications (Mention version & date) :</label>
							${user.getCert_Date()}</td>
						<td><label>Any plans for future :</label>
							${user.getFutureStudy()}</td>
					</tr>
					<tr align="left">

						<td><label>State your career objectives :</label>
							${user.getCareerObjective()}</td>
							</tr>
							<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px"> Languages Known :</font></td></tr>	
							<tr align="left">
						<td><label>Marathi Read :</label> ${user.getM_Read()}</td>
						<td><label>Marathi Write :</label> ${user.getM_Write()}</td>
					</tr>
					<tr align="left">

						<td><label>Marathi Speak :</label> ${user.getM_Speak()}</td>
						<td><label>Marathi Comprehend :</label>
							${user.getM_Comprehend()}</td>
						<td><label>Mother Tongue :</label> ${user.getM_MotherTongue()}
						</td>
					</tr>
					<tr align="left">

						<td><label>Hindi Read :</label> ${user.getH_Read()}</td>
						<td><label>Hindi Wite :</label> ${user.getH_Write()}</td>
						<td><label>Hindi Speak :</label> ${user.getH_Speak()}</td>
					</tr>
					<tr align="left">

						<td><label>Hindi Comprehend :</label> ${user.getH_Comprehend()}</td>
						<td><label>Mother Tongue :</label> ${user.getH_MotherTongue()}</td>
						<td><label>English Read :</label> ${user.getE_Read()}</td>
					</tr>
					<tr align="left">

						<td><label>English Write :</label> ${user.getE_Write()}</td>
						<td><label>English Speak :</label> ${user.getE_Speak()}</td>
						<td><label>English Comprehend :</label>
							${user.getE_Comprehend()}</td>
					</tr>
					<tr align="left">

						<td><label>Mother Tongue :</label> ${user.getE_MotherTongue()}</td>
						<td><label>Other Read :</label> ${user.getO_Read()}</td>
						<td><label>Other Write :</label> ${user.getO_Write()}</td>
					</tr>
					<tr align="left">
						<td><label>Other Speak :</label> ${user.getO_Speak()}</td>
						<td><label>Other Comprehend :</label> ${user.getO_Comprehend()}
						</td>
						<td><label>Mother Tongue :</label> ${user.getO_MotherTongue()}</td>
					</tr>
					<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px"> Employment History :</font></td></tr>			
					<tr align="left">
						<td><label>Technical Skill :</label> ${user.getTech_Skill1()}</td>
						<td><label>Other Skill 2 :</label> ${user.getOtherSkill1()}</td>
						<td><label>Total Experience in Year :</label>
							${user.getExperience()}</td>
					</tr>
					<tr align="left">

						<td><label>Relevant Experience :</label>
							${user.getRelevantExperience()}</td>
							</tr>
							<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Previous Employment Details :</font></td></tr>
							<tr align="left">
						<td><label>Employer :</label> ${user.getEmployer()}</td>
						<td><label>Type of Buisness :</label> ${user.getBusinessType()}</td>
					</tr>
					<tr align="left">

						<td><label>Employee Address :</label> ${user.getEmp_Address()}</td>
						<td><label>Reason for seeking change/leaving :</label>
							${user.getReson_Change()}</td>
						<td><label>Period Of Service :</label> ${user.getServiceFrom()}</td>
					</tr>
					<tr align="left">

						<td><label>Period of Service To :</label>
							${user.getServiceTo()}</td>
						<td><label>Salary Drawn :</label> ${user.getDrawnCTC()}</td>
						<td><label>Ph.No. :</label> ${user.getEmp_phone()}</td>
					</tr>
					<tr align="left">

						<td><label>Designation :</label> ${user.getDesignation()}</td>
						<td><label>Name of Immediate Senior :</label>
							${user.getSeniorName()}</td>
						<td><label>Designation of Immediate Senior :</label>
							${user.getSeniorDesignation()}</td>
					</tr>
					<tr align="left">

						<td><label>Current CTC :</label> ${user.getCurrentCTC()}</td>
						<td><label>Expected CTC :</label> ${user.getExpectedCTC()}</td>
						<td><label>Joining Time Required :</label>
							${user.getJoinTime()}</td>
					</tr>
					<tr align="left">

						<td><label>Do you need Relocation :</label>
							${user.getRelocation()}</td>
							</tr>
							<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Previous Job :</font></td></tr>
							<tr align="left">
						<td><label>Employee Name 1 :</label> ${user.getEmployerName1()}
						</td>
						<td><label>Employee Address 1 :</label>
							${user.getEmployerAddress1()}</td>
					</tr>
					<tr align="left">

						<td><label>Employee From 1 :</label> ${user.getEmployerFrom1()}</td>
						<td><label>Employee To 1 :</label> ${user.getEmployerTo1()}</td>
						<td><label>Employee Designation 1 :</label>
							${user.getEmployerDesignation1()}</td>
					</tr>
					<tr align="left">

						<td><label>Last Salary 1 :</label> ${user.getLastSalary1()}</td>
						<td><label>Employee Name 2 :</label> ${user.getEmployerName2()}
						</td>
						<td><label>Employee Address 2 :</label>
							${user.getEmployerAddress2()}</td>
					</tr>
					<tr align="left">

						<td><label>Employee From 2 :</label> ${user.getEmployerFrom2()}</td>
						<td><label>Employee To 2 :</label> ${user.getEmployerTo2()}</td>
						<td><label>Employee Designation 2 :</label>
							${user.getEmployerDesignation2()}</td>
					</tr>
					<tr align="left">

						<td><label>Last Salary 2 :</label> ${user.getLastSalary2()}</td>
						<td><label>Hobbies & Interests :</label> ${user.getHobbies()}</td>
						</tr>
						<tr align="left" style="background-color:  #E8E8E8"><td colspan="3"><font color="#42B5F4" size="3px">Passport / Visa Details :</font></td></tr>
						<tr align="left">
						<td><label>Passport No :</label> ${user.getPassportNo()}</td>
					</tr>
					<tr align="left">

						<td><label>Place Of Issue :</label> ${user.getIssuePlace()}</td>
						<td><label>Date Of Issue :</label> ${user.getIssueDate()}</td>
						<td><label>Date Of Expiry :</label> ${user.getExpiryDate()}</td>
					</tr>
					<tr align="left">

						<td><label>Nationality :</label> ${user.getNationality()}</td>
						<td><label>ECNR Status :</label> ${user.getStatusECNR()}</td>
						<td><label>PAN No:</label> ${user.getPanNo()}</td>
					</tr>
					<tr align="left">

						<td><label>If not,have you applied for a Passport? :</label>
							${user.getNotPassport()}</td>
						<td><label>Place & Date of Application :</label>
							${user.getApp_Date()}</td>
						<td><label>Place and Date of Application :</label>
							${user.getApp_Date()}</td>
					</tr>
					<tr align="left">
					<td><label>App Place :</label> ${user.getApp_Place()}</td>
					<td><label>Countries travelled abroad :</label>
						${user.getTravelledCountries()}</td>
					<td><label>Have you been refused Visa any time? :</label>
						${user.getRefuseVisa()}</td>
					</tr>


				</table>
			</div>
</body>
</html>