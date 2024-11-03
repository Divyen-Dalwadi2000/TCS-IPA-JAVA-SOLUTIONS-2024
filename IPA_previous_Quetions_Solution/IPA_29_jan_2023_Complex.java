
/*
 class HeadSets 
 
 
 headSetName - String 
 brand String 
 price int 
 available boolean 
 
 
 attributes should be private , write getter and setters and parameterized constructor 
 
 
implement two static methods   
1) findTotalPriceForGivenBrand() 

retrur ntotalPrice of HEadsets from array of iobjects for the given brand (String) 
if no then return 0, "No HEadsets available with the given brand" 


2) findAvailableHeadsetWithSecondMinPrice()

take array of HEadSets as an input 
returns available headsets with the second Lowest price 

if no then return null , "No Headsets available" . 


input: 
 
BOAT 233
boat
1220
true
Tune 333
jbl 
1500
true
boat 213
boat
1000
true
realme 2 neo 
realme
500
true 
boat

output : 
2220 ( 1220+1000 )

boat 213
1000

 */
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IPA_29_jan_2023_Complex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<HeadSet> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			String hsName = sc.nextLine();
			String brand = sc.nextLine();
			int price = sc.nextInt();
			sc.nextLine();
			boolean avail = sc.nextBoolean();
			sc.nextLine();

			list.add(new HeadSet(hsName, brand, price, avail));
		}

		String brand = sc.nextLine();
		int total_price = findTotalPriceForGivenBrand(list, brand);
		if (total_price == 0) {
			System.out.println("No HeadSets available with the given brand ");
		} else {
			System.out.println(total_price);
		}

		HeadSet avail = findAvailableHeadsetWithSecondMinPrice(list);
		if (avail == null) {
			System.out.println("no Such Headset available ");
		} else {
			System.out.println(avail.getHeadSetName());
			System.out.println(avail.getPrice());

		}
	}

	public static int findTotalPriceForGivenBrand(List<HeadSet> list, String brand) {
		int price = 0;
		for (HeadSet h : list) {
			if (h.getBrand().equalsIgnoreCase(brand)) {
				price += h.getPrice();
			}
		}

		return price;
	}

	public static HeadSet findAvailableHeadsetWithSecondMinPrice(List<HeadSet> list) {
					List <HeadSet> l = new ArrayList<>();
					HeadSet obj = null ;
					
					for(HeadSet h : list )
					{
						if(h.getAvailable())
						{
							l.add(h);
						}
					}
					if(l.size() ==0)
					{
						return null ;
					}else
					{
						Collections.sort(l, Comparator.comparingInt(HeadSet::getPrice));
						obj = l.get(1);
						return obj;
						
					}
	}
}

class HeadSet {
	private String headSetName;
	private String brand;
	private int price;
	private boolean available;

	public HeadSet(String headSetName, String brand, int price, boolean available) {
		this.headSetName = headSetName;
		this.brand = brand;
		this.price = price;
		this.available = available;
	}

	public String getHeadSetName() {
		return headSetName;
	}

	public String getBrand() {
		return brand;
	}

	public int getPrice() {
		return price;
	}

	public boolean getAvailable() {
		return available;
	}
}



// input 2 
//BOAT 233
//boat
//1220
//false
//Tune 333
//jbl 
//1500
//false
//boat 213
//boat
//1000
//false
//realme 2 neo 
//realme
//500
//false
//boat