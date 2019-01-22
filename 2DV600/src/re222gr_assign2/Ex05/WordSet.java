/**
 * 
 */
package re222gr_assign2.Ex05;

/**
 * @author rjosi
 *
 */
public interface WordSet extends Iterable<Word> {
	 public void add(Word word);
	 public boolean contains(Word word); // Return true if word contained
	 public int size(); // Return current set size
	 public String toString(); // Print contained words
	}
