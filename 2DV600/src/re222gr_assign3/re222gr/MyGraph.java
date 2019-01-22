/**
 * 
 */
package re222gr_assign3.re222gr;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import re222gr_assign3.graphs.DirectedGraph;
import re222gr_assign3.graphs.Node;

/**
 * @author rjosi
 *
 */
public class MyGraph<E> implements DirectedGraph<E> {
	private Map<E, Node<E>> item2node;
	private Set<Node<E>> head;
	private Set<Node<E>> tail;
	
	// constructor
	public MyGraph() {
		item2node = new LinkedHashMap<>();
		head = new HashSet<>();
		tail = new HashSet<>();
	}

	@Override
	public Node<E> addNodeFor(E item) {
		Node<E> newNode = item2node.get(item);

		if (item == null) {
			throw new NullPointerException("Recieved null as input");
		}
		
		if (newNode == null) {
			newNode = new MyNode<E>(item);
			tail.add(newNode);
			head.add(newNode);
			item2node.put(item, newNode);
			return newNode;		
		}
		return newNode;
	}

	@Override
	public Node<E> getNodeFor(E item) {
		Node<E> getNode = item2node.get(item);
		
		if(item == null || getNode == null){
			throw new RuntimeException("Recieved null as input");
		}
		return getNode;
	}

	
	// from lecture
	@Override
	public boolean addEdgeFor(E from, E to) {
		// defining nodes
		MyNode<E> src = (MyNode<E>) addNodeFor(from);
		MyNode<E> tgt = (MyNode<E>) addNodeFor(to);
		
		if (from == null || to == null) {
			throw new RuntimeException("Received null as input!");
		}

		// edge not added
		if (src.hasSucc(tgt) == false) {
//			edgeCount++;
			src.addSucc(tgt);
			tgt.addPred(src);
			
			tail.remove(src);
			head.remove(tgt);
			return true;
		} else {
			// edge already added
			return false;
		}
	}

	@Override
	public boolean containsNodeFor(E item) {
		Node<E> getItem = item2node.get(item);
		boolean node = getItem != null;
		
		if (item == null) {
			throw new RuntimeException("Received null as input!");
		} 
		return node;
	}

	@Override
	public int nodeCount() {
		return item2node.size();
	}

	@Override
	public Iterator<Node<E>> iterator() {
		return item2node.values().iterator();
	}

	@Override
	public Iterator<Node<E>> heads() {
		return head.iterator();
	}

	@Override
	public int headCount() {
		return head.size();
	}

	@Override
	public Iterator<Node<E>> tails() {
		return tail.iterator();
	}

	@Override
	public int tailCount() {
		return tail.size();
	}

	@Override
	public List<E> allItems() {
		LinkedList<E> itemList = new LinkedList<E>(item2node.keySet());
		return itemList;
	}

	@Override
	public int edgeCount() {
		int edgeCount = 0;
		for (Node<E> nodeValues : item2node.values()) {
			edgeCount = edgeCount + nodeValues.outDegree();
		}
		return edgeCount;
	}

	@Override
	public void removeNodeFor(E item) {
		MyNode<E> getItem = (MyNode<E>) item2node.get(item);
		
		if (item == null || (MyNode<E>) item2node.get(item) == null) {
			throw new RuntimeException("Recieved null as input");
		}
		
		// remove getItem if its the head-element
		if(getItem.isHead()){
			head.remove(getItem);
		}
		
		// remove getItem if its the tail-element
		if(getItem.isTail()){
			head.remove(getItem);
		}
		
		// iterates nodes for head
		for (Iterator<Node<E>> succIterator = getItem.succsOf(); succIterator.hasNext();) {
			MyNode<E> succ = (MyNode<E>) succIterator.next();
			succ.removePred(getItem);
			succIterator.remove();
		}
				
		// iterates nodes for tail
		for (Iterator<Node<E>> predIterator = getItem.predsOf();predIterator.hasNext();) {
			MyNode<E> pred = (MyNode<E>) predIterator.next();
			pred.removeSucc(getItem);
			predIterator.remove();
		}
		//disconnects the specific node
		getItem.disconnect();
		head.remove((MyNode<E>) item2node.get(item));
		tail.remove((MyNode<E>) item2node.get(item));
		item2node.remove(item);
	}

	@Override
	public boolean containsEdgeFor(E from, E to) {
		Node<E> nodeFrom = item2node.get(from);
		Node<E> nodeTo = item2node.get(to);
		boolean containEdge = nodeFrom != null && nodeTo != null && nodeFrom.hasSucc(nodeTo);
		
		if (from == null || to == null) {
			throw new RuntimeException("Recieved null as input");
		}
		// if an edge between the nodes represented by from and to is found and successfully removed
		return containEdge;
	}

	// Returns true if an edge between the nodes represented by from and to is found
	// and successfully removed.
	@Override
	public boolean removeEdgeFor(E from, E to) {
		MyNode<E> nodeFrom = (MyNode<E>) item2node.get(from);
		MyNode<E> nodeTo = (MyNode<E>) item2node.get(to);
		boolean edgeFromTo = containsEdgeFor(from, to);

		if (from == null || to == null) {
			throw new RuntimeException("Received null as input!");
		}

		if (edgeFromTo) {
//			edgeCount--;
			// removes from and to
			nodeFrom.removeSucc(nodeTo);
			nodeTo.removePred(nodeFrom);

			// adds nodeTo to heads
			if (nodeTo.isHead()) {
				head.add(nodeTo);
			}
			
			// adds nodeFrom to tails
			if (nodeFrom.isTail()) {
				tail.add(nodeFrom);
			}
			return true;
		} else {
			return false;
		}
	}
}
