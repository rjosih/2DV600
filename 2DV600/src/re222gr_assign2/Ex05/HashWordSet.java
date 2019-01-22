/**
 * 
 */
package re222gr_assign2.Ex05;

import java.util.Iterator;



/**
 * @author rjosi
 *
 */

	/**
	 * @param args
	 */
	public class HashWordSet implements WordSet {
		private int size = 0;
		private Node[] collection = new Node[2];

	@Override
	public Iterator<Word> iterator() {
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Word>{
        private Node node;
		int count = 0;
		private Node[] collection = new Node[10];
		
		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Word next() {
			if(collection.length > count) {
				count++;
				node = collection[count];
				while(node == null && collection.length > count) {
					count++;
				}
			}else {
				node = null;
			}
			return node.element;
		}
		
	}

	public void add(Word word) {
        if(!contains(word)) {
            int position = getPosition(word);
            Node node = new Node(word);
            node.next = collection[position];
            collection[position] = node;
            size++;
        }
    }

	private int getPosition(Word word) {
		int hashedFirst = word.hashCode(); 
		if(0 > word.hashCode()) {
			hashedFirst =  - (word.hashCode());
		}
		int hashed;
		hashed = hashedFirst % collection.length;
		return (int) hashed;
	}

	@Override
	public boolean contains(Word word) {
		int position = getPosition(word);
		
		//Create a node from the position obtained
		Node node = collection[position];
		
		//Loop from position obtained until the end of bucket 
		while(node != null) {
			if(node.element.equals(word)) {
				return true; //The word was found
			}
			else {
				//Continue to the next node
				node = node.next;
			}
		}
		//The word was not found
		return false;
	}
	@Override
	public int size() {
		return this.size;
	}
	
	
	public class Node { 
		Word element;
		public Node next = null;
		
		public Node(Word element){
			this.element = element; 
		}
		public String toString (){
			return element.toString();
		}
	}

}
