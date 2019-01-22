package re222gr_assign2.Ex04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {
	@Test
	public void testIntSize() {
		Queue<Integer> QueueList = new QueueMain<>();
		assertEquals(0, QueueList.size());
	}
	
	@Test
	public void testIsEmpty() {
		Queue<Integer> QueueList = new QueueMain<>();
		assertTrue(QueueList.isEmpty());
	}
	
	@Test
	public void testEnqueue() {
		Queue<Integer> QueueList = new QueueMain<>();
		// add 1 to MainQueue
		QueueList.enqueue(1);
		assertEquals(1, QueueList.size());		
	}
	
	@Test
	public void testDequeue() {
		Queue<Integer> QueueList = new QueueMain<>();
		QueueList.enqueue(1);
		QueueList.enqueue(2);
		QueueList.enqueue(3);
		// takes away the first element = 1 
		assertEquals(1, (int)QueueList.dequeue());
		// 2 in the QueueMain after dequeue
		assertEquals(2, QueueList.size());		
	}
	
	@Test
	public void testFirstElment() {
		Queue<Integer> QueueList = new QueueMain<>();
		// first
		QueueList.enqueue(1);
		QueueList.enqueue(2);
		// last
		QueueList.enqueue(3); 
		System.out.print("First: " + QueueList.first());
	}
	
	@Test
	public void testLastElment() {
		Queue<Integer> QueueList = new QueueMain<>();
		// first 
		QueueList.enqueue(1); 
		QueueList.enqueue(2);
		// last
		QueueList.enqueue(3); 
		System.out.print("\nLast: " + QueueList.last());
	}
	

}
