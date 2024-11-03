//Problem Statement
//Hotel Booking System
//Objective:
//Write a Java program that manages hotel booking records. The program should:
//
//Count the total number of rooms booked in a specified month.
//Find the hotel with the second-highest total bill among hotels offering a specified wifi option.
//Input Format
//Hotel Booking Information for 4 Hotels: For each booking, input the following details in order:
//
//Hotel ID (Integer): Unique identifier for the hotel.
//Hotel Name (String): The name of the hotel.
//Date of Booking (String): The date the booking was made, in "dd-MM-yyyy" format.
//Number of Rooms Booked (Integer): The total rooms booked.
//Wifi Facility (String): "Yes" if wifi is available, "No" otherwise.
//Total Bill (Double): The total bill amount for the booking.
//Month (String): A two-digit month string (e.g., "01" for January, "12" for December) representing the month to search for room bookings.
//
//Wifi Availability (String): "Yes" or "No" to specify whether to search for hotels with or without wifi.
//
//Output Format
//First Output:
//Print the total number of rooms booked in the specified month. If no rooms are booked in that month, output:
//	

//input :
//	101
//	HotelA
//	10-05-2023
//	3
//	Yes
//	2000.0
//	102
//	HotelB
//	15-05-2023
//	5
//	Yes
//	3000.0
//	103
//	HotelC
//	20-06-2023
//	2
//	No
//	1500.0
//	104
//	HotelD
//	25-05-2023
//	4
//	Yes
//	2500.0
//	05
//	Yes
//
//	
//	output:
//		12
//		102

//input: 
//	201
//	HotelX
//	11-07-2023
//	2
//	Yes
//	1800.0
//	202
//	HotelY
//	15-08-2023
//	6
//	No
//	3500.0
//	203
//	HotelZ
//	10-07-2023
//	1
//	Yes
//	2200.0
//	204
//	HotelW
//	05-08-2023
//	4
//	Yes
//	2000.0
//	07
//	No
//
//	
//	o/p 
//	3
//	No such option available


import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test_3_Complex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Hotel> rooms = new ArrayList<>();

        // Input for 4 hotel bookings
        for (int i = 0; i < 4; i++) {
            int hId = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String dOfBook = sc.nextLine();
            int noOfRoomsBooked = sc.nextInt();
            sc.nextLine();
            String wifiFaci = sc.nextLine();
            double totalBill = sc.nextDouble();
            sc.nextLine();
            rooms.add(new Hotel(hId, name, dOfBook, noOfRoomsBooked, wifiFaci, totalBill));
        }

        // Input for month and wifi availability
        String month = sc.nextLine();
        String avail = sc.nextLine();

        // Number of rooms booked in the given month
        int roomsBooked = noOfRoomsBookedInGivenMonth(rooms, month);
        if (roomsBooked == 0) {
            System.out.println("No rooms booked in the given month");
        } else {
            System.out.println(roomsBooked);
        }

        // Hotel with the second highest bill having the specified wifi option
        Hotel sHighBill = searchHotelByWifiOption(rooms, avail);
        if (sHighBill == null) {
            System.out.println("No such option available");
        } else {
            System.out.println(sHighBill.getHotelId());
        }

        sc.close();
    }

    // Method to count rooms booked in a specific month
    public static int noOfRoomsBookedInGivenMonth(List<Hotel> rooms, String month) {
        int roomsBooked = 0;
        for (Hotel r : rooms) {
            String[] dateArr = r.getDateOfBooking().split("-");
            String m = dateArr[1];
            if (m.equalsIgnoreCase(month)) {
                roomsBooked += r.getNoOfRoomsBooked();
            }
        }
        return roomsBooked;
    }

    // Method to find the hotel with the second highest bill with a given wifi option
    public static Hotel searchHotelByWifiOption(List<Hotel> rooms, String avail) {
        List<Hotel> list = new ArrayList<>();
        for (Hotel r : rooms) {
            if (r.getWifiFacility().equalsIgnoreCase(avail)) {
                list.add(r);
            }
        }

        if (list.size() < 2) {
            return null;
        } else {
            Collections.sort(list, Comparator.comparingDouble(Hotel::getTotalBill).reversed());
            return list.get(1); // Second highest bill
        }
    }
}

class Hotel {
    private int hotelId;
    private String hotelName;
    private String dateOfBooking;
    private int noOfRoomsBooked;
    private String wifiFacility;
    private double totalBill;

    public Hotel(int hotelId, String hotelName, String dateOfBooking, int noOfRoomsBooked, String wifiFacility, double totalBill) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.dateOfBooking = dateOfBooking;
        this.noOfRoomsBooked = noOfRoomsBooked;
        this.wifiFacility = wifiFacility;
        this.totalBill = totalBill;
    }

    public int getHotelId() {
        return hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getDateOfBooking() {
        return dateOfBooking;
    }

    public int getNoOfRoomsBooked() {
        return noOfRoomsBooked;
    }

    public String getWifiFacility() {
        return wifiFacility;
    }

    public double getTotalBill() {
        return totalBill;
    }
}
