package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.FactHistory;

@Repository
public interface FactHistoryRepository extends JpaRepository<FactHistory, Integer>{
	List<FactHistory> findAll();
}
