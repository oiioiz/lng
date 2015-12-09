package com.oiioiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oiioiz.service.LngService;

@Controller
public class LngController {
	@Autowired
	private LngService lngService;
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("lastRound", lngService.getLastRound());
		
		return "index";
	}
}
