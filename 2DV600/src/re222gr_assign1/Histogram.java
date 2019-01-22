/**
 * 
 */
package re222gr_assign1;

import java.io.File;
import java.util.Scanner;

/**
 * @author rjosi
 *
 */
public class Histogram {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = readFile("Data.txt");
		System.out.println("Reading integers from the file Data.txt.");
		printHistogram(data);
	}
	//reads from file 
	private static int[] readFile(String file) {
		try {
			File f = new File(file);
			Scanner scanner = new Scanner(f);
			int ctr = 0;

			while (scanner.hasNextInt()) {
				ctr++;
				scanner.nextInt();
			}
			int[] array = new int[ctr];
			Scanner scanner2 = new Scanner(f);

			for (int i = 0; i < array.length; i++)
				array[i] = scanner2.nextInt();
			scanner2.close();
			scanner.close();
			return array;
		} catch (Exception e) {
			System.out.println("Couldn't find file");
			return null;
		}
	}
	
	public static void printHistogram(int[] array) {
		// calculate all the values under 1000 and prints it out
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= 1000) {
				System.out.print("* ");
				count++;
			}
		}
		System.out.println("1-1000 ");
		// calculates all numbers over 1000
		int numbersOver1000 = array.length - count;
		// prints out the numbers
		for (int i = 0; i < numbersOver1000; i++) {
			System.out.print("* ");
		}
		System.out.print("1000 < x ");
		// prints out the sum of evetything
		System.out.println(System.lineSeparator() + "Number of integers in the interval [1, 1000]: " + count);
		System.out.println("Number of integers beyond the interval [1, 1000]: " + numbersOver1000);

	}

}
