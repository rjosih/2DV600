/**
 * 
 */
package re222gr_assign1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author rjosi
 *
 */
public class AgeDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		for (;;) {
			System.out.println("Enter person A's birthday (YYYY-MM-DD): ");
			Scanner scanner = new Scanner(System.in);
			String agePersonA = scanner.next();

			System.out.println("Enter person B's birthday (YYYY-MM-DD): ");
			String agePersonB = scanner.next();

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date uagePersonA = sdf.parse(agePersonA);
				Date uagePersonB = sdf.parse(agePersonB);
				
				//calculate person a's birth
				long msA = System.currentTimeMillis() - uagePersonA.getTime();
				long ageA = (long) ((long) msA / (1000.0 * 60 * 60 * 24));
				//calculate person b's birth
				long msB = System.currentTimeMillis() - uagePersonB.getTime();
				long ageB = (long) ((long) msB / (1000.0 * 60 * 60 * 24));
				
				//calculate the difference
				long diff = Math.abs(ageA - ageB);

				System.out.println("The difference between person A and B is: " + diff + " days");
				System.exit(0);
				// wrong format
			} catch (ParseException e) {
				System.out.println("You need to write in the format YYYY-MM-DD, try again!");

			}
			//close scanner
			scanner.close();
		}

	}

}
