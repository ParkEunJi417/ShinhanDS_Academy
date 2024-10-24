package com.shinhan.day15.exam2_teacher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;

public class Prob4 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Product[] prodList = { new Product("NT450R5E-K24S", 500000, "삼성전자"),
				new Product("15UD340-LX2CK", 400000, "LG전자"), new Product("G2-K3T32AV", 600000, "HP") };
		HashSet<Product> product_hs = makeHashSet(prodList, 500000);
		makeFile(product_hs);
		readFile();

	}

	private static HashSet<Product> makeHashSet(Product[] prodList, int price) {
		HashSet<Product> hs = new HashSet<>();

		for (Product p : prodList) {
			if (p.getPrice() >= price) {
				hs.add(p);
				System.out.println(p);
			}
		}

		return hs;
	}

	// 자바 → ObjectOutputStream → FileOutputStream →  파일(data.txt)
	private static void makeFile(HashSet resultList) throws IOException {
		FileOutputStream fos = new FileOutputStream("src/data.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(resultList);
		
		oos.close();
		fos.close();
	}

	// 자바 → ObjectOutputStream → FileOutputStream →  파일(data.txt)
	private static void readFile() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("src/data.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		HashSet<Product> resultList = (HashSet<Product>) ois.readObject();
		
		for(Product p:resultList) {
			System.out.println(p);
		}
		
		ois.close();
		fis.close();
	}

}

class Product implements Serializable {
	private String model_name;
	private int price;
	private String company;

	public Product(String model_name, int price, String company) {
		super();
		this.model_name = model_name;
		this.price = price;
		this.company = company;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Product [model_name=" + model_name + ", price=" + price + ", company=" + company + "]";
	}

}