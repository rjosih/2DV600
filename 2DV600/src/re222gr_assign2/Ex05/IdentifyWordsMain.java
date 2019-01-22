/**
 * 
 */
package re222gr_assign2.Ex05;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.Scanner;


/**
 * @author rjosi
 *
 */
public class IdentifyWordsMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
		 try {
			 // scans the file
	            Scanner input = new Scanner(System.in);
	            File file = new File("TextfileWithText.txt");
	            input = new Scanner(file);
	            
	            while (input.hasNextLine()) {
	                String line = input.nextLine();
	                
	                // gets the text
	                byte[] text = line.getBytes();
	                
	                // creates a new file
	                RandomAccessFile createFile = new RandomAccessFile("WordsOnly.txt", "rw");
	                String newText = new String(text);
	                
	                // filters out chosen characters
	                String filteredText = newText.replaceAll("[^a-zA-Z ]", "");
	                byte[] printText = filteredText.getBytes();
	                
	                // visual presentation of the changes
	                System.out.println("Before: " + newText);
	                System.out.println("After: " + filteredText);
	                
	                // writes the text in the new file
	                createFile.write(printText);        
	            }

	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	    }

	}