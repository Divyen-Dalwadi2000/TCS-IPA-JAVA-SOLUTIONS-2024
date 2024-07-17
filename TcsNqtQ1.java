// Objective: Write a Java program that calculates and displays the cube of integers from 1 up to a given number n.

// Input:
// An integer n (1 ≤ n ≤ 100), representing the upper limit for the cube calculations.

// Output:
// Display the cubes of integers from 1 to n in the following format:
// 1 : 1
// 2 : 8
// 3 : 27
// ...
// n : n^3

// ======================================= 😇 Best of Luck 😇 ===============================================
// Input
// n : 4

// Output:
// 1 : 1
// 2 : 8
// 3 : 27
// 4 : 64


import java.util.Scanner;

class Cube {
    public void printCube(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.printf("%d : %d%n", i, i * i * i);
        }
    }
}

public class TcsNqtQ1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cube obj = new Cube();
        
        System.out.print("Enter value for n: ");
        int n = sc.nextInt();
        
        obj.printCube(n);
        
        sc.close(); 
    }
}
