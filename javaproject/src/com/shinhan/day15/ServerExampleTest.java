package com.shinhan.day15;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExampleTest {

	public static void main(String[] args) throws IOException {
		// 이제부터 서비스를 제공하겠다는 의미. 들어오는 문(port)은 5001
		ServerSocket serverSocket = new ServerSocket(5001);
		System.out.println("[서버] 시작");
		
		Socket socket = serverSocket.accept(); // 대기, 클라이언트가 오면 수락
		InetSocketAddress addr = (InetSocketAddress) socket.getRemoteSocketAddress();
		System.out.println(addr.getHostName()+"연결 요청을 수락함");
	}
}
