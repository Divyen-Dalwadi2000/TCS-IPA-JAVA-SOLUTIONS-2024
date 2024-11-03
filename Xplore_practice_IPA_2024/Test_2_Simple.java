//Problem Statement
//Check if Sum of Digits is Divisible by 3
//Objective:
//Write a Java program that reads an integer, calculates the sum of its digits, and determines if this sum is divisible by 3. If the sum is divisible by 3, the program should output TRUE; otherwise, it should output FALSE.
//
//Input Format
//A single integer num (1 ≤ num ≤ 10<sup>9</sup>).
//
//input 
//123
//	
//output
//TRUE

//input
//124
//o/p 
//FALSE


import java.util.Scanner;

public class Test_2_Simple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 0;

        // Calculate the sum of digits
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num = num / 10;
        }

        // Check if the sum of digits is divisible by 3
        if (sum % 3 == 0) {
            System.out.println("TRUE");
        } else {
            System.out.println("FALSE");
        }

        sc.close();
    }
}
