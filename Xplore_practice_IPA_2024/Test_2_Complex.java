//Problem Statement
//Laptop Information System
//Objective:
//Write a Java program to manage information about laptops. The program should:
//
//Count the number of laptops of a specified brand with a rating above 3.
//Find and display laptops that match a specified OS type, sorted by laptop ID in descending order.
//Input Format
//Laptop Information for 4 Laptops: Each laptop's data will be entered in the following order:
//
//Laptop ID: An integer representing the laptop's unique identifier.
//Brand: A string representing the laptop’s brand.
//OS Type: A string representing the laptop’s operating system type (e.g., "Windows", "MacOS").
//Price: A double representing the laptop’s price.
//Rating: An integer representing the laptop’s rating.
//Brand (String): The brand of laptops for which to count the number of laptops with a rating above 3.
//
//OS Type (String): The OS type of laptops to search for.
//
//
//
//input:
//
//	
//	101
//	Dell
//	Windows
//	50000.0
//	4
//	102
//	Apple
//	MacOS
//	120000.0
//	5
//	103
//	Dell
//	Windows
//	55000.0
//	3
//	104
//	HP
//	Linux
//	45000.0
//	4
//	Dell
//	Windows
//
//	
//	output  : 
//		1
//		103
//		3
//		101
//		4



//
//input 2 
//201
//Lenovo
//Windows
//60000.0
//2
//202
//Acer
//Windows
//45000.0
//4
//203
//Apple
//MacOS
//150000.0
//5
//204
//Dell
//Ubuntu
//50000.0
//3
//HP
//Linux
//
//
//o/p 
//The given brand is not available
//The given OS is not available


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test_2_Complex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Laptop> laptops = new ArrayList<>();

        // Input for 4 laptops
        for (int i = 0; i < 4; i++) {
            int lId = sc.nextInt();
            sc.nextLine();
            String brand = sc.nextLine();
            String osType = sc.nextLine();
            double price = sc.nextDouble();
            int rating = sc.nextInt();
            sc.nextLine();
            laptops.add(new Laptop(lId, brand, osType, price, rating));
        }

        // Input for brand and OS type
        String brand = sc.nextLine();
        int count = countOfLaptopsByBrand(laptops, brand);
        if (count == 0) {
            System.out.println("The given brand is not available");
        } else {
            System.out.println(count);
        }

        String osType = sc.nextLine();
        List<Laptop> desIds = searchLaptopByOsType(laptops, osType);
        if (desIds == null) {
            System.out.println("The given OS is not available");
        } else {
            for (Laptop l : desIds) {
                System.out.println(l.getLaptopId());
                System.out.println(l.getRating());
            }
        }

        sc.close();
    }

    // Method to count laptops of a given brand with rating > 3
    public static int countOfLaptopsByBrand(List<Laptop> laptops, String brand) {
        int count = 0;
        for (Laptop l : laptops) {
            if (l.getBrand().equalsIgnoreCase(brand) && l.getRating() > 3) {
                count++;
            }
        }
        return count;
    }

    // Method to find laptops by OS type and sort by laptop ID in descending order
    public static List<Laptop> searchLaptopByOsType(List<Laptop> laptops, String osType) {
        List<Laptop> list = new ArrayList<>();
        for (Laptop l : laptops) {
            if (l.getOsType().equalsIgnoreCase(osType)) {
                list.add(l);
            }
        }
        Collections.sort(list, Comparator.comparingInt(Laptop::getLaptopId).reversed());
        return list.isEmpty() ? null : list;
    }
}

class Laptop {
    private int laptopId;
    private String brand;
    private String osType;
    private double price;
    private int rating;

    public Laptop(int laptopId, String brand, String osType, double price, int rating) {
        this.laptopId = laptopId;
        this.brand = brand;
        this.osType = osType;
        this.price = price;
        this.rating = rating;
    }

    public int getLaptopId() {
        return laptopId;
    }

    public String getBrand() {
        return brand;
    }

    public String getOsType() {
        return osType;
    }

    public double getPrice() {
        return price;
    }

    public int getRating() {
        return rating;
    }
}
