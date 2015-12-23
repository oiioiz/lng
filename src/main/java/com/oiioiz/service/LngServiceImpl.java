package com.oiioiz.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public List<Integer> getMostWinningNumbers(boolean withBonusNumber, String sort) {

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

		Map<Integer, Integer> rankNumbers = getRankNumbers(drawNumbers);

		List<Integer> winningNumber = new ArrayList<Integer>();

		if ("desc".equals(sort)) {
			for (int i = 45; i >= 1; i--) {
				setWinningNumbers(rankNumbers, i, winningNumber);
			}
		} else {
			for (int i = 1; i <= 45; i++) {
				setWinningNumbers(rankNumbers, i, winningNumber);
			}
		}

		Collections.sort(winningNumber);

		return winningNumber;
	}

	private Map<Integer, Integer> getRankNumbers(int[] drawNumbers) {
		Map<Integer, Integer> rankNumbers = new HashMap<Integer, Integer>();

		for (int i = 1; i < drawNumbers.length; i++) {
			int temp = 0;

			for (int compareNumber : drawNumbers) {
				if (compareNumber < drawNumbers[i]) {
					temp++;
				}
			}

			rankNumbers.put(i, temp);
		}
		return rankNumbers;
	}

	@Override
	public List<Integer> getAppearanceWinningNumbers(boolean withBonusNumber) {
		List<DrawInfo> drawList = drawInfoRepository.findAllByOrderByDrwNoDesc();

		int[] drawNumbers = new int[46];

		for (int i = 0; i < drawList.size(); i++) {
			DrawInfo drawInfo = drawList.get(i);

			for (int j = 1; j < drawNumbers.length; j++) {

				if (withBonusNumber) {
					if (drawInfo.getDrwtNo1() == j || drawInfo.getDrwtNo2() == j || drawInfo.getDrwtNo3() == j
							|| drawInfo.getDrwtNo4() == j || drawInfo.getDrwtNo5() == j || drawInfo.getDrwtNo6() == j || drawInfo.getBnusNo() == j) {
						if(drawNumbers[j] == 0){
							drawNumbers[j] = drawInfo.getDrwNo();
						}
					}
				}else{
					if (drawInfo.getDrwtNo1() == j || drawInfo.getDrwtNo2() == j || drawInfo.getDrwtNo3() == j
							|| drawInfo.getDrwtNo4() == j || drawInfo.getDrwtNo5() == j || drawInfo.getDrwtNo6() == j ) {
						if(drawNumbers[j] == 0){
							drawNumbers[j] = drawInfo.getDrwNo();
						}
					}
				}

			}
		}
		
		Map<Integer, Integer> rankNumbers = getRankNumbers(drawNumbers);

		List<Integer> winningNumber = new ArrayList<Integer>();

		for (int i = 1; i <= 45; i++) {
			setWinningNumbers(rankNumbers, i, winningNumber);
		}

		Collections.sort(winningNumber);

		return winningNumber;
	}

	private void setWinningNumbers(Map<Integer, Integer> rankNumbers, int idx, List<Integer> winningNumber) {
		for (int j = 1; j <= 45; j++) {
			if (rankNumbers.get(j) == idx && winningNumber.size() < 6) {
				winningNumber.add(j);
			}
		}
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

			if (round == 0) {
				nanumLastRound = drawInfo.getDrwNo();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return drawInfo;
	}
}