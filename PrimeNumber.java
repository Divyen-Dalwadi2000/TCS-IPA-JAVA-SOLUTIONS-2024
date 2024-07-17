import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        // int n = 11 ;
        // int n = 3 ;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Value for n :  ");
        int n = sc.nextInt();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        if (count == 2) {
            System.out.println(n + " is a Prime");
        } else {
            System.out.println(n + " is Not a  Prime");
        }
    }
}