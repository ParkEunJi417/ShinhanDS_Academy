package com.shinhan.day06.exercise;

import java.util.Scanner;

public class BankApplication {
	// 1.field
	static Scanner sc = new Scanner(System.in);
	static Account[] arrAccount= new Account[100];
	static int sequence=0;
	
	// 2.생성자 → 생략
	// 3.메서드
	public static void main(String[] args) {
		boolean isStop=false;

		while(!isStop) {
			menu();
			int job = f_jobSelect();
			
			switch (job) {
				case 1 ->{ makeAccount(); }
				case 2 ->{ accountPrint(); }
				case 3 ->{ saveAccount(); }
				case 4 ->{ withdrawAccount(); }
				case 5 ->{
					isStop=true;
					System.out.println("프로그램 종료");
					}
				default ->{ System.out.println("잘못된 메뉴 선택"); }
			}
		}
		sc.close();
	}
	
	private static int f_jobSelect() {
		System.out.print("선택>");
		return Integer.parseInt(sc.nextLine());
	}

	private static void makeAccount() {
		print("계좌생성");
		
		System.out.print("계좌번호:");
		String accNo = sc.nextLine();
		
		System.out.print("계좌주:");
		String owner = sc.nextLine();
		
		System.out.print("초기입금액:");
		int balance = Integer.parseInt(sc.nextLine());
		
		arrAccount[sequence++] = new Account(accNo, owner, balance);
	}

	private static void accountPrint() {
		print("계좌목록");
		
		for(Account acc:arrAccount) {
			if(acc!=null) {
				System.out.println(acc.getAccNo()+"\t"+acc.getOwner()+"\t"+acc.getBalance());
			}
			else
				break;
		}
	}

	private static void saveAccount() {
		print("예금");
		
		System.out.print("계좌번호:");
		String accNo = sc.nextLine();
		
		System.out.print("예금액:");
		int amount = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<arrAccount.length;i++) {
			if(arrAccount[i]==null)
				return;
			if(accNo.equals(arrAccount[i].getAccNo())) {
				int balance = arrAccount[i].getBalance();
				arrAccount[i].setBalance(balance + amount);
				return;
			}
		}
		System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
	}

	private static void withdrawAccount() {
		print("출금");
		
		System.out.print("계좌번호:");
		String accNo = sc.nextLine();
		
		System.out.print("출금액:");
		int amount = Integer.parseInt(sc.nextLine());
		
		for(int i=0;i<arrAccount.length;i++) {
			if(arrAccount[i]==null)
				return;
			if(accNo.equals(arrAccount[i].getAccNo())) {
				int balance = arrAccount[i].getBalance();
				if(balance < amount) {
					System.out.println("잔액부족 출금불가");
				}
				else {
					arrAccount[i].setBalance(balance - amount);
				}
				return;
			}
		}
		System.out.println("입력하신 계좌번호가 존재하지 않습니다.");
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
	}
}
