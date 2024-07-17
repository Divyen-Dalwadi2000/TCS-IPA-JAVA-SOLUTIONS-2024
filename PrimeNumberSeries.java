
/**
 * PrimeNumberSeries
 */
import java.util.Scanner;

public class PrimeNumberSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a Value For The Range n : ");
        int n = sc.nextInt();

        for(int i = 2 ; i <= n ; i++)
        {
            int count = 0 ;
            for(int j = 2 ; j < i ; j++)
            {
                if(i%j==0)
                {
                    count++;
                    break;
                }
            }
            if(count==0)
            {
                System.out.println(i + " ");
            }
        }
    }
}