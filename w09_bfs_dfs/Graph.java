package algo_06_20185249;


public class Graph { //Matrix

    int n; //Number of vertices
    int e; // Number of edges
    int[][] weight;
    
    public Graph(int noOfVertices) {
    	this.n = noOfVertices;
    	weight = new int[noOfVertices][noOfVertices];
    }
    
    public void insertEdge(int i, int j) {
    	if(weight[i][j]==1 && weight[j][i]==1) {
    		return;
    	}
    	weight[i][j]=1;
    	weight[j][i]=1;
    	this.e++;
    }
    
    public void removeEdge(int i, int j) {
    	if(weight[i][j]==0 && weight[j][i]==0) {
    		return;
    	}
    	weight[i][j]=0;
    	weight[j][i]=0;
    	this.e--;
   }
    
    
    public int[] adjacency(int u) {
    	int length=0;
    	int k = 0;
    	
    	for(int i=0; i<n; i++) {
    		if(weight[u][i]!=0) {
    			length++;
    		}
    	}
    	
    	int[] adj = new int[length];
    	for(int i=0; i<n; i++) {
    		if(weight[u][i]==1) {
    			adj[k] = i;
    			k++;
    		}
    	}
    	
    	return adj;
    	
    }


    public void bfs(int v){
    	System.out.println("BFS");
    	Queue q = new Queue();
    	
    	
    	int t=0;
    	
    	int l = weight[v].length;
    	boolean visited[] = new boolean[l];
    	
    	for(int k=0; k<l; k++) {
    		visited[k] = false;
    	}
    	
    	q.enqueue(v);
    	
    	while(!(q.isEmpty())) {
    		t=(int)q.dequeue();
    		
    		if(visited[t] == false) {
    			System.out.print(t+", ");
    			visited[t] = true;
    		}
    		
    		for(int k : adjacency(t)) {
    			if(visited[k] == false) {
    				q.enqueue(k);
    			}
    		}    		
    	}
    }

    public void dfs(int v){
    	System.out.println("DFS");
    	Stack s = new Stack();
    	
    	int l = weight[v].length;
    	
    	int j;
    	boolean[] visited = new boolean[l];
    	
    	for(int k =0; k<l; k++) {
    		visited[k] = false;
    	}
    	
    	s.push(v);
    	while(!(s.isEmpty())) {
    	
    		j= (int)s.pop();
    		
    		if(visited[j]==false) {
    			System.out.print(j+", ");
    			visited[j] = true;
    		}
    		
    		for(int k : adjacency(j)) {
    			if(visited[k] == false) {
    				s.push(k);
    			}
    		}
    	}
    }

}
