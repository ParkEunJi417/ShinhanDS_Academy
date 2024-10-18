package com.shinhan.day15;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExampleTest {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// 클라이언트는 Ip, Port를 알아야함
		Socket socket = new Socket("localhost",5001);
		System.out.println("클라이언트 연결 성공");
		socket.close();
		System.out.println("클라이언트 연결 종료");
	}
}
