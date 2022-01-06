/**
 * 
 */
package com.spartenportal.excelexporter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
 
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.spartenportal.entity.User;

/**
 * 
 * ..
 * @author Ashwini dhikale
 *
 */
public class ExcelExporter {
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<User> listUsers;
     
    public ExcelExporter(List<User> listUsers) {
        this.listUsers = listUsers;
        workbook = new XSSFWorkbook();
    }
 
 // create a header line
    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users Details");
         
        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
         
        
        
        
        createCell(row, 0, "User ID", style);      
        createCell(row, 1, "User Name", style);       
        createCell(row, 2, "Password", style); 
        createCell(row, 3, "Last Name", style);
        createCell(row, 4, "First Name", style);
       createCell(row, 5, " Middle Name", style);
       createCell(row, 6, " Place", style);
       createCell(row, 7, " Birth Date", style);	
       createCell(row, 8, " Marital Status", style);
       createCell(row, 9, " Gender", style);
       createCell(row, 10, "Blood Group", style);
       createCell(row, 11, "  Present Address", style);
       createCell(row, 12, " Telephone Number", style);
       createCell(row, 13, " Mobile Number", style);
       createCell(row, 14, " Email", style);	
       createCell(row, 15, " Permanent Address", style);	
       createCell(row, 16, " permanent Telephone Number", style);
       createCell(row, 17, "Relative Name", style);
       createCell(row, 18, "Relative Position", style);	
       createCell(row, 19, " Relatives Relationship", style);	
       createCell(row, 20, " Adharcard Number", style);	
       createCell(row, 21, " Pancard Number", style);	
       createCell(row, 22, " Account Holder Name", style);
       createCell(row, 23, " Bank Name	", style);
       createCell(row, 24, "  Bank Account Number", style);
       createCell(row, 25, " Bank Branch Name", style);	
       createCell(row, 26, " IFSC Code", style);
       createCell(row, 27, " PF Account Number", style);	
       createCell(row, 28, " UAN Number", style);
       createCell(row, 29, " Father Name", style);
       createCell(row, 30, " Father Contact Number", style);	
       createCell(row, 31, " Father Education", style);
       createCell(row, 32, " Father Occupation", style);
       createCell(row, 33, " Mother Name", style);	
       createCell(row, 34, " Mother Contact Number", style);	
       createCell(row, 35, " Mother Education", style);
       createCell(row, 36, " Mother Occupation	", style);
       createCell(row, 37, "Wife/Husband Name	", style);
       createCell(row, 38, " Wife/Husband Contact Number", style);	
       createCell(row, 38, " Wife/Husband Education", style);	
       createCell(row, 40, " Wife/Husband Occupation", style);
       createCell(row, 41, " Children Name	", style);
       createCell(row, 42, "Children Contact Number", style);	
       createCell(row, 43, " Children Education", style);	
       createCell(row, 44, " Children Occupation", style);	
       createCell(row, 45, " Brother Name", style);	
       createCell(row, 46, " Brother Contact Number", style);	
       createCell(row, 47, " Brother Education", style);
       createCell(row, 48, " Brother Occupation", style);
       createCell(row, 49, " Sister Name", style);	
       createCell(row, 50, " Sister Number", style);
       createCell(row, 50, " Sister Education", style);	
       createCell(row, 51, " Sister Occupation", style);
       createCell(row, 52, " School Name", style);	
       createCell(row, 53, " Period From", style);	
       createCell(row, 54, " Period To	", style);
       createCell(row, 55, " Degree Or Diploma", style);	
       createCell(row, 56, " Specialization", style);
       createCell(row, 57, " Percentage", style);	
       createCell(row, 58, " Class Or Div", style);	
       createCell(row, 59, " Collage Name	", style);
       createCell(row, 60, " H.S.C. Period From", style);	
       createCell(row, 61, " H.S.C. Period To	", style);
       createCell(row, 62, " H.S.C. Degree Or Diploma", style);
       createCell(row, 63, " H.S.C. Specialization", style);	
       createCell(row, 64, " H.S.C.Percentage", style);
       createCell(row, 65, " H.S.C. class Or Div", style);
       createCell(row, 66, " University Name", style);
       createCell(row, 67, " Degree Period From	", style);
       createCell(row, 68, " Degree Period To", style);	
       createCell(row, 69, " Degree Degree Or Diploma", style);	
       createCell(row, 70, " Degree Specialization	", style);
       createCell(row, 71, " Degree Percentage	", style);
       createCell(row, 72, " Degree Class Or Div", style);
       createCell(row, 73, " Programing Languages	", style);
       createCell(row, 74, " Application Software", style);	
       createCell(row, 75, " Certifications Version	", style);
       createCell(row, 76, " Certifications Date", style);	
       createCell(row, 77, " \r\n"
       		+ "Any plans for future studies", style);
       createCell(row, 78, " State your career objectives for the next three years ", style);	
       createCell(row, 79, " Marathi Read", style);	
       createCell(row, 80, "Marathi Write", style);	
       createCell(row, 81, " Marathi Speak	", style);
       createCell(row, 82, " Marathi Comprehend	", style);
       createCell(row, 83, " Marathi  MotherTongue", style);	
       createCell(row, 84, " Hindi Read", style);
       createCell(row, 85, " Hindi Write	", style);
       createCell(row, 86, " Hindi Speak", style);
       createCell(row, 87, " Hindi Comprehend", style);
       createCell(row, 88, " Hindi MotherTongue", style);	
       createCell(row, 89, " English Read", style);	
       createCell(row, 90, " English Write", style);
       createCell(row, 91, " English Speak", style);
       createCell(row, 92, " English Comprehend", style);	
       createCell(row, 93, " English MotherTongue", style);	
       createCell(row, 94, " Other Language", style);
       createCell(row, 95, " Other Read", style);	
       createCell(row, 96, " Other Write", style);	
       createCell(row, 97, " Other Speak", style);	
       createCell(row, 98, " Other Comprehend", style);
       createCell(row, 99, " Other MotherTongue", style);	
       createCell(row, 100, " Technical Skills 1", style);	
       createCell(row, 101, " Technical Skills 2", style);	
       createCell(row, 102, " Other Skill 1", style);	
       createCell(row, 103, " Experience", style);	
       createCell(row, 104, " Relevant Experience", style);	
       createCell(row, 105, " Employer", style);	
       createCell(row, 106, " Type of business	", style);
       createCell(row, 107, " Employer Address", style);	
       createCell(row, 108, " Reason for seeking change/leaving", style);
       createCell(row, 109, " Period of Service(From)", style);	
       createCell(row, 110, " Period of Service(To)	", style);
       createCell(row, 111, " Salary Drawn (CTC)	", style);
       createCell(row, 112, " emp phone	", style);
       createCell(row, 113, " Designation", style);	
       createCell(row, 114, "Name of immediate senior", style);	
       createCell(row, 115, " Designation of immediate senior", style);
       createCell(row, 116, " Current CTC", style);	
       createCell(row, 117, " Expected CTC", style);
       createCell(row, 118, " Joining Time ", style);
       createCell(row, 119, " Do you need Relocation", style);
       createCell(row, 120, " Employer Name 1	", style);
       createCell(row, 121, " Employer Address 1", style);	
       createCell(row, 122, " Employer From 1	", style);
       createCell(row, 123, " Employer To 1	", style);
       createCell(row, 124, " Employer Designation1", style);
       createCell(row, 125, " Last Salary 1", style);	
   	 createCell(row, 126, " Employer Name 2", style);
       createCell(row, 127, " Employer Address 2", style);
       createCell(row, 128, " Employer From 2	", style);
       createCell(row, 129, " Employer To 2", style);
       createCell(row, 130, " Employer Designation 2	", style);
       createCell(row, 131, " Last Salary 2", style);	
       createCell(row, 132, " Hobbies", style);
       createCell(row, 133, " Passport No", style);	
       createCell(row, 134, " Place of Issue", style);
       createCell(row, 135, " Date of Issue	", style);
       createCell(row, 136, " Expiry Date", style);
       createCell(row, 137, " Nationality", style);
       createCell(row, 138, " Status ECNR", style);	
       createCell(row, 139, " pan No", style);
       createCell(row, 140, " If not, have you applied for a Passport?", style);	
       createCell(row, 141, " Place  of Application", style);
       createCell(row, 142, " Date of Application	", style);
       createCell(row, 143, " Countries travelled abroad", style);
       createCell(row, 144, " Refuse Visa", style);	
       createCell(row, 145, " Valid Visa", style);
       createCell(row, 146, " IsActive	", style);
       createCell(row, 147, " Current Date	", style);
       createCell(row, 148, " Modify Date", style);
       createCell(row, 149, " Client Company Name", style);
       
       

    
    
    }
     
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        } else
        	if (value instanceof Date) {
                cell.setCellValue((Date) value);
            }else
            	if (value instanceof Float) {
                    cell.setCellValue((Float) value);
                }else
       	if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    //create data which comes from db
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (User user : listUsers) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
//            createCell(row, columnCount++, user.getUserid(), style);
//            createCell(row, columnCount++, user.getUserName(), style);
//            createCell(row, columnCount++, user.getPassword(), style);
//            createCell(row, columnCount++, user.getLastName(), style);
//            createCell(row, columnCount++, user.getFirstName(), style);
//            
            
           createCell(row, columnCount++, user.getUserid(), style);
    		createCell(row, columnCount++, user.getUserName(), style);
    		createCell(row, columnCount++, user.getPassword(), style);
    		createCell(row, columnCount++, user.getLastName(), style);
    		createCell(row, columnCount++, user.getFirstName(), style);
    		createCell(row, columnCount++, user.getMiddleName(), style);
    		createCell(row, columnCount++, user.getPlace(), style);
    		createCell(row, columnCount++, user.getBirthDate(), style);
    		createCell(row, columnCount++, user.getMaritalStatus(), style);
    		createCell(row, columnCount++, user.getGender(), style);
    		createCell(row, columnCount++, user.getBloodGroup(), style);
    		createCell(row, columnCount++, user.getPresentAddress(), style);
    		createCell(row, columnCount++, user.getTelephone(), style);
    		createCell(row, columnCount++, user.getMobile(), style);
    		createCell(row, columnCount++, user.getEmail(), style);
    		createCell(row, columnCount++, user.getPermanentAddress(), style);
    		createCell(row, columnCount++, user.getPermanentTelephone(), style);
    		createCell(row, columnCount++, user.getRelativeName(), style);
    		createCell(row, columnCount++, user.getRelativePosition(), style);
    		createCell(row, columnCount++, user.getRelativesRelationship(), style);
    		createCell(row, columnCount++, user.getAdharNumber(), style);
    		createCell(row, columnCount++, user.getPanNumber(), style);
    		createCell(row, columnCount++, user.getHolderName(), style);
    		createCell(row, columnCount++, user.getBankName(), style);
    		createCell(row, columnCount++, user.getAccountNumber(), style);
    		createCell(row, columnCount++, user.getBranchName(), style);
    		createCell(row, columnCount++, user.getIfscCode(), style);
    		createCell(row, columnCount++, user.getPfAccountNumber(), style);
    		createCell(row, columnCount++, user.getUanNumber(), style);
    		createCell(row, columnCount++, user.getFatherName(), style);
    		createCell(row, columnCount++, user.getFatherContactNumber(), style);
    		createCell(row, columnCount++, user.getFatherEducation(), style);
    		createCell(row, columnCount++, user.getFatherOccupation(), style);
    		createCell(row, columnCount++, user.getMotherName(), style);
    		createCell(row, columnCount++, user.getMotherContactNumber(), style);
    		createCell(row, columnCount++, user.getMotherEducation(), style);
    		createCell(row, columnCount++, user.getMotherOccupation(), style);
    		createCell(row, columnCount++, user.getwOrHName(), style);
    		createCell(row, columnCount++, user.getwOrHContactNumber(), style);
    		createCell(row, columnCount++, user.getwOrHEducation(), style);
    		createCell(row, columnCount++, user.getwOrHOccupation(), style);
    		createCell(row, columnCount++, user.getChildrenName(), style);
    		createCell(row, columnCount++, user.getChildrenContactNumber(), style);
    		createCell(row, columnCount++, user.getChildrenEducation(), style);
    		createCell(row, columnCount++, user.getChildrenOccupation(), style);
    		createCell(row, columnCount++, user.getBrotherName(), style);
    		createCell(row, columnCount++, user.getBrotherContactNumber(), style);
    		createCell(row, columnCount++, user.getBrotherEducation(), style);
    		createCell(row, columnCount++, user.getBrotherOccupation(), style);
    		createCell(row, columnCount++, user.getSisterName(), style);
    		createCell(row, columnCount++, user.getSisterNumber(), style);
    		createCell(row, columnCount++, user.getSisterEducation(), style);
    		createCell(row, columnCount++, user.getSisterOccupation(), style);
    		createCell(row, columnCount++, user.getSchoolName(), style);
    		createCell(row, columnCount++, user.getPeriodFrom(), style);
    		createCell(row, columnCount++, user.getPeriodTo(), style);
    		createCell(row, columnCount++, user.getDegreeOrDiploma(), style);
    		createCell(row, columnCount++, user.getSpecialization(), style);
    		createCell(row, columnCount++, user.getPercentage(), style);
    		createCell(row, columnCount++, user.getClassOrDiv(), style);
    		createCell(row, columnCount++, user.getCollageName(), style);
    		createCell(row, columnCount++, user.getHscPeriodFrom(), style);
    		createCell(row, columnCount++, user.getHscPeriodTo(), style);
    		createCell(row, columnCount++, user.getHscDegreeOrDiploma(), style);
    		createCell(row, columnCount++, user.getHscSpecialization(), style);
    		createCell(row, columnCount++, user.getHscPercentage(), style);
    		createCell(row, columnCount++, user.getHscclassOrDiv(), style);
    		createCell(row, columnCount++, user.getUniversityName(), style);
    		createCell(row, columnCount++, user.getDegreePeriodFrom(), style);
    		createCell(row, columnCount++, user.getDegreePeriodTo(), style);
    		createCell(row, columnCount++, user.getDegreeDegreeOrDiploma(), style);
    		createCell(row, columnCount++, user.getDegreeSpecialization(), style);
    		createCell(row, columnCount++, user.getDegreePercentage(), style);
    		createCell(row, columnCount++, user.getDegreeClassOrDiv(), style);
    		createCell(row, columnCount++, user.getProgramingLanguages(), style);
    		createCell(row, columnCount++, user.getApplicationSoftware(), style);
    		createCell(row, columnCount++, user.getCert_Version(), style);
    		createCell(row, columnCount++, user.getCert_Date(), style);
    		createCell(row, columnCount++, user.getFutureStudy(), style);
    		createCell(row, columnCount++, user.getCareerObjective(), style);
    		createCell(row, columnCount++, user.getM_Read(), style);
    		createCell(row, columnCount++, user.getM_Write(), style);
    		createCell(row, columnCount++, user.getM_Speak(), style);
    		createCell(row, columnCount++, user.getM_Comprehend(), style);
    		createCell(row, columnCount++, user.getM_MotherTongue(), style);
    		createCell(row, columnCount++, user.getH_Read(), style);
    		createCell(row, columnCount++, user.getH_Write(), style);
    		createCell(row, columnCount++, user.getH_Speak(), style);
    		createCell(row, columnCount++, user.getH_Comprehend(), style);
    		createCell(row, columnCount++, user.getH_MotherTongue(), style);
    		createCell(row, columnCount++, user.getE_Read(), style);
    		createCell(row, columnCount++, user.getE_Write(), style);
    		createCell(row, columnCount++, user.getE_Speak(), style);
    		createCell(row, columnCount++, user.getE_Comprehend(), style);
    		createCell(row, columnCount++, user.getE_MotherTongue(), style);
    		createCell(row, columnCount++, user.getOtherLanguage(), style);
    		createCell(row, columnCount++, user.getO_Read(), style);
    		createCell(row, columnCount++, user.getO_Write(), style);
    		createCell(row, columnCount++, user.getO_Speak(), style);
    		createCell(row, columnCount++, user.getO_Comprehend(), style);
    		createCell(row, columnCount++, user.getO_MotherTongue(), style);
    		createCell(row, columnCount++, user.getTech_Skill1(), style);
    		createCell(row, columnCount++, user.getTech_Skill2(), style);
    		createCell(row, columnCount++, user.getOtherSkill1(), style);
    		createCell(row, columnCount++, user.getExperience(), style);
    		createCell(row, columnCount++, user.getRelevantExperience(), style);
    		createCell(row, columnCount++, user.getEmployer(), style);
    		createCell(row, columnCount++, user.getBusinessType(), style);
    		createCell(row, columnCount++, user.getEmp_Address(), style);
    		createCell(row, columnCount++, user.getReson_Change(), style);
    		createCell(row, columnCount++, user.getServiceFrom(), style);
    		createCell(row, columnCount++, user.getServiceTo(), style);
    		createCell(row, columnCount++, user.getDrawnCTC(), style);
    		createCell(row, columnCount++, user.getEmp_phone(), style);
    		createCell(row, columnCount++, user.getDesignation(), style);
    		createCell(row, columnCount++, user.getSeniorName(), style);
    		createCell(row, columnCount++, user.getSeniorDesignation(), style);
    		createCell(row, columnCount++, user.getCurrentCTC(), style);
    		createCell(row, columnCount++, user.getExpectedCTC(), style);
    		createCell(row, columnCount++, user.getJoinTime(), style);
    		createCell(row, columnCount++, user.getRelocation(), style);
    		createCell(row, columnCount++, user.getEmployerName1(), style);
    		createCell(row, columnCount++, user.getEmployerAddress1(), style);
    		createCell(row, columnCount++, user.getEmployerFrom1(), style);
    		createCell(row, columnCount++, user.getEmployerTo1(), style);
    		createCell(row, columnCount++, user.getEmployerDesignation1(), style);
    		createCell(row, columnCount++, user.getLastSalary1(), style);
    		createCell(row, columnCount++, user.getEmployerName2(), style);
    		createCell(row, columnCount++, user.getEmployerAddress2(), style);
    		createCell(row, columnCount++, user.getEmployerFrom1(), style);
    		createCell(row, columnCount++, user.getEmployerTo2(), style);
    		createCell(row, columnCount++, user.getEmployerDesignation2(), style);
    		createCell(row, columnCount++, user.getLastSalary2(), style);
    		createCell(row, columnCount++, user.getHobbies(), style);
    		createCell(row, columnCount++, user.getPassportNo(), style);
    		createCell(row, columnCount++, user.getIssuePlace(), style);
    		createCell(row, columnCount++, user.getIssueDate(), style);
    		createCell(row, columnCount++, user.getExpiryDate(), style);
    		createCell(row, columnCount++, user.getNationality(), style);
    		createCell(row, columnCount++, user.getStatusECNR(), style);
    		createCell(row, columnCount++, user.getPanNo(), style);
    		createCell(row, columnCount++, user.getNotPassport(), style);
    		createCell(row, columnCount++, user.getApp_Place(), style);
    		createCell(row, columnCount++, user.getApp_Date(), style);
    		createCell(row, columnCount++, user.getTravelledCountries(), style);
    		createCell(row, columnCount++, user.getRefuseVisa(), style);
    		createCell(row, columnCount++, user.getValidVisa(), style);
    		createCell(row, columnCount++, user.getIsActive(), style);
    		createCell(row, columnCount++, user.getCurrentDate(), style);
    		createCell(row, columnCount++, user.getModifyDate(), style);
    	
             
        }
    }
     
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
}

