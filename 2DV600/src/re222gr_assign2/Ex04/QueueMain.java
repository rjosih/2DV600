/**
 * 
 */
package re222gr_assign2.Ex04;

import java.util.Iterator;

/**
 * @author rjosi
 * @param <E>
 *
 */
public class QueueMain<E> implements Queue<E> {
	private int size = 0;
	// top element
	private Node head = null;
// last element
	private Node tail = null;

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();	
	}
	
    private class ListIterator implements Iterator<E> {
        private Node node = head;

        public E next() {
            Node value = node;
            node = node.getNext();
            return value.node;
        }

        public boolean hasNext() {
            return node != null;
        }
    }

	// current queue size
	@Override
	public int size() {
		int currentSize = this.size;
		return currentSize;
	}

	// true if queue is empty
	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	// add element at end of queue
	@Override
	public void enqueue(E element) {
		Node node = new Node(element);
		if(this.size() != 0) {
			this.tail.setNextNode(node);
			this.tail = node;
			// if the queue is empty
		}else {
			this.head = node;
			this.tail = node;
		}
		this.size++;

	}

	// return and remove first element.
	@Override
	public E dequeue() {
		if(this.size() == 0) {
			throw new IndexOutOfBoundsException("List is empty!!!!!!!!!!!");
		}else {
			Node removeFirstElement = head;
			head = removeFirstElement.getNext();
			size--;
			return removeFirstElement.getElement();
		}
	}

	// return (without removing) first element
	@Override
	public E first() {
		if(this.size() == 0) {
			throw new IndexOutOfBoundsException("List is empty!!!!!!!!!!!");
			}else {
				return this.head.getElement();
			}
	}

	// return (without removing) last element
	@Override
	public E last() {
		if(this.size() == 0) {
			throw new IndexOutOfBoundsException("List is empty!!!!!!!!!!!");
			}else {
				return this.tail.getElement();
			}
	}
	
	public class Node{
		public E node;
		private E value;
		private Node temp = null;
		

		public Node(E value) {
			this.value = value;
		}


		public Node getNext() {
			return this.temp;
		}


		public E getElement() {
			return value;
		}


		public void setNextNode(Node node) {
			temp = node;
			
		}
	}

}
