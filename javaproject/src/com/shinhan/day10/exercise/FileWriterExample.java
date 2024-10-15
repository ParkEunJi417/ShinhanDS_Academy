package com.shinhan.day10.exercise;

import java.io.IOException;

class FileWriter implements AutoCloseable {
	public FileWriter(String filePath) throws IOException {
		System.out.println(filePath + " 파일을 엽니다.");
	}

	public void write(String data) throws IOException {
		System.out.println(data + "를 파일에 저장합니다.");
	}

	@Override
	public void close() throws IOException {
		System.out.println("파일을 닫습니다.");
	}
}

public class FileWriterExample {
	public static void main(String[] args) {
		// 자동으로 종료함
		try( FileWriter fw = new FileWriter("file.txt")){
			fw.write("Java");
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		/*FileWriter fw = null;
		try {
			fw = new FileWriter("file.txt");
			fw.write("Java");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
			}
		}*/
	}
}