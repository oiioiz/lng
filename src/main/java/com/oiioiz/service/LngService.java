package com.oiioiz.service;

import java.util.List;

import com.oiioiz.entity.DrawInfo;

public interface LngService {
	DrawInfo getRoundInfo(int round);
	
	public List<Integer> getMostWinningNumbers(boolean withBonusNumber, String sort);
	
	public List<Integer> getAppearanceWinningNumbers(boolean withBonusNumber);
}
