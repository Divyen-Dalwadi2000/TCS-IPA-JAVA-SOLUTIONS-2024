import java.util.Scanner;

public class PSimple1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count = 0;
		while (number > 0) {
			int rem = number % 10;
			if (rem % 2 != 0) {
				count++;
//				System.out.println(rem);
			}
			number = number /10 ;
		}

		if (count >= 3) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

}
