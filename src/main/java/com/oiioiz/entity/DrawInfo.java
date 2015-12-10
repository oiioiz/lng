package com.oiioiz.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_DRAW_INFO")
@JsonIgnoreProperties(ignoreUnknown = true)
public class DrawInfo implements Serializable {
	private static final long serialVersionUID = 7067044177772067803L;

	@Id
	@Column(name = "ROUND")
	int drwNo;
	@Column(name = "DRAW_DATE")
	String drwNoDate;
	@Column(name = "NUMBER_1")
	int drwtNo1;
	@Column(name = "NUMBER_2")
	int drwtNo2;
	@Column(name = "NUMBER_3")
	int drwtNo3;
	@Column(name = "NUMBER_4")
	int drwtNo4;
	@Column(name = "NUMBER_5")
	int drwtNo5;
	@Column(name = "NUMBER_6")
	int drwtNo6;
	@Column(name = "NUMBER_BONUS")
	int bnusNo;

	public int getDrwNo() {
		return drwNo;
	}

	public void setDrwNo(int drwNo) {
		this.drwNo = drwNo;
	}

	public String getDrwNoDate() {
		return drwNoDate;
	}

	public void setDrwNoDate(String drwNoDate) {
		this.drwNoDate = drwNoDate;
	}

	public int getDrwtNo1() {
		return drwtNo1;
	}

	public void setDrwtNo1(int drwtNo1) {
		this.drwtNo1 = drwtNo1;
	}

	public int getDrwtNo2() {
		return drwtNo2;
	}

	public void setDrwtNo2(int drwtNo2) {
		this.drwtNo2 = drwtNo2;
	}

	public int getDrwtNo3() {
		return drwtNo3;
	}

	public void setDrwtNo3(int drwtNo3) {
		this.drwtNo3 = drwtNo3;
	}

	public int getDrwtNo4() {
		return drwtNo4;
	}

	public void setDrwtNo4(int drwtNo4) {
		this.drwtNo4 = drwtNo4;
	}

	public int getDrwtNo5() {
		return drwtNo5;
	}

	public void setDrwtNo5(int drwtNo5) {
		this.drwtNo5 = drwtNo5;
	}

	public int getDrwtNo6() {
		return drwtNo6;
	}

	public void setDrwtNo6(int drwtNo6) {
		this.drwtNo6 = drwtNo6;
	}

	public int getBnusNo() {
		return bnusNo;
	}

	public void setBnusNo(int bnusNo) {
		this.bnusNo = bnusNo;
	}
}