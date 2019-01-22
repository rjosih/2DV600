/**
 * 
 */
package re222gr_assign1;

/**
 * @author rjosi
 *
 */

public class FibonacciSequence {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int a = 0;
		int b = 1;
		int sum = a + b;
		int count = 1;
		// 0 and 1
		System.out.print(a + ", " + b);
		// while its under 14 times 
		while (count <= 14) {
			a = b;
			b = sum;
			// the sum of all values
			sum = a + b;
			count++;
			System.out.print(", " + sum);

		}
		//finding the odd values
		int c = 0;
		int d = 1;
		int sumOdd = c + d;
		int countOdd = 1;
		System.out.print(" The odd values are: " + d + ", ");

		while (countOdd <= 14) {
			c = d;
			d = sumOdd;
			sumOdd = c + d;
			countOdd++;
			if (sumOdd % 2 == 1) {
				System.out.print(sumOdd + ", ");
			}
		}

	}

}
