package com.oiioiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.oiioiz.entity.DrawInfo;

@Repository
public interface DrawInfoRepository extends JpaRepository<DrawInfo, Long> {

	@Query("select coalesce(max(drwNo), 0) from DrawInfo")
	int getLastRound();
}
