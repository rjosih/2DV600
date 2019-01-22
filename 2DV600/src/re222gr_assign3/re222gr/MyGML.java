/**
 * 
 */
package re222gr_assign3.re222gr;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import re222gr_assign3.graphs.DirectedGraph;
import re222gr_assign3.graphs.GML;
import re222gr_assign3.graphs.Node;

/**
 * @author rjosi
 *
 */
public class MyGML<T> extends GML<Integer> {
	Map<Node<T>,Integer> hashMap = new HashMap<>(); 

	public MyGML(DirectedGraph<Integer> dg) {
		super(dg);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see re222gr_assign3.graphs.GML#toGML()
	 */
	
	@Override
	public String toGML() {
		String gmlPresentation = "";
		int idNode = 0;
		int idEdge = 0;
		int nodeSize = graph.allItems().size();
		
		gmlPresentation = gmlPresentation + "graph [";
		
		// nodes
		for(int i = 0; i < nodeSize; i++) {
			Node<Integer> getNode = graph.getNodeFor(i);	
			idNode++;
			gmlPresentation = gmlPresentation 
					+ "\n \t node \n \t [ \n"
					+ "\t \t id " + idNode + "\n"
					+ "\t \t label " + "'node " + getNode + "' \n"
					+ "\n \t ]";
		}
		
		// edges
		for(int i = 0; i < nodeSize; i++) {
			Node<Integer> node = graph.getNodeFor(i);
			Iterator<Node<Integer>> succIterator = node.succsOf();
			Iterator<Node<Integer>> predIterator = node.predsOf();
			idEdge++;
			
			// edges for head
			while(succIterator.hasNext()){
				Node<Integer> target = succIterator.next();
				gmlPresentation = gmlPresentation
					+ "\n \t edge \n \t [ \n"
					+ "\t \t source " + idEdge + "\n"
					+ "\t \t target " + target + "\n"
					+ "\t \t label 'Edge from node " + node.item() + " to node " + target.item() + "\n" 
					+ "\n \t]";
			}	
			
			// edges for tail
			while(predIterator.hasNext()){
				Node<Integer> target = predIterator.next();
				gmlPresentation = gmlPresentation
					+ "\n \t edge \n \t [ \n"
					+ "\t \t source " + idEdge + "\n"
					+ "\t \t target " + target + "\n"
					+ "\t \t label 'Edge from node " + node.item() + " to node " + target.item() + "\n" 
					+ "\n \t]";
			}
		}
		gmlPresentation = gmlPresentation + "\n ]";
		
		System.out.println(gmlPresentation);
		return gmlPresentation;
	}

}