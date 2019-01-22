/**
 * 
 */
package re222gr_assign2.Ex05;

import java.util.Iterator;

/**
 * @author rjosi
 *
 */
public class TreeWordSet implements WordSet {
	private int size = 0;
	Node root = null;

	@Override
	
	public Iterator<Word> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Word>{
        private Node node;
		private Node next;
		Node left;
		Node right;
		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Word next() {
			if(hasNext()) {
				node = next;
				// test if we can go right 
				if(right != null) {
					next = next.right;
					// go back to the left side again 
					while(right != null && left != null) {
						next = next.left;
					}
					return node.word;
				}
			}else {
				while(next.parent != null) {
					next = null;
					return node.word;				
				}
			}	
			return null;
		}
	}
	
	@Override
	public void add(Word word) {
		if (root != null) {
			root.add(word);
		} else {
			root = new Node(word);
		}
		this.size++;
	}

	@Override
	public boolean contains(Word word) {
		if (root != null) {
			root.contains(word);
		} else {
			return false;
		}
		return false;
	}

	@Override
	public int size() {
		return this.size;
	}

	public String toString() {
		String tree = "";
		Iterator<Word> treeIterator = iterator();
		while (treeIterator.hasNext()) {
			tree = tree + treeIterator.next();
		}
		return tree;
	}

	// how Node is defined and how it works internally 
	public class Node {
		public Object parent;
		public Word word;

		Node left;
		Node right;

		public Node(Word word) {
			this.word= word;
		}

		public boolean contains(Word word) {
			// if this is true, start at left
			if (word.compareTo(this.word) < 0) {
				if (left != null) {
					return left.contains(word);
				} else {
					return false;
				}
				// go to the right in the binary search tree
			} else {
				if (right != null) {
					return right.contains(word);
				} else {
					return false;
				}
			}
		}

		public void add(Word word) {
			// if this is true, start at left
			if (word.compareTo(this.word) < 0) {
				if (left != null) {
					left.add(word);
				} else {
					left = new Node(word);
				}
				// starts at right
			} else {
				if (right != null) {
					right.add(word);
				} else {
					right = new Node(word);
				}

			}

		}

	}
}
