/**
 * 
 */
package re222gr_assign3.re222gr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import re222gr_assign3.graphs.DFS;
import re222gr_assign3.graphs.DirectedGraph;
import re222gr_assign3.graphs.Node;

/**
 * @author rjosi
 *
 */
public class MyDFS<E> implements DFS<E> {
	private List<Node<E>> nodeList = new LinkedList<Node<E>>();
	private List<Node<E>> postOrderList = new LinkedList<Node<E>>();
	private List<Node<E>> currentList = new LinkedList<Node<E>>();
	private List<Node<E>> postOrder = new LinkedList<Node<E>>();

	private int depthCount = 0;
	private int postNumber = 0;

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph, Node<E> root) {
		// use graph?
		List<Node<E>> list;
		nodeList.clear();
		list = dfs(root);
		return list;
	}

	private List<Node<E>> dfs(Node<E> root) {
		Iterator<Node<E>> rootIterator = root.succsOf();
		
		// add root to the nodeList
		nodeList.add(root);
		// increases depthCount
		//geeksforgeeks
		root.num = depthCount++;

		while (rootIterator.hasNext()) {
			Node<E> node = rootIterator.next();
			
			if (nodeList.contains(node) == false) {
				dfs(node);
			}
		}
		return nodeList;
	}

	@Override
	public List<Node<E>> dfs(DirectedGraph<E> graph) {
		Iterator<Node<E>> graphIterator = graph.iterator();

		while (graphIterator.hasNext()) {
			Node<E> nextNode = graphIterator.next();
			// root can be a head and a tail at the same time
			if (nextNode.isHead()) {
				nodeList = dfs(nextNode);
			}
		}
		return nodeList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, Node<E> root) {
		nodeList.clear();
		postOrder.clear();
		List<Node<E>> pOrder = postOrder(root, postOrder);
		return pOrder;
	}

	private List<Node<E>> postOrder(Node<E> root, List<Node<E>> postOrder2) {
		Iterator<Node<E>> succIterator = root.succsOf();

		nodeList.add(root);

		while (succIterator.hasNext()) {
			Node<E> nextNode = succIterator.next();

			if (nodeList.contains(nextNode) == false) {
				postOrder(nextNode, postOrder2);
			}
		}
		root.num = depthCount++;
		postOrder.add(root);

		return postOrder;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g) {
		Iterator<Node<E>> graphIterator = g.iterator();

		while (graphIterator.hasNext()) {
			Node<E> nextNode = graphIterator.next();
			// a node can be a head and a tail at the same time
			if (nextNode.isHead()) {
				// puts the list in postOrder
				postOrderList = postOrder(nextNode, postOrder);
			}
		}
		return postOrderList;
	}

	@Override
	public List<Node<E>> postOrder(DirectedGraph<E> g, boolean attach_dfs_number) {
		Iterator<Node<E>> nodeIterator = g.iterator();

		while (nodeIterator.hasNext()) {
			Node<E> nextNode = nodeIterator.next();
			// a node can be a head and a tail at the same time
			if (nextNode.isHead()) {	
				postOrderList = postOrder(nextNode, postOrder);
			}
			// increases postNumber
			postNumber++;
		}
		return postOrderList;
	}

	@Override
	public boolean isCyclic(DirectedGraph<E> graph) {
		nodeList.clear();

		for (Node<E> node : graph) {
			// checks if its cyclic
			if (nodeList.contains(node)== false) {
				if (cyclicCheck(node)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean cyclicCheck(Node<E> node) {
		Iterator<Node<E>> succIterator = node.succsOf();
		List<Node<E>> tempList = new LinkedList<Node<E>>();

		currentList.add(node);
		
		while (succIterator.hasNext()) {
			Node<E> tempNode = succIterator.next();
			// adds the next 
			tempList.add(tempNode);
		}

		for (Node<E> choosenNode : tempList) {
			nodeList.add(node);
			
			// checks if its cyclic
			if (currentList.contains(choosenNode) || nodeList.contains(choosenNode)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Node<E>> topSort(DirectedGraph<E> graph) {
		List<Node<E>> topoList = new LinkedList<Node<E>>();
		List<Node<E>> postOrderList = postOrder(graph);

		// if its acyclic, sort the list 
		if (isAcyclic(graph)) {
			for (int i = postOrderList.size() - 1; i >= 0; i--) {
				topoList.add(postOrderList.get(i));
			}
			return topoList;
		} else {
			throw new RuntimeException("ARE NOT ACYCLIC");
		}
	}

	// checks if its acyclic
	private boolean isAcyclic(DirectedGraph<E> graph) {
		if (isCyclic(graph) == false) {
			return true;
		} else {
			return false;
		}
	}
}