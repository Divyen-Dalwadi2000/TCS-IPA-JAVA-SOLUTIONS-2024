// Objective
// Write a Java program that calculates and displays the total sales, average sales, and the maximum selling product based on user input for multiple products.

// Input
// An integer n (1 ≤ n ≤ 100), representing the number of products.
// For each product:
// A string for Product Name.
// A double for Price per unit.
// An integer for Quantity sold.
// Output
// Display the following results:

// Total sale amount.
// Average sales amount.
// The name of the maximum selling product.
// Example

//  Input : 
// Enter the number of products:
// 3
// Enter product details for product 1:
// Product Name: Apple
// Price per unit: 10
// Quantity sold: 5
// Enter product details for product 2:
// Product Name: Banana
// Price per unit: 10
// Quantity sold: 7
// Enter product details for product 3:
// Product Name: Graps
// Price per unit: 10
// Quantity sold: 11

//  Output :
// Total sale: 230.0
// Average sales: 76.67
// Max selling product: Graps

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TcsNqtQ2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of products dynamically
        int numProducts = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Enter the number of products:");
                numProducts = scanner.nextInt();
                validInput = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Input sales products dynamically
        List<Object[]> salesProducts = new ArrayList<>();
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter product details for product " + (i + 1) + ":");
            System.out.print("Product Name: ");
            String productName = scanner.next();
            System.out.print("Price per unit: ");
            double price = scanner.nextDouble();
            System.out.print("Quantity sold: ");
            int quantity = scanner.nextInt();

            salesProducts.add(new Object[]{productName, price, quantity});
        }

        scanner.close();

        double totalSales = 0;
        double maxSales = Double.MIN_VALUE;
        String maxSellingProduct = "";
        int totalProducts = salesProducts.size();

        // Calculate total sales and find maximum selling product
        for (Object[] product : salesProducts) {
            String productName = (String) product[0];
            double price = (double) product[1];
            int quantity = (int) product[2];

            double sales = price * quantity;
            totalSales += sales;

            if (sales > maxSales) {
                maxSales = sales;
                maxSellingProduct = productName;
            }
        }

        // Calculate average sales
        double avgSales = totalSales / totalProducts;

        // Output the results
        System.out.println("Total sale: " + totalSales);
        System.out.println("Average sales: " + avgSales);
        System.out.println("Max selling product: " + maxSellingProduct);
    }
}


