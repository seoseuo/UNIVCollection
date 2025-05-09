package algo_12_20185249;


class Node{
	   int vertex;
	   Node link;
	}

public class Graph {

	Node[] header;
	int n;
	int a=0;
	int v=0;
	int successor=0;
	
	Queue zeroPredQ = new Queue();
	Queue[] Q;
	
	int[] sortedList ;
	int[] indegree;
	
	public Graph(int vertices) {
		n=vertices;
		Q = new Queue[n];
		zeroPredQ = new Queue();
		sortedList = new int[n];
		
        for (int i=0; i<n; i++) {
            Q[i] = new Queue();     
       }
        
       indegree = new int[n];

	}
	
	public void topologicalSort() {
		for(int i=0; i<n; i++) {
			if(indegree[i]==0) {
				zeroPredQ.enqueue(i);
			}
		}
		if(zeroPredQ.isEmpty()) {
			System.out.println("network has a cycle");
			return;
		}
		
		while(!zeroPredQ.isEmpty()) {
			v=zeroPredQ.dequeue();
			sortedList[a++] =v;
			
			if(Q[v].isEmpty()) continue;
			else successor = Q[v].dequeue();
			
			while(true) {
				indegree[successor]--;
				
				if(indegree[successor]==0) {
					zeroPredQ.enqueue(successor);
				}
				if(!Q[v].isEmpty()) {
					successor=Q[v].dequeue();
				}
				else break;
			}
		}
		System.out.println("Topological Order is : ");
		
		
		
		for(int i=0; i<sortedList.length; i++) {
			System.out.print(sortedList[i]+" ");
		}
		System.out.println();System.out.println("End");
	}
	
	public void insertEdge(int i , int j) {
		Q[i].enqueue(j);
		indegree[j]++;
		
	}
		
//	 Node in = new Node();
//  
//  	
//  	in=header[i];
//  	
//  	while(in.link!=null) {
//  		in=in.link; 
//  	}
//  	
//  	Node newNode1 = new Node();
//  	newNode1.vertex = j;
//  
//  	in.link = newNode1; 
//  	newNode1.link = null;
//  
//  	//===================================================
//  	
//  	Node jn = new Node();
//  	 
//  	jn = header[j];
//	
//  	while(jn.link!=null) {
//  		jn=jn.link; 
//  	}
//  	
//  	Node newNode2 = new Node();
//  	newNode2.vertex = i;
//  	
//  	jn.link = newNode2;
//  	newNode2.link = null;
//       
   }

