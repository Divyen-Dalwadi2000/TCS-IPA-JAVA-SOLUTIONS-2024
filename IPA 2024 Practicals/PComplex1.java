/*
IPA_Demo_Session_Complex

projectorId - int 
projectorName - String 
price - int (per unit ) 
rating - int 
availableIn - String (Amazon , Flipkart , Tatacliq)

The above attributes Should be private , write getters , setters and parameterized constructor as
 required . 

Create class MyClass with main method .

Implement one static method - 
findMaximumPriceByRating in Solution class 

findMaximumPriceByRating method : The method will return the maximum priced Projector object from
 array of Projector objects whichever has rating greater than the given rating and which is 
 available in TataCliq .

If no Projector with the above conditions is present in the array of Projector objects , 
then the method should return null. 

Note : No two Projector will have the same price . 

All the searches should be case insensitive 

The above mentioned static method should be called from the main method .

For findMaximumPriceByRating method - The main method should print the projectorId from returned 
object if the returned value is not null else it should print "No such Projector ".

Eg : 1001
Where 1001 is the projectorId which has the maximum price . 

Before calling these static method in main , use Scanner object to read the values of four Projector 
objects referring attributes in the above mentioned attributes sequence . 
Next , read the value of one int parameter for capturing rating value .

consider below sample input and output : 
SampleTestcase 1 : 
Input : 

1001
Epson
30000
5
TataCliq 

1002
BenQ
40000
4
Amazon

1003
Sony
80000
5
TataCliq

1004
Optomo
7000
3
Flipkart

3

Output:
1003

Sample Testcase2: 

1001
Epson
30000
5
TataCliq 

1002
BenQ
40000
4
Amazon

1003
Sony
80000
5
TataCliq

1004
Optomo
7000
3
Flipkart

5

Output:
No such Projector



Note on using Scanner Object : 
Sometimes scanner does not read the new line nextInt()
 , nextDouble() etc . Usually , this is not an issue , but this may be visible while calling 
 nextLine( ) immediately after those methods .
 
 Consider below input values : 
 1001
 Savings
 Referring below code : 
 
 Scanner  sc = new Scanner(System.in);
 int x =sc.nextInt();
 String str = sc.nextLie(); -> here we expect str to have value Savings . Insted it may be "" . 
 If above issue is observed , then it is suggested to add one more explicit call to nextLine() 
 after reading numeric value. 
 
*/

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PComplex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		Projector projectors[] = new Projector[n];
		List<Projector> projectors = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int proId = sc.nextInt();
			sc.nextLine();
			String proName = sc.nextLine();
			int price = sc.nextInt();
			sc.nextLine();
			int rating = sc.nextInt();
			sc.nextLine();
			String avail = sc.nextLine();

//			projectors[i] = new Projector(proId, proName, price, rating, avail);
			projectors.add(new Projector(proId, proName, price, rating, avail));
		}

//		for(Projector p : projectors )
//		{
//			System.out.printf("\n %d %s %d %d %s  " ,p.getProId() , p.getProName() , p.getPrice() , p.getRating()  , p.getAvailable() );
//		}
		int rate = sc.nextInt();
		sc.nextLine();
		Projector pro = findMaximumPriceByRating(projectors, rate);
		if (pro == null) {
			System.out.println("No such projector ");
		} else {
			System.out.println(pro.getProId());
		}
	}

//	public static Projector findMaximumPriceByRating(Projector[] pro, int rate) {
	public static Projector findMaximumPriceByRating(List<Projector> pro, int rate) {
//		Projector maxPriceProjector = null;
//		for (Projector p : pro) {
////			if (p.getRating() > rate && p.getAvailable().equalsIgnoreCase("TataCliq")) {
//			if (p.getRating() > rate) {
//				if (maxPriceProjector == null || p.getPrice() > maxPriceProjector.getPrice()) {
//					maxPriceProjector = p;
//				}
//			}
//		}
//		return maxPriceProjector;

		Projector maxPrice = null;
		for (Projector p : pro) {
			if (p.getRating() > rate && p.getAvailable().equalsIgnoreCase("Amazon")) {
				if (maxPrice == null || p.getPrice() > maxPrice.getPrice()) {
					maxPrice = p;
				}
			}
		}
		return maxPrice;
	}
}

class Projector {
	private int projectorId;
	private String projectorName;
	private int price;
	private int rating;
	private String availableIn;

	public Projector(int projectorId, String projectorName, int price, int rating, String availableIn) {
		this.projectorId = projectorId;
		this.projectorName = projectorName;
		this.price = price;
		this.rating = rating;
		this.availableIn = availableIn;
	}

	public int getProId() {
		return projectorId;
	}

	public String getProName() {
		return projectorName;
	}

	public int getPrice() {
		return price;
	}

	public int getRating() {
		return rating;
	}

	public String getAvailable() {
		return availableIn;
	}
}

