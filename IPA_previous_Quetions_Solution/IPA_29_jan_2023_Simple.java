//read the String and print the count of lower case characters present in input String value . 
//
//if no lower case are present in the String value then it should print "No lower case characters present" as a String 

// I/p
//XpLore
//
//O/P 
//4
// I/p
//XPLORE
//
//O/P 
//No lower case characters present

import java.util.Scanner;

public class IPA_29_jan_2023_Simple {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		char arr[] = str.toCharArray();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((int) arr[i] >= 97) {
				count++;
			}

		}

		if (count == 0) {
			System.out.println("No lower case characters present");
		} else {
			System.out.println(count);
		}
//		System.out.println((char)97);
//		System.out.println((int)'a');
	}

}
