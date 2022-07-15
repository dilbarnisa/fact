package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.FactHistory;
import com.example.demo.repository.FactHistoryRepository;

@Service
public class factHistotyService {
	@Autowired
	FactHistoryRepository facthistoryrepository;
	
	
	public FactHistory save(FactHistory factHistory) {
		return facthistoryrepository.save(factHistory);
	}
	public List<FactHistory> getList(){
		return facthistoryrepository.findAll();
	}
}
