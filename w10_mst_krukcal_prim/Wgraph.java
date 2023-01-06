package algo_10_20185249;

public class Wgraph {
	int n ;
	int e ;
	int [][] weight;
	
	public Wgraph(int noOfVertices) {
		n = noOfVertices;
		e = 0;
		weight = new int[n][n];
		for(int i = 0 ; i<n ; i++) {
			for(int j = 0 ; j< n ; j++) {
				if(i == j) weight[i][j] = 0;
				else weight[i][j] = 9999;
			}
		}
	}
	
	public Wgraph() {
		n = 0 ;
		e = 0 ; 
	}
	
	public void insertEdge(int i , int j , int w) {
		weight[i][j] = w;
		weight[j][i] = w;
		e++;
	}
	public void removeEdge(int i , int j) {
		weight[i][j] = 9999;
		weight[j][i] = 9999;
		e--;
	}
	
	public Edge[] kruskal() {
		
		Edge[] T = new Edge[n-1];
		int Tptr = -1;
		
		MinHeap edgeList = new MinHeap();
		UnionFind uf = new UnionFind(n);
		
		
		for(int i = 0 ; i< n ; i++) {
			
			for(int j = 0 ; j < n ; j++) {
				if(weight[i][j] != 9999 && weight[i][j] != 0) {
				Edge n = new Edge(i, j ,weight[i][j]);
					edgeList.insert(n);
				}
			}
		}
		
		
		while(Tptr < n-2 || edgeList.numberElements() >0 ) {
			
			Edge newEdge = (Edge)edgeList.delete();
			
			
			if(!( uf.find(newEdge.head,newEdge.tail) ) ) {
				Tptr++;
				T[Tptr] = newEdge;
				uf.union(newEdge.head , newEdge.tail);
			}
		}
		
		
		if( Tptr < n-2) {
			System.out.println("신장트리가 아닙니다.");
		}
		
		
		
		return T;
	}
	
	
	public Edge[] prim(int i) {
		Edge[] T = new Edge[n-1];
		int Tptr = -1;
		
		MinHeap edgeList = new MinHeap();
		UnionFind uf = new UnionFind(n);
		
	
		
		
		for(int j = 0 ; j < n ; j++) {
			if(weight[i][j] != 0 && weight[i][j] != 9999) {
				Edge n = new Edge(i, j ,weight[i][j]);
				edgeList.insert(n);
			}
		}
		
		while(Tptr < n-2) {
			
			Edge newEdge = (Edge)edgeList.delete();
			
			if( !( uf.find(newEdge.head , newEdge.tail) ) ){
				Tptr++;
				T[Tptr] = newEdge;
				uf.union(i , newEdge.tail);
				
				
				for(int j = 0 ; j< n ; j++) {
					if(weight[newEdge.tail][j] != 9999 && weight[newEdge.tail][j] != 0 ) {
						Edge n = new Edge(newEdge.tail, j ,weight[newEdge.tail][j]);
						edgeList.insert(n);
					}
				}
			}
		}
		return T;
	}
}


