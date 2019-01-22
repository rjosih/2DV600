/**
 * 
 */
package re222gr_assign2.Ex05;

import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author rjosi
 *
 */
public class WordCount1Main {

	public static void main(String[] file) throws FileNotFoundException {
		// creating hashSet, treeSet and a listString
		TreeSet<Word> tree = new TreeSet<>();
		HashSet<Word> hash = new HashSet<>();
		List<String> list = new ArrayList<String>();

		// which file
		file = new String[] { "HistoryOfProgramming.txt" };

		// controlling that the file exists
		if (file[0] != null) {
			list = toWords(file[0]);
			// looping through wordsList and add the words in hash and tree
			for (int i = 0; i < list.size(); i++) {
				Word wordFromList = new Word(list.get(i));
				hash.add(wordFromList);
				tree.add(wordFromList);
			}
		} else {
			try {
				throw new Exception("THE FILE COULDn'T BE FIND");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// iterates over the words
		Iterator<Word> wordsIterator = tree.iterator();
		int count = 0;
		
		while (wordsIterator.hasNext()) {
			count++;
			Word word = wordsIterator.next();
			// prints words alphabetic
			System.out.println(count + ": " + word);
		}
		// presenting the results
		System.out.println("Tree: " + tree.size());
		System.out.println("Hash: " + hash.size());
	}

	public static List<String> toWords(String chosenFile) {
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
				String[] wordsOnly = stringBuilder.toString().split("([^A-z']+)'*\\2*");
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