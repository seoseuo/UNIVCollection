package algo_12_20185249;

import java.util.*;


public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(6);
		
		g.insertEdge(0, 1);
		g.insertEdge(0, 2);
		g.insertEdge(1, 3);
		g.insertEdge(1, 4);
		g.insertEdge(2, 3);
		g.insertEdge(2, 4);
		g.insertEdge(3, 5);
		g.insertEdge(4, 5);
		
		g.topologicalSort();
		
	}
}
