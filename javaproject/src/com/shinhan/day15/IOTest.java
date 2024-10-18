package com.shinhan.day15;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString(of= {"name","age","name2","age2"})
class Student implements Serializable {
	private String name;
	private int age;
	private static String name2;
	private transient int age2;
}

public class IOTest {

	public static void main(String[] args) {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
		f10();
	}
	
	private static void f10() {
		File f = new File("cc.data");
		
		System.out.println(f.exists());
		System.out.println(f.isDirectory());
		System.out.println(f.getAbsoluteFile());
	}

	private static void f9() {
		try(FileInputStream fis = new FileInputStream("cc.data");
			ObjectInputStream ois = new ObjectInputStream(fis)) {
				
//			Member m1 = (Member) ois.readObject();
//			Member m2 = (Member) ois.readObject();
//			Member m3 = (Member) ois.readObject();
			
			Student m1 = (Student) ois.readObject();
			Student m2 = (Student) ois.readObject();
			Student m3 = (Student) ois.readObject();
			
			System.out.println(m1);
			System.out.println(m2);
			System.out.println(m3);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private static void f8() {
		try(FileOutputStream fos = new FileOutputStream("cc.data");
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			
//			oos.writeObject(new Member("홍길동1",20));
//			oos.writeObject(new Member("홍길동2",30));
//			oos.writeObject(new Member("홍길동3",40));
			
			oos.writeObject(new Student("A",10,20));
			oos.writeObject(new Student("B",20,20));
			oos.writeObject(new Student("C",30,20));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f7() {
		// 자바의 기본타입 저장, 읽기
		try(FileOutputStream fos = new FileOutputStream("bb.txt");
			DataOutputStream dos = new DataOutputStream(fos)) {
			
			dos.writeInt(100);
			dos.writeDouble(3.141592);
			dos.writeBoolean(true);
			dos.writeUTF("문자");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try(FileInputStream fis = new FileInputStream("bb.txt");
			DataInputStream dis = new DataInputStream(fis)) {
			
			int i = dis.readInt()+200;
			double d = dis.readDouble()+100;
			boolean b = dis.readBoolean();
			String s = dis.readUTF();
			
			System.out.println("int:"+i);
			System.out.println("double:"+d);
			System.out.println("boolean:"+b);
			System.out.println("String:"+s);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void f6() {
		try(FileReader fr = new FileReader("aa.txt");
			BufferedReader br = new BufferedReader(fr)) {
			
			String line;
			line = br.readLine();
			System.out.println(line.replaceAll("/", "\t")+"\t총점\t평균");
			while((line = br.readLine())!=null){
				String[] arr = line.split("/");
//				System.out.println(Arrays.toString(arr));
				
				int total = 0;
				double avg = 0;
				
				for(int i=1;i<arr.length;i++) {
					total += Integer.parseInt(arr[i]);
				}
				System.out.println(line.replaceAll("/", "\t")+"\t"+total+"\t"+total / (arr.length-1));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void f5() {
		// FileWriter : 파일 출력
		try(FileWriter fw = new FileWriter("aa.txt")) {
			
			fw.write("오늘은 금요일 입니다.1\n");
			fw.write("오늘은 금요일 입니다.2\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void f4() {
		// PrintStream : 모니터 출력
		PrintStream ps = System.out;
		
		try {
			byte[] arr="자바".getBytes();
			ps.write(arr);
			ps.print("자바");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f3() {
		// FileReader : 2byte
		try (FileReader fr = new FileReader("src/com/shinhan/day15/Review.java")) {
			int i;
			while ((i = fr.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f2() {
		// FileInputStream : 1byte씩 입력, newline(10), enter(13)
		// InputStreamReader : 1byte를 2byte로(한글이 깨지지않음)
		// End Of File(EOF) : -1
		try (FileInputStream fi = new FileInputStream("src/com/shinhan/day15/Review.java");
				InputStreamReader ir = new InputStreamReader(fi)) {
			int i;
			while ((i = ir.read()) != -1) {
				System.out.print((char) i);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void f1() {
		// InputStream : 1byte씩 입력
		// 1.키보드
		int i;
		byte[] arr = new byte[3];

		try (InputStream is = System.in) {
			i = is.read(arr);
			System.out.println(Arrays.toString(arr));
			System.out.println(new String(arr));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
