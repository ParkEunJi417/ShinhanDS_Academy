package com.shinhan.day04;

public class Korean {
	// 1.field : 변수(값저장)
	private String nation="대한민국";
	private String name;
	private String ssn;
	
	public Korean(String name, String ssn) {
//		super(); → 후에 배움
		this.name = name;
		this.ssn = ssn;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	// 3.일반함수 : setter, getter
	
//	String getNation() {
//		return nation;
//	}
//	
//	void setNation(String nation) {
//		this.nation=nation;
//	}
}
