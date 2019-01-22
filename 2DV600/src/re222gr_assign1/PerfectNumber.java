/**
 * 
 */
package re222gr_assign1;

/**
 * @author rjosi
 *
 */
import java.util.Scanner;

public class PerfectNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// takes in a number from user
		System.out.print("Enter a positive number: ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		if (number > 0) {
			System.out.print("The divisors of " + number + " are: ");
			// calculating the divisors 
			for (int i = 1; i <= number; i++) {
				if (number % i == 0) {
					//prints out the calculated numbers
					System.out.print(i + ", ");
				}
			}
			scanner.close();
		}
	}

}
