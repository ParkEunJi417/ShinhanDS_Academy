package com.shinhan.day05.exercise;

public class ShopService {
	private static ShopService single;
	
	private ShopService() {
		
	}
	
	public static ShopService getInstance() {
		if(single==null)
			single=new ShopService();
		return single;
	}
}
