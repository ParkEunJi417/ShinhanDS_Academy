package com.shinhan.day05.exercise;

import java.util.Scanner;

public class BankApplication {
	static Scanner sc = new Scanner(System.in);
	static Account_Ex20[] accountArray= new Account_Ex20[100];
	
	public static void main(String[] args) {
		boolean isStop=false;
		String select;

		while(!isStop) {
			menu();
			select = sc.nextLine();
			
			switch (select) {
				case "1" ->{ createAccount(); }
				case "2" ->{ accountList(); }
				case "3" ->{ deposit(); }
				case "4" ->{ withdraw(); }
				case "5" ->{
					isStop=true;
					System.out.println("프로그램 종료");
					}
				default ->{ System.out.println("잘못된 메뉴 선택"); }
			}
		}
	}
	
	private static void createAccount() {
		print("계좌생성");
		
		System.out.print("계좌번호:");
		String account = sc.nextLine();
		
		System.out.print("계좌주:");
		String name = sc.nextLine();
		
		System.out.print("초기입금액:");
		int balance = sc.nextInt();
		sc.nextLine();
		
		Account_Ex20 acc = new Account_Ex20(account, name, balance);
		
		for(int i=0; i<accountArray.length;i++) {
			if(accountArray[i] == null) {
				accountArray[i] = acc;
				System.out.println("결과: 계좌가 생성되었습니다.");
				break;
			}
		}
	}

	private static void accountList() {
		print("계좌목록");
		
		for(Account_Ex20 acc:accountArray) {
			if(acc!=null) {
				System.out.println(acc.getAccount()+"\t"+acc.getName()+"\t"+acc.getBalance());
			}
		}
	}

	private static void deposit() {
		print("예금");
		
		System.out.print("계좌번호:");
		String insertAccount = sc.nextLine();
		
		System.out.print("예금액:");
		int insertAmount = sc.nextInt();
		sc.nextLine();
		
		Account_Ex20 acc = findAccount(insertAccount);
		
		if(acc == null)
			System.out.println("해당하는 계좌번호 미존재로 예금불가");
		else {
			acc.setBalance(acc.getBalance()+insertAmount);
			System.out.println("결과: 예금이 성공되었습니다.");
		}
	}

	private static void withdraw() {
		print("출금");
		
		System.out.print("계좌번호:");
		String insertAccount = sc.nextLine();
		
		System.out.print("출금액:");
		int insertAmount = sc.nextInt();
		sc.nextLine();
		
		Account_Ex20 acc = findAccount(insertAccount);
		
		if(acc == null)
			System.out.println("해당하는 계좌번호 미존재로 출금불가");
		else {
			acc.setBalance(acc.getBalance()-insertAmount);
			System.out.println("결과: 출금이 성공되었습니다.");
		}
	}
	
	private static Account_Ex20 findAccount(String insertAcc) {
		Account_Ex20 findAcc = null;
		for(Account_Ex20 acc:accountArray) {
			if(acc == null)
				break;
			else {
				if(insertAcc.equals(acc.getAccount()))
					findAcc = acc;
			}
		}
		return findAcc;
	}

	private static void print(String message) {
		System.out.println("----------");
		System.out.println(message);
		System.out.println("----------");
	}
	
	private static void menu() {
		System.out.println("------------------------");
		System.out.println("1.계좌생성|2.계좌목록|3.예금|4.출금|5.종료");
		System.out.println("------------------------");
		System.out.print("선택>");
	}
}
