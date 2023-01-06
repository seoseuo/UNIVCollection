package algo_11_20185249;

import java.util.*;


class Edge {
	int head;
	int tail;
	int weight;

	
	public Edge(int h, int t, int w) {
		this.head=h;
		this.tail=t;
		this.weight=w;
	}
	
	public int compareTo(Object value) {
		
		return this.weight-(int)value;
	}
	
}


class Wgraph {
	int n;
	int e;
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
		n=0;
		e=0;
	}
	
	public void insertEdge(int i , int j , int w) {
		weight[i][j] = w;
		e++;
	}
	public void removeEdge(int i , int j) {
		weight[i][j] = 9999;
		e--;	
	}
	
	public int[] shortestPath(int v) {
		boolean s[] = new boolean[n];
		int dist[] = new int[n];
		int u=0;
		
		
		for(int i=0; i<n; i++) {
			s[i]=false;
			dist[i]=weight[v][i];
		}
		
		s[v]=true;
		dist[v]=0;
		
		for(int i=0; i<n-2; i++) {
			int min=9999;
			
			for(int j=0; j<n; j++) {
				if(dist[j]<min && !s[j]) {
					u=j;
					min=dist[u];
				}
			}
			dist[u]=min;
			s[u]=true;
			
			for(int w=0; w<n; w++) {
				if(s[w]==false) {
					if(dist[w]>dist[u]+weight[u][w]) {
						dist[w] = dist[u]+weight[u][w];
					}
				}
			}
		}
		return dist;
	}
	
	
	public int[] negativePath(int v) {
		int dist[] = new int[n];
		int u=0;
		
		for(int i=0; i<n; i++) {
			dist[i]=weight[v][i];
			
			for(int k=2; k<n; k++) { //에러나면 k범위 고쳐보기
				for(int j=1; j<n; j++) {
					for(int z=1; z<n; z++) {
						if(dist[z]>dist[i]+weight[i][z]) {
							dist[z] = dist[i]+weight[i][z];
						}
					}
				}
			}
		}
		return dist;
		
	}
	
	public int[][] allShortestPath() {
		int[][]distance = weight;
		int[][]distanceP;
		int k,i,j;
		
		for(k=0; k<n; k++) {
			for(i=0; i<n; i++) {
				for(j=0; j<n; j++) {
					if(distance[i][j]> (distance[i][k]+distance[k][j])) {
						distance[i][j] = distance[j][k]+distance[k][j];
					}
				}
			}
		}
		distanceP = distance;
		return distanceP;
	}	
	
}

