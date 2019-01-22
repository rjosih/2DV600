/**
 * 
 */
package re222gr_assign1;

/**
 * @author rjosi
 *
 */
public class Multiples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sum = 0;
		// calculating all numbers of 3 and 7 below 100 and prints it
		System.out.println("Multiples of 3 and 7 below 100 are: ");
		for (int i = 0; i < 101; i++) {
			if (i % 3 == 0 || i % 7 == 0) {
				sum += i;
				System.out.println(i + " ");
			}
		}
		// prints out the total sum of the values
		System.out.print("Sum of the above displayed multiples: " + sum);

	}

}
