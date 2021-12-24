package com.spartenportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spartenportal.entity.Docs;

public interface DocRepository extends JpaRepository<Docs, Integer> {
	@Query(value = "select * from docs where userid= :userId", nativeQuery = true)
	List<Docs> getDocsByuserId(@Param("userId") int userId);
}
