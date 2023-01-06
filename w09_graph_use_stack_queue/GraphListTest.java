package algo_06_20185249;

class GraphListTest{
	public static void main(String args[]) { 
		GraphList gr = new GraphList(6);

		gr.insertEdge(5, 3);
		gr.insertEdge(5, 4);
		gr.insertEdge(5, 1);
		
		gr.insertEdge(4, 2);
		gr.insertEdge(4, 3);

		gr.insertEdge(3, 2);
		gr.insertEdge(3, 1);
		
		gr.insertEdge(2, 1);
		gr.insertEdge(2, 0);

		gr.insertEdge(1, 0);

//		gr.removeEdge(1, 0);
		System.out.println();
		
		int[] adj;
		for (int i = 0; i < 6; i++) {
			adj = gr.adjacency(i);
			System.out.print(i + ": ");
			for (int e : adj) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		gr.bfs(1);
		System.out.println();
		gr.dfs(1);
		
		System.out.println();
		System.out.println("==================================");
		
		
		
		gr = new GraphList(7);

		gr.insertEdge(6, 5);
		gr.insertEdge(6, 4);
		
		gr.insertEdge(5, 3);
		gr.insertEdge(5, 2);

		gr.insertEdge(4, 2);
		gr.insertEdge(4, 1);
		
		gr.insertEdge(3, 0);
		
		gr.insertEdge(2, 0);
		
		gr.insertEdge(1, 0);
		
		
		
		
		
		
		
		System.out.println();
		for (int i = 0; i < 7; i++) {
			adj = gr.adjacency(i);
			System.out.print(i + ": ");
			for (int e : adj) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
		
		gr.bfs(4);
		System.out.println();
		gr.dfs(4);
	}
}