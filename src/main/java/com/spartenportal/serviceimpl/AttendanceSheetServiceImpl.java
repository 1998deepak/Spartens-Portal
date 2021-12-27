package com.spartenportal.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.spartenportal.bean.AttendanceSheetBean;
import com.spartenportal.entity.AttendanceSheet;
import com.spartenportal.entity.User;
import com.spartenportal.mapper.AttendanceSheetMapper;
import com.spartenportal.repository.AttendanceSheetRepository;
import com.spartenportal.service.AttendanceSheetService;

public class AttendanceSheetServiceImpl implements AttendanceSheetService{

	@Autowired
	AttendanceSheetMapper attendanceSheetMapper;
	
	@Autowired
	AttendanceSheetRepository attendanceSheetRepository;
	
	@Override
	public List<AttendanceSheet> getSheetByuserIdFk(int useridFK) {
		// TODO Auto-generated method stub
		return attendanceSheetRepository.getAttendanceSheetByuserId(useridFK);
	}

	@Override
	public Optional<AttendanceSheet> getSheets(Integer fileId) {
		return attendanceSheetRepository.findById(fileId);
	}

	@Override
	public List<AttendanceSheet> getSheets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttendanceSheet saveFile(MultipartFile file, AttendanceSheetBean attendanceSheetBean, User user) {
		try {
			attendanceSheetBean.setSheetName(file.getOriginalFilename());
			attendanceSheetBean.setSheetType(file.getContentType());
			attendanceSheetBean.setSheet(file.getBytes());
			attendanceSheetBean.setUploadDate(new Date());
			attendanceSheetBean.setModifyDate(new Date());
			AttendanceSheet sheet = attendanceSheetMapper.mapToEntity(attendanceSheetBean, user);
			return attendanceSheetRepository.save(sheet);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteAttendanceSheet(int sheetId) {
		// TODO Auto-generated method stub
		attendanceSheetRepository.deleteById(sheetId);
	}

}
