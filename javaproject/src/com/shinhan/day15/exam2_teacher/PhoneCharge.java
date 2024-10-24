package com.shinhan.day15.exam2_teacher;

public class PhoneCharge {
	private String user;
	private int call;
	private int sms;
	private int data;
	private int total;

	public PhoneCharge(String user, int call, int sms, int data) {
		super();
		this.user=user;
		this.call=call;
		this.sms=sms;
		this.data=data;
	}
	
	public int calcCharge() {
		int callFee;
		int smsFee;
		int dataFee;
		
		if(call >= 200) callFee = 10 * call * 2;
		else callFee = 10 * call;
		
		if(sms >= 300) smsFee = 20 * sms * 4;
		else smsFee = 20 * sms;
		
		if(data >= 7) dataFee = 1000 * data * 2;
		else dataFee = 1000 * data;
		
		return callFee+smsFee+dataFee;
	}

	public void printCharge() {
		total = calcCharge();
		System.out.println(user+" 사용자는 이번달에 사용하신 전화요금이 "+total+" 원입니다.");		
	}
}
