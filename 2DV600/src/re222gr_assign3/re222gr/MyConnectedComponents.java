/**
 * 
 */
package re222gr_assign3.re222gr;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import re222gr_assign3.graphs.ConnectedComponents;
import re222gr_assign3.graphs.DirectedGraph;
import re222gr_assign3.graphs.Node;

/**
 * @author rjosi
 *
 */
public class MyConnectedComponents<E> implements ConnectedComponents<E> {
	MyDFS<E> dfs = new MyDFS<E>();
	List<Node<E>> newList = new LinkedList<Node<E>>();
	Collection<Collection<Node<E>>> newNodeCollection = new HashSet<>();
	private HashSet<Node<E>> nodeList = new HashSet<>();
	boolean connected;

	// returns all connected components for a dg graph
	@Override
	public Collection<Collection<Node<E>>> computeComponents(DirectedGraph<E> dg) {
		Iterator<Node<E>> dgIterator = dg.iterator(); 
		Collection<Collection<Node<E>>> nodeCollection = new HashSet<>();
		Collection<Node<E>> nodes; 
		
		while(dgIterator.hasNext()){
			connected = false; 
			Node<E> nextNode = dgIterator.next();
			
			if(nodeList.contains(nextNode) == false){ 
				
				// stackoverflow
				nodes =  dfs.dfs(dg, nextNode); 

				for(Node<E> node : nodes){
					
					if(nodeList.contains(node)){ 
						
						for(Collection<Node<E>> n : nodeCollection){
							
							if(n.contains(node)){ 
								connected = true; 
								nodeList.addAll(nodes);
								n.addAll(nodes);
							}
						}
					}	
				}
				
				// if the components are not connected
				if(connected == false){ 
					Collection<Node<E>> newNodeCollection = new HashSet<>();
					nodeList.addAll(nodes); 
					newNodeCollection.addAll(nodes); 
					nodeCollection.add(newNodeCollection); 
				}
			}
		}
		return nodeCollection; 
	}
}