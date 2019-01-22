/**
 * 
 */
package re222gr_assign1;

import java.util.Scanner;

/**
 * @author rjosi
 *
 */
public class TextProcessor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// replace letters structure
		char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] enc = "bcdEfghIjklmnOpqrstUvwxYzA".toCharArray();

		//entering text 
		System.out.println("Enter your text: ");
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		System.out.println("Your input is:  " + text);
		
		// makes all letter to small letters
		text = text.toLowerCase();
		System.out.print("The output is: ");
		
		//loops through the string and checks for letters and replace 
		for (int i = 0; i < text.length(); i++) {
			char temp = text.charAt(i);
			boolean letter = Character.isLetter(temp);
			if (letter) {
				int tempNums = (new String(letters).indexOf(temp)); 
				// prints out the new string
				System.out.print(new String(enc).charAt(tempNums));
			} else {
				System.out.print(temp);
			}
			// closes scanner
			scanner.close();
		}

	}
}
