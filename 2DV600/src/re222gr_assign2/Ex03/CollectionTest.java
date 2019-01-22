/**
 * 
 */
package re222gr_assign2.Ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import re222gr_assign2.Ex01.ArrayIntList;
import re222gr_assign2.Ex01.ArrayIntStack;

/**
 * @author rjosi
 *
 */
class CollectionTest {

	// ArrayIntStack, push
	@Test
	public void push() {
		// creating an ArrayIntStack
		ArrayIntStack ArrayIntStack = new ArrayIntStack();
		// should be empty
		assertTrue(ArrayIntStack.isEmpty());
		// push integer to ArrayIntStack
		ArrayIntStack.push(1);
		// ArrayIntStack should empty 
		assertFalse(ArrayIntStack.isEmpty());
		// if 1 is equal to the size of the stack
		assertEquals(1, ArrayIntStack.size());
	}

	// ArrayIntStack, pop
	@Test
	public void pop() {
		// creating an ArrayIntStack
		ArrayIntStack ArrayIntStack = new ArrayIntStack(); 
		// should be empty
		assertTrue(ArrayIntStack.isEmpty()); 
		// if ArrayIntStack is empty, it's throw an exception
		assertThrows(IndexOutOfBoundsException.class,
	            ()->{
	            	ArrayIntStack.pop();
	            });
		// push integers to ArrayIntStack
		ArrayIntStack.push(3);
		ArrayIntStack.push(2);
		// ArrayIntStack should empty 
		assertFalse(ArrayIntStack.isEmpty()); 
		// pops the ArrayIntStack
		assertEquals(2, ArrayIntStack.pop());
		// since pop remove the top index and returns the rest
		assertEquals(1, ArrayIntStack.size()); 
	}
	
	// ArrayIntStack, peek
	@Test
	public void peek() {
		// creating an ArrayIntStack
		ArrayIntStack ArrayIntStack = new ArrayIntStack(); 
		// should be empty
		assertTrue(ArrayIntStack.isEmpty()); 
		// if ArrayIntStack is empty, it's throw an exception
		assertThrows(IndexOutOfBoundsException.class,
	            ()->{
	            	ArrayIntStack.peek();
	            });
		// push integers to ArrayIntStack
		ArrayIntStack.push(3);
		ArrayIntStack.push(2);
		// the pushed integers equals two 
		assertEquals(2, ArrayIntStack.size()); 
		// ArrayIntStack should empty 
		assertFalse(ArrayIntStack.isEmpty()); 
		// since peek is returns the top element = 2
		assertEquals(2, ArrayIntStack.peek()); 
	}
	
	//ArrayIntList, add
	@Test
	public void add() {
		// creating an ArrayIntList
		ArrayIntList ArrayIntList = new ArrayIntList(); 
		// should be empty
		assertTrue(ArrayIntList.isEmpty()); 
		// push integers to ArrayIntList
		ArrayIntList.add(1);
		ArrayIntList.add(2);
		// should not be empty
		assertFalse(ArrayIntList.isEmpty());
		// if 2 is equal to the size of ArrayIntStack
		assertEquals(2, ArrayIntList.size());
	}
	
	//ArrayIntList, addAt
	@Test
	public void addAt() {
		// creating an ArrayIntList
		ArrayIntList ArrayIntList = new ArrayIntList(); 
		// should be empty
		assertTrue(ArrayIntList.isEmpty());
		// throw exception when it trying to add on an index when the list is empty
		assertThrows(IndexOutOfBoundsException.class,
	            ()->{
	            	ArrayIntList.addAt(3, 10);
	            });
		// push integers to ArrayIntList
		ArrayIntList.add(1);
		ArrayIntList.add(2);
		ArrayIntList.addAt(3, 0);
		// should not be empty
		assertFalse(ArrayIntList.isEmpty());
		// if 3 is equal to the size of ArrayIntStack
		assertEquals(3, ArrayIntList.size());
	}
	
	//ArrayIntList, remove
	@Test
	public void remove() {
		// creating an ArrayIntList
		ArrayIntList ArrayIntList = new ArrayIntList(); 
		// should be empty
		assertTrue(ArrayIntList.isEmpty()); 
		// push integers to ArrayIntList
		ArrayIntList.add(3);
		ArrayIntList.add(1);
		ArrayIntList.add(4);
		ArrayIntList.add(2);
		// should not be empty
		assertFalse(ArrayIntList.isEmpty());
		// if 2 is equal to the size of ArrayIntStack
		assertEquals(4, ArrayIntList.size());
		// removes the integer at index 1
		ArrayIntList.remove(1);
		// size(4) -1 = 3
		assertEquals(3, ArrayIntList.size());
	}
	
	//ArrayIntList, get
	@Test
	public void get() {
		// creating an ArrayIntList
		ArrayIntList ArrayIntList = new ArrayIntList(); 
		// should be empty
		assertTrue(ArrayIntList.isEmpty()); 
		// throw exception when it trying to add on an index when the list is empty
		assertThrows(IndexOutOfBoundsException.class,
	            ()->{
	            	ArrayIntList.get(10);
	            });
		// push integers to ArrayIntList
		ArrayIntList.add(3); // index 0 
		ArrayIntList.add(1); // index 1
		ArrayIntList.add(4); // index 2
		ArrayIntList.add(2); // index 3
		// integer 2 on index 3
		assertEquals(2, ArrayIntList.get(3));
		// should not be empty
		assertFalse(ArrayIntList.isEmpty());
		// if 2 is equal to the size of ArrayIntStack
		assertEquals(4, ArrayIntList.size());
	
	}
}
