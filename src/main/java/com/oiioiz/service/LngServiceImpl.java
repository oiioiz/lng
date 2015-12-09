package com.oiioiz.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oiioiz.model.NanumVO;

@Service
@Transactional
public class LngServiceImpl implements LngService {

	private static final String URL = "http://www.nlotto.co.kr/common.do?method=getLottoNumber";
	@Override
	public int getLastRound() {
		int lastRound = 0;
		
		try {
			lastRound = getNanumInfo(0).getDrwNo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lastRound;
	}

	// get Nanum info
	private NanumVO getNanumInfo(int round) throws Exception {

		String url = URL;
		
		if(round != 0){
			url += "&drwNo=" + round;
		}
		
		URL obj = new URL(URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + URL);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		ObjectMapper om = new ObjectMapper();
		NanumVO nanumVO = om.readValue(response.toString(), NanumVO.class);
		
		return nanumVO;
	}

}
