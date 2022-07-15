// Java Program to Illustrate DemoController

// Importing package to code module
package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
// Importing required classes
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


import com.example.demo.model.FactHistory;
import com.example.demo.repository.FactHistoryRepository;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;  
import org.json.JSONObject;  
import org.json.JSONObject;  

// Annotation
@Controller

// Class
public class DemoController {
	
	@Autowired
	FactHistoryRepository factHistoryRepository;

	@RequestMapping(value = "/animal_fact/{animal}", method = RequestMethod.GET)
	@ResponseBody
	public String animal_fact(@PathVariable("animal") String animal, HttpServletRequest request)
	{
		if(animal.equalsIgnoreCase("cat")) {
			String url = "https://cat-fact.herokuapp.com/facts/random";
			RestTemplate restTemplate = new RestTemplate();
			String result=restTemplate.getForObject(url, String.class);
			JsonObject data = new Gson().fromJson(result, JsonObject.class);
			String fact = data.get("text").toString();
			String client_ip = request.getRemoteAddr();
			Date date = new Date();
			FactHistory factHistory = new FactHistory(client_ip , fact, date.toString() );
			FactHistory factHistoryrepo = factHistoryRepository.save(factHistory);
			return fact;
		}
		else if(animal.equalsIgnoreCase("dog")) {
			String url = "https://dog-facts-api.herokuapp.com/api/v1/resources/dogs?number=1";
			RestTemplate restTemplate = new RestTemplate();
			String result=restTemplate.getForObject(url, String.class);
			JsonArray data = new Gson().fromJson(result, JsonArray.class);
			JsonObject fact_map= (JsonObject) data.get(0);
			String fact = fact_map.get("fact").toString();
			String client_ip = request.getRemoteAddr();
			Date date = new Date();
			FactHistory factHistory = new FactHistory(client_ip , fact, date.toString() );
			FactHistory factHistoryrepo = factHistoryRepository.save(factHistory);
			return fact;
		}
		else {
			return "animal not found";
		}
	}
	
	@RequestMapping(value = "/animal_fact_history", method = RequestMethod.GET)
	@ResponseBody
	public List<FactHistory> animal_fact_history()
	{
		List<FactHistory> allHistory=factHistoryRepository.findAll();
		return allHistory;
	}
	
}
