// COUNT EVEN NUMBER

// TAKE A INT NUMBER FROM USER PRINT THE NUMBER OF EVEN DIGITS IF IT IS GREATER THAN 3 OTHER THAN PRINT " IT IS NOT A VALID NUMBER "

// INPUT
// 4536782
// OUTPUT
// 4

// INPUT
// 1365279
// OUTPUT
// IT IS NOT A VALID NUMBER

package TCSEXPLORE;

import java.util.Scanner;

public class CountEvenNumber {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a Number : ");
    int number = sc.nextInt();

    int count = 0, rem = 0;
    while (number > 0) {
      rem = number % 10;
      number = number / 10;

      if (rem % 2 == 0) {
        count++;
      }
    }
    if (count > 3) {
      System.out.println(count);
    } else {
      System.out.println("IT IS NOT A VALID NUMBER");
    }
  }
}
// How To Run The package code
// javac -d . CountEvenNumber.java
// java TCSEXPLORE.CountEvenNumber
