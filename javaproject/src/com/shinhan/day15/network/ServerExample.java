package com.shinhan.day15.network;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(5001);
//            serverSocket.bind(new InetSocketAddress("localhost", 5001));

            while (true) {
                System.out.println("[연결 기다림]");
                Socket socket = serverSocket.accept();
                InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                System.out.println("[연결 수락함] " + isa.getHostName());

                byte[] bytes = null;
                String message = null;

                InputStream is = socket.getInputStream();
//                bytes = new byte[100];
//                int readByteCount = is.read(bytes); // blocking
//                message = new String(bytes, 0, readByteCount, "UTF-8");
                DataInputStream ids = new DataInputStream(is);
                message = ids.readUTF();
                System.out.println("[데이터 받기 성공] " + message);

                OutputStream os = socket.getOutputStream();
                message = "Hello Client";
//                bytes = message.getBytes("UTF-8");
//                os.write(bytes);
//                os.flush();
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeUTF(message);
                dos.flush();
                System.out.println("[데이터 보내기 성공]");

                is.close(); os.close(); socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
