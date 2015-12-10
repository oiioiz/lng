package com.oiioiz.service;

import com.oiioiz.entity.DrawInfo;

public interface LngService {
	DrawInfo getRoundInfo(int round);
	
	public int[] getMostWinningNumbers(boolean withBonusNumber);
}
