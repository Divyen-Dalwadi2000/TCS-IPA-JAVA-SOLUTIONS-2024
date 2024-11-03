//Problem Statement
//Sum of Odd Numbers in an Array
//Objective:
//Write a Java program to read 5 integers into an array. The program should then calculate the sum of all odd numbers in the array and output the sum if it is greater than 8 and less than 50. If the sum does not meet these criteria, the program should output "NA."
//
//Input Format
//The input consists of 5 integers, each on a new line.
//
//input : 
//	5
//	12
//	7
//	20
//	3
//output: 
//	Sum of odd numbers:15
//
//input : 
//2
//4
//6
//8
//10

//output: 
//NA

import java.util.Scanner;

public class Test_3_Simple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[5];

        // Reading 5 integers into the array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        // Calculating the sum of odd numbers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                sum += arr[i];
            }
        }

        // Output based on the sum's value
        if (sum < 50 && sum > 8) {
            System.out.println("Sum of odd numbers:" + sum);
        } else {
            System.out.println("NA");
        }

        sc.close();
    }
}
