package graphArray;

import java.util.*;

class Node {
    int vertex;
    Node link;
}

class Graph { //Matrix

    int n; //Number of vertices
    int e; // Number of edges
    int[][] header;
    
    public Graph(int noOfVertices) {
    	this.n = noOfVertices;
    	header = new int[noOfVertices][noOfVertices];
    }
    
    public void insertEdge(int i, int j) {
    	if(header[i][j]==1 && header[j][i]==1) {
    		return;
    	}
    	header[i][j]=1;
    	header[j][i]=1;
    	this.e++;
    }
    
    public void removeEdge(int i, int j) {
    	if(header[i][j]==0 && header[j][i]==0) {
    		return;
    	}
    	header[i][j]=0;
    	header[j][i]=0;
    	this.e--;
   }
    
    
    public int[] adjacency(int u) {
    	int length=0;
    	int k = 0;
    	
    	for(int i=0; i<n; i++) {
    		if(header[u][i]!=0) {
    			length++;
    		}
    	}
    	
    	int[] adj = new int[length];
    	for(int i=0; i<n; i++) {
    		if(header[u][i]==1) {
    			adj[k] = i;
    			k++;
    		}
    	}
    	
    	return adj;
    	
    }


    public void bfs(int v){
//
    }

    public void dfs(int v){
//
    }

}
