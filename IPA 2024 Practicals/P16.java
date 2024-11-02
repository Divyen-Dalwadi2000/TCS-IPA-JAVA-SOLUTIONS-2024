
/*
 Problem Statement:

Create a class NavalVessel with the following attributes:

vesselId – int
vesselName – String
noOfVoyagesPlanned – int
noOfVoyagesCompleted – int
purpose – String
Write getters and setters for the above attributes. Additionally, create a constructor that takes parameters in the above sequence, except for classification.

Then, create a class Solution with a main method and implement two static methods – findAvgVoyagesByPct and findVesselByGrade in the Solution class.

Method Details
findAvgVoyagesByPct Method:

This method will take two input parameters: an array of NavalVessel objects and an int parameter 
percentage.
The method will calculate the average of the noOfVoyagesCompleted attribute from NavalVessel objects that meet the percentage requirement.
The percentage for each NavalVessel is calculated as:

percentage = (noOfVoyagesCompleted×100 )/ noOfVoyagesPlanned 

If the calculated percentage is greater than or equal to the percentage passed as the parameter, 
then those objects should participate in the average calculation.
If there are no objects meeting the specified criteria, the method should return 0.

findVesselByGrade Method:

This method will take a String parameter purpose, along with the array of NavalVessel objects.
The method will return the NavalVessel object if the input String parameter matches the purpose
 attribute of the NavalVessel object.
Before returning the object, a classification should be derived based on the following criteria:
If percentage = 100, then classification should be "Star".
If percentage is between 99 and 80, then classification should be "Leader".
If percentage is between 79 and 55, then classification should be "Inspirer".
Otherwise, the classification should be "Striver".
If the criteria are not met, the method should return null and print "No Naval Vessel is available with the specified purpose".
Instructions
In the main method, use a Scanner object to read the values of four NavalVessel objects, referring to the attributes in the specified order (excluding the classification attribute).
Read the values for percentage and purpose.


111
Rojer
100
100
Passenger
222
Kalam
200
100
Goods
333
Yashwin
400
300
Army
444
Thanishwini
500
500
Welfare
75
Army


300
Yashwin%Inspir

 */
import java.util.Scanner;
import java.util.Arrays;

public class P16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NavalVessel[] officers = new NavalVessel[4];
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < officers.length; i++) {
			int vId = sc.nextInt();
			sc.nextLine();
			String vName = sc.nextLine();
			int noOfVoyagesPlanned = sc.nextInt();
			sc.nextLine();
			int noOfVoyagesCompleted = sc.nextInt();
			sc.nextLine();
			String purpose = sc.nextLine();

			officers[i] = new NavalVessel(vId, vName, noOfVoyagesPlanned, noOfVoyagesCompleted, purpose);

		}
//		for (NavalVessel o : officers) {
//			System.out.printf("\n%d %s %d %d %s", o.getVesselId(), o.getVesselName(), o.getNoOfVoyagesPlanned(),
//					o.getNoOfVoyagesCompleted(), o.getPurpose());
//		}
		int percentage = sc.nextInt();
		sc.nextLine();

		String purpose = sc.nextLine();
		int avg = findAvgVoyagesByPct(officers, percentage);
		if (avg != 0) {

			System.out.println(avg);
		} else {
			System.out.println("No such percentage are greater than the given ");
		}

		NavalVessel obj[] = findVesselByGrade(officers, purpose);
		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				int per = (obj[i].getNoOfVoyagesCompleted() * 100) / obj[i].getNoOfVoyagesPlanned();
				String classification = "";
				if (per == 100) {
					classification = "Star";
				} else if (per < 100 && percentage > 80) {
					classification = "Leader";

				} else if (per < 80 && percentage > 55) {

					classification = "Inspirer";
				} else {
					classification = "Striver";
				}
				System.out.printf("%s%%%s", obj[i].getVesselName(), classification);
			}

		}
	}

	public static int findAvgVoyagesByPct(NavalVessel[] officers, int per) {
		int avg = 0;
		int count = 0, sum = 0;
		for (NavalVessel o : officers) {
			int percentage = (o.getNoOfVoyagesCompleted() * 100) / o.getNoOfVoyagesPlanned();
			if (percentage >= per) {
				sum += o.getNoOfVoyagesCompleted();
				count++;
			}
			avg = sum / count;
		}
		return avg;
	}

	public static NavalVessel[] findVesselByGrade(NavalVessel[] officers, String purpose) {
		NavalVessel obj[] = new NavalVessel[0];

		for (NavalVessel o : officers) {
			if (o.getPurpose().equalsIgnoreCase(purpose)) {
//				int percentage = (o.getNoOfVoyagesCompleted() * 100) / o.getNoOfVoyagesPlanned();
				obj = Arrays.copyOf(obj, obj.length + 1);
				obj[obj.length - 1] = o;
			}
		}

		return obj;

	}
}

class NavalVessel {
	private int vesselId;
	private String vesselName;
	private int noOfVoyagesPlanned;
	private int noOfVoyagesCompleted;
	private String purpose;

	public NavalVessel(int vesselId, String vesselName, int noOfVoyagesPlanned, int noOfVoyagesCompleted,
			String purpose) {
		this.vesselId = vesselId;
		this.vesselName = vesselName;
		this.noOfVoyagesPlanned = noOfVoyagesPlanned;
		this.noOfVoyagesCompleted = noOfVoyagesCompleted;
		this.purpose = purpose;
	}

	public int getVesselId() {
		return vesselId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public int getNoOfVoyagesPlanned() {
		return noOfVoyagesPlanned;
	}

	public int getNoOfVoyagesCompleted() {
		return noOfVoyagesCompleted;
	}

	public String getPurpose() {
		return purpose;
	}
}
//111
//A
//100
//100
//Passenger
//222
//B
//200
//100
//Goods
//333
//C
//400
//300
//Army
//444
//D
//500
//500
//Welfare