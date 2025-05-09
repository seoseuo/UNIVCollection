package graphList;

import java.util.*;

class Node {
    int vertex;
    Node link;
}

class GraphList { //Matrix

    int n; //Number of vertices
    int e; // Number of edges
    Node[] header;
    
    public GraphList(int noOfVertices) {
    	n=noOfVertices;
    	header = new Node[n];
    	int i=0;
    	
    	while(i<=n-1) {
    		Node p = new Node();
    		p.vertex = i;
    		header[i]=p;
    		i++;
    	}
    }
    
    public void insertEdge(int i, int j) { //i에서 j로 간선이 있다.
    	
    	Node in = new Node();
    	 // i값을 가진 vertex를 찾기 위한 노드
    	
    	for(int a=0; a<this.n; a++) {
    		if(this.header[a].vertex==i) {
    			in = header[a];
    			break;
    		}
    	}
    	
    	while(in.link!=null) {
    		in=in.link; //p.link 값이 null 일 때 까지 찾아준다.
    	}
    	
    	Node newNode1 = new Node();
    	newNode1.vertex = j;
    
    	in.link = newNode1; //다음 링크가 null을 가르키지 않고 header[j]를 가르키도록.
    	newNode1.link = null;
    
    	//===================================================
    	
    	Node jn = new Node();
    	jn.vertex = j; 
    	
    	for(int a=0; a<this.n; a++) {
    		if(this.header[a].vertex==jn.vertex) {
    			jn = header[a];
    			break;
    		}
    	}
    	
    	while(jn.link!=null) {
    		jn=jn.link; //p.link 값이 null 일 때 까지 찾아준다.
    	}
    	
    	Node newNode2 = new Node();
    	newNode2.vertex = i;
    	
    	jn.link = newNode2;
    	newNode2.link = null;
    	
    	this.e++;
    }
    
    public void removeEdge(int i, int j) {
    	Node in = new Node();
    	in.vertex = i; // i값을 가진 vertex를 찾기 위한 노드
    	
    	for(int a=0; a<this.n; a++) {
    		if(this.header[a].vertex==i) {
    			in = header[a];
    			break;
    		}
    	}
    	
    	while(in.link.vertex!=j) {
    		in=in.link; //p.link 값이 null 일 때 까지 찾아준다.
    	}
    	
    	in.link = in.link.link;; //다음 링크가 null을 가르키지 않고 header[j]를 가르키도록.
    	
    	//===================================================
    	
    	Node jn = new Node();
    	jn.vertex = j; 
    	
    	for(int a=0; a<this.n; a++) {
    		if(this.header[a].vertex==jn.vertex) {
    			jn = header[a];
    			break;
    		}
    	}
    	
    	while(jn.link.vertex!=i) {
    		jn=jn.link; //p.link 값이 null 일 때 까지 찾아준다.
    	}
    
    	jn.link = jn.link.link;
    	
    	
    	this.e--;
    }
    
    public int[] adjacency(int u) {
    	int count=0;
    	Node p = new Node();
    	
    	for(int i=0; i<this.n; i++) { //vertex값이 u인 header[] 배열 객체 찾기
    		if(header[i].vertex==u) {		
    			p=header[i];
    			p=p.link;
    			break;
    			}
    		}
    	
    	Node c = new Node(); //해당 hedaer[]노드가 가르키는 노드들이 몇개인지 찾기
    	c=p;
    	
    	while(c!=null) {
			count++;
			c=c.link;
		}
    	
    	int[] adj = new int[count]; //개수만큼 배열 길이를 설정해준 뒤 하나하나 값 넣기.
    	
    	int l = 0;
    	while(p!=null) {
    		adj[l++] = p.vertex;
    		p=p.link;
    		
    	}
    	return adj;
    	
    }


//    public void bfs(int v){
//    	Queue q = new Queue();
//    	int t = 0;
//    	int l = 0;
//    	
//    	Node p = header[v];
//    	
//    	while(p!=null) {
//    		l++;
//    		p = p.link;
//    	}
//    	
//    	boolean visited[] = new boolean[l];
//    	
//    	for(int k=0; k<l; k++) {
//    		visited[k] = false;
//    	}
//    	
//    	
//    }
//
//    public void dfs(int v){
////
//    }

}



