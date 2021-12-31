package com.spartenportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.spartenportal.entity.AttendanceSheet;

/*
 *@author Deepak
 *Date 27-12-2021 
 */

public interface AttendanceSheetRepository extends JpaRepository<AttendanceSheet, Integer> {
	@Query(value = "select * from attendanceSheet where useridFK= :useridFK", nativeQuery = true)
	List<AttendanceSheet> getAttendanceSheetByuserId(@Param("useridFK") int useridFK);
	
	@Query(value = "select * from attendanceSheet where sheetOf= :date", nativeQuery = true)
	List<AttendanceSheet> getAttendanceSheetByDate(@Param("date") String date);
}
