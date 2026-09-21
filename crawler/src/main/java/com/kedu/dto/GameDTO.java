package com.kedu.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class GameDTO {
	
	int seq;
	String regdate;
	String time;
	String home;
	String away;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getAway() {
		return away;
	}
	public void setAway(String away) {
		this.away = away;
	}
	public GameDTO(int seq, String regdate, String time, String home, String away) {
		this.seq = seq;
		this.regdate = regdate;
		this.time = time;
		this.home = home;
		this.away = away;
	}
	
	public GameDTO() {}
	
}
