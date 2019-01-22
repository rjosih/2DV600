/**
 * 
 */
package re222gr_assign2.Ex05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author rjosi
 *
 */
public class WordCount2Main {

	/**
	 * @param args
	 */
	public static void main(String[] file) {
		// creating hashWordSet, treeWordSet and list
		HashWordSet hashWordSet = new HashWordSet();
		TreeWordSet treeWordSet = new TreeWordSet();
		List<String> list = new ArrayList<String>();
		
		file = new String[] { "HistoryOfProgramming.txt" };
		
		// controlling that the file exists
		if (file[0] != null) {
			list = toWords(file[0]);
			// looping through wordsList and add the words in hash and tree
			for (int i = 0; i < list.size(); i++) {
				Word wordFromList = new Word(list.get(i));
				hashWordSet.add(wordFromList);
				treeWordSet.add(wordFromList);
			}
		} else {
			try {
				throw new Exception("THE FILE COULDn'T BE FIND");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// iterates over the words
		Iterator<Word> wordsIterator = treeWordSet.iterator();
		int count = 0;
		while (wordsIterator.hasNext()) {
			count++;
			Word word = wordsIterator.next();
			// prints words alphabetic
			System.out.println(count + ": " + word);
		}
		// presenting the results
		System.out.println("Tree: " + treeWordSet.size());
		System.out.println("Hash: " + hashWordSet.size());

	}


	private static List<String> toWords(String chosenFile) {
		BufferedReader bufferedRe = null;
		StringBuilder stringBuilder = null;
		FileReader fileRe = null;
		List<String> list = new ArrayList<String>();
		String readLine = null;
		
		// reads from the text file
		try {
			fileRe =  new FileReader(chosenFile);
			bufferedRe = new BufferedReader(fileRe);
			stringBuilder = new StringBuilder();
			try {
				readLine = bufferedRe.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// if readLine exists, append it to stringBuilder 
		while (readLine != null) {
			stringBuilder.append(readLine);
			try {
				readLine = bufferedRe.readLine();
				// only words are approved to the list
				String[] wordsOnly = stringBuilder.toString().split("([^A-z']+)'*\\1*");
				// approved words are added to wordsList
				for (int i = 0; i < wordsOnly.length; i++) {			
					list.add(wordsOnly[i]);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// return the approved words 
		return list;
	}
}
