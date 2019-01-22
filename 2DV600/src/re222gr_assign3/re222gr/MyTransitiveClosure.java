/**
 * 
 */
package re222gr_assign3.re222gr;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import re222gr_assign3.graphs.DirectedGraph;
import re222gr_assign3.graphs.Node;
import re222gr_assign3.graphs.TransitiveClosure;

/**
 * @author rjosi
 *
 */
public class MyTransitiveClosure<E> implements TransitiveClosure<E>  {
	Map<Node<E>, Collection<Node<E>>> tcGraph = new LinkedHashMap<Node<E>, Collection<Node<E>>>();
    private Set<Node<E>> visited  = new HashSet<Node<E>>();
    private Set<Node<E>> connection  = new HashSet<Node<E>>();
    
	@Override
	public Map<Node<E>, Collection<Node<E>>> computeClosure(DirectedGraph<E> dg) {
//		Iterator<Node<E>> iterator = dg.iterator();
//		MyDFS<E> dfs = new MyDFS<E>();	
		restore();		
		//Computes the transitive closure for the graph
		for (Node<E> node : dg) {
			visited = new HashSet<Node<E>>();
			compute(node);
			tcGraph.put(node, visited);
		}
		return tcGraph;
	}

	private void compute(Node<E> node) {
        visited.add(node);
        Iterator<Node<E>>  succIterator = node.succsOf();	
        
        while (succIterator.hasNext()) {
			Node<E> n = succIterator.next();
			if (visited.contains(n) == false) {
				compute(n);
			}
		}        
	}

	private void restore() {
		visited.clear();
		connection.clear();
	}
}