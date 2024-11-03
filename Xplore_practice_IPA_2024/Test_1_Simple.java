//Problem Statement
//Average of Array Elements Within a Specified Range
//Objective:
//Write a Java program that reads an array of five integers, followed by two additional integers representing the start and end of a range. The program should calculate and output the average of the array elements that are greater than the start value and less than the end value. If no elements fall within the specified range, the program should indicate that no such elements were found.
//
//Input Format
//First 5 Lines: Each line contains a single integer, representing the elements of the array.
//6th Line: An integer representing the start of the range.
//7th Line: An integer representing the end of the range.
//Output Format
//If there are elements within the specified range, output a single integer representing the average (using integer division) of these elements.

// input : 
//10
//20
//30
//40
//50
//15
//45
//
// output
//30

import java.util.Scanner;

public class Test_1_Simple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];

        // Read 5 integers into the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            sc.nextLine(); // Consume the remaining newline character
        }

        // Read the start and end values
        int start = sc.nextInt();
        int end = sc.nextInt();

        int sum = 0, count = 0;

        // Calculate the sum and count of elements within the range
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > start && arr[i] < end) {
                sum += arr[i];
                count++;
            }
        }

        // Calculate and print the average
        if (count != 0) {
            System.out.println(sum / count);
        } else {
            System.out.println("No elements found in the given range.");
        }

        sc.close();
    }
}
