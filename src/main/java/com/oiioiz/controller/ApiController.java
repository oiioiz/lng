package com.oiioiz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oiioiz.entity.DrawInfo;
import com.oiioiz.service.LngService;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private LngService lngService;

	@RequestMapping(value = "/{round}", method = RequestMethod.GET)
	public DrawInfo getDrawInfo(@PathVariable int round) {

		DrawInfo drawInfo = lngService.getRoundInfo(round);

		return drawInfo;
	}
	
	@RequestMapping(value = "/most/{withBonusNumber}/{sort}", method = RequestMethod.GET)
	public List<Integer> getMostWinningNumbers(@PathVariable boolean withBonusNumber, @PathVariable String sort) {

		List<Integer> mostWinningNumbers = lngService.getMostWinningNumbers(withBonusNumber, sort);

		return mostWinningNumbers;
	}
}
