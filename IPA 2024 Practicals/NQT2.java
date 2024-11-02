// USing Class Annd Object Base Approach ;
//String productName 
//double price 
//int quantity 

// total sales amount 	
// avg sales amount 
// productName of maximum selling product

//input  
//3 
//Apple 
//10
//5
//Banana
//10
//7
//Graps
//10
//11

//output : 
//230.0
//76.67
//Graps

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class NQT2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		List<Shop> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			String productName = sc.nextLine();
			double price = sc.nextDouble();
			sc.nextLine();
			int qty = sc.nextInt();
			sc.nextLine();

			list.add(new Shop(productName, price, qty));
		}

		double total = totalSalesAmount(list);
		if (total == 0.0) {
			System.out.println("please Enter the value");
		} else {
			System.out.println(total);
		}

		double avg = avgSalesAmount(list, list.size());
		if (avg == 0.0) {
			System.out.println("please Enter the value");
		} else {
			System.out.printf("%.2f", avg);
		}

		String maxSale = maximumSellingProduct(list);
		if (maxSale == "") {
			System.out.println("please Enter the value");
		} else {
			System.out.printf("\n%s", maxSale);
		}

	}

	public static double totalSalesAmount(List<Shop> list) {
		double total = 0.0d;

		for (Shop l : list) {
			total += l.getPrice() * l.getQty();
		}
		return total;
	}

	public static double avgSalesAmount(List<Shop> list, int s) {
		double avg = 0.0d;

		for (Shop l : list) {
			avg += l.getPrice() * l.getQty();
		}

		avg = avg / s;
		return avg;
	}

	public static String maximumSellingProduct(List<Shop> list) {
		Collections.sort(list, Comparator.comparingInt(Shop::getQty).reversed());

		return list.get(0).getProductName();
	}

}

class Shop {
	private String productName;
	private double price;
	private int qty;

	public Shop(String productName, double price, int qty) {
		this.productName = productName;
		this.price = price;
		this.qty = qty;
	}

	public String getProductName() {
		return productName;
	}

	public double getPrice() {
		return price;
	}

	public int getQty() {
		return qty;
	}

}
