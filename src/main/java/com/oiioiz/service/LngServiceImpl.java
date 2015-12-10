package com.oiioiz.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oiioiz.entity.DrawInfo;
import com.oiioiz.repository.DrawInfoRepository;

@Service
@Transactional
public class LngServiceImpl implements LngService {

	@Autowired
	private DrawInfoRepository drawInfoRepository;

	private static final String NANUM_URL = "http://www.nlotto.co.kr/common.do?method=getLottoNumber";

	private static int nanumLastRound = 0;

	@Override
	public DrawInfo getRoundInfo(int round) {
		DrawInfo drawInfo = getNanumDrawInfo(round);

		checkLastRound();
		return drawInfo;
	}

	@Override
	public int[] getMostWinningNumbers(boolean withBonusNumber) {

		List<DrawInfo> drawList = drawInfoRepository.findAll();

		int[] drawNumbers = new int[46];

		for (DrawInfo drawInfo : drawList) {
			drawNumbers[drawInfo.getDrwtNo1()]++;
			drawNumbers[drawInfo.getDrwtNo2()]++;
			drawNumbers[drawInfo.getDrwtNo3()]++;
			drawNumbers[drawInfo.getDrwtNo4()]++;
			drawNumbers[drawInfo.getDrwtNo5()]++;
			drawNumbers[drawInfo.getDrwtNo6()]++;
			if (withBonusNumber) {
				drawNumbers[drawInfo.getBnusNo()]++;
			}
		}

		int[] rankNumbers = new int[46];

		for (int i = 1; i < drawNumbers.length; i++) {
			int temp = 0;

			for (int compareNumber : drawNumbers) {
				if (compareNumber < drawNumbers[i]) {
					temp++;
				}
			}

			rankNumbers[temp] = i;
		}
		
		int[] mostWinningNumber = {rankNumbers[40], rankNumbers[41], rankNumbers[42], rankNumbers[43], rankNumbers[44], rankNumbers[45]};

		Arrays.sort(mostWinningNumber);
		
		return mostWinningNumber;
	}

	private void checkLastRound() {
		int lastRound = drawInfoRepository.getLastRound();

		if (nanumLastRound > lastRound) {
			for (int i = lastRound + 1; i <= nanumLastRound; i++) {
				DrawInfo drawInfo = getNanumDrawInfo(i);

				drawInfoRepository.save(drawInfo);
			}
		}
	}

	// get nanumlotto draw info
	private DrawInfo getNanumDrawInfo(int round) {

		String url = NANUM_URL;

		if (round != 0) {
			url += "&drwNo=" + round;
		}

		DrawInfo drawInfo = new DrawInfo();

		try {

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// optional default is GET
			con.setRequestMethod("GET");

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			ObjectMapper om = new ObjectMapper();

			drawInfo = om.readValue(response.toString(), DrawInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return drawInfo;
	}
}