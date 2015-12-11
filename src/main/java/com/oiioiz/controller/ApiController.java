package com.oiioiz.controller;

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
}
