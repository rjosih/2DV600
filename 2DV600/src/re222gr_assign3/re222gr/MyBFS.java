/**
 * 
 */
package re222gr_assign3.re222gr;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import re222gr_assign3.graphs.BFS;
import re222gr_assign3.graphs.DirectedGraph;
import re222gr_assign3.graphs.Node;

/**
 * @author rjosi
 *
 */
public class MyBFS<E> implements BFS<E> {
	List<Node<E>> nodeList = new ArrayList<Node<E>>();
	private int counter = 0;

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph, Node<E> root) {
		Set<Node<E>> setNode = new LinkedHashSet<Node<E>>();
		nodeList.clear();
		nodeList.add(root);
		setNode.add(root);
		bfs(setNode);
		
		return nodeList;
	}

	@Override
	public List<Node<E>> bfs(DirectedGraph<E> graph) {
		int counter = 0;
		Set<Node<E>> setNode = new LinkedHashSet<Node<E>>();
		Iterator<Node<E>> graphIterator = graph.iterator();

		nodeList.clear();

		
		while (graphIterator.hasNext()) {
			Node<E> node = graphIterator.next();
			// do bfs if node is head
			if (node.isHead()) {
				setNode.add(node);
				counter++;
				
				if (counter> 1) {
					nodeList.add(node);
				}
				// bfs 
				bfs(setNode);
				
				if (counter> 0 && counter <= 1) {
					nodeList.add(node);
				}
			}
		}
		// list of visited nodes
		return nodeList;
	}

	private void bfs(Set<Node<E>> node) {
		//github
		if (node.size() > 0) {
			Iterator<Node<E>> nIterator = node.iterator();
			Set<Node<E>> sNode = new LinkedHashSet<Node<E>>();

			while (nIterator.hasNext()) {
				Node<E> next = nIterator.next();
				next.num = counter++;
				Iterator<Node<E>> nodeIterator = next.succsOf();

				while (nodeIterator.hasNext()) {
					Node<E> nextNode = nodeIterator.next();

					if (nodeList.contains(nextNode) == false) {
						nodeList.add(nextNode);
						sNode.add(nextNode);
					}
				}
			}
			bfs(sNode);
		}
	}
}