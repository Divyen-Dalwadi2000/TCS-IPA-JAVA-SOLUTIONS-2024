/*
 Create class Resort 
 
 
 resortId int 
 resortName - String 
 category String 
 price double 
 rating double 
 
 attributes private , write getter and setters and parameterized constructor 
 
 
 create a Solution class 

implement static method - findAvgPriceByCategory 
take two parameter - array of resort objets and String(category) parameter 
return avg price of resort(int) from array of resort obj and given category(String ) 
if no resort fount the method should return 0 and "There are no such available resort" .



input 1 

1005
A
3 star
3500.00
3.5
1001
B
5 star
7500.00
4
1007
C
3 star
2500.00
4.7
1003
D
3 star
4600.00
4.3
3 star 

output : 
Average price of 3 Star Resort:3550

 */

import java.util.Scanner;

public class IPA_22_Apr_23_Complex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Resort arr[] = new Resort[4];

		for (int i = 0; i < arr.length; i++) {
			int rId = sc.nextInt();
			sc.nextLine();
			String rName = sc.nextLine();
			String category = sc.nextLine();
			double price = sc.nextDouble();
			sc.nextLine();
			double rating = sc.nextDouble();
			sc.nextLine();

			arr[i] = new Resort(rId, rName, category, price, rating);
		}

		String category = sc.nextLine();
		int avg = findAvgPriceByCategory(arr, category);

		if (avg == 0) {
			System.out.println("There are no such available resort.");
		} else {
			System.out.printf("Average price of %s Resort:%s", category, avg);
		}

	}

	public static int findAvgPriceByCategory(Resort arr[], String cat) {
		int avg = 0, sum = 0, count = 0;
		for (Resort r : arr) {
			if (r.getCategory().equalsIgnoreCase(cat) && r.getRating() > 4) {
				count++;
				sum += r.getPrice();
			}
		}
		avg = sum / count;

		return avg;
	}

}

class Resort {

	private int resortId;
	private String resortName;
	private String category;
	private double price;
	private double rating;

	public Resort(int resortId, String resortName, String category, double price, double rating) {
		this.resortId = resortId;
		this.resortName = resortName;
		this.category = category;
		this.price = price;
		this.rating = rating;
	}

	public String getCategory() {
		return category;
	}

	public double getPrice() {
		return price;
	}

	public double getRating() {
		return rating;
	}

}