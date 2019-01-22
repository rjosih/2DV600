/**
 * 
 */
package re222gr_assign2.Ex05;

/**
 * @author rjosi
 *
 */
public class Word implements Comparable<Word> {
	private String word;

	public Word(String str) {
		word = str;
	}

	public String toString() {
		return word;
	}

	/* Override Object methods */
	public int hashCode() {
		return this.word.hashCode();
	}

	public boolean equals(Object other) {
		if (other instanceof Word) {
			String newOther = other.toString().toLowerCase();
			String newWord = word.toLowerCase();
			return newOther.equals(newWord);
		} else {
			return false;
		}
	}

	/* Implement Comparable */
	public int compareTo(Word w) { 
		return word.compareToIgnoreCase(w.word);
		 }


}