package com.oiioiz.model;

import java.io.Serializable;

public class LngVO implements Serializable {
	private static final long serialVersionUID = 5786647808345130058L;
	
	private int round;
	private boolean withBonus;
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public boolean isWithBonus() {
		return withBonus;
	}
	public void setWithBonus(boolean withBonus) {
		this.withBonus = withBonus;
	}
}