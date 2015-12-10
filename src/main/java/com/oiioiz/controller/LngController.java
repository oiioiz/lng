package com.oiioiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oiioiz.model.LngVO;
import com.oiioiz.service.LngService;

@Controller
public class LngController {
	@Autowired
	private LngService lngService;
	
	@RequestMapping("/")
	public String index(LngVO lngVO, Model model){
		
		model.addAttribute("roundInfo", lngService.getRoundInfo(lngVO.getRound()));
		model.addAttribute("mostWinnigNumbers", lngService.getMostWinningNumbers(lngVO.isWithBonus()));
		
		return "index";
	}
}
