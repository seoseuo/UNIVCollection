package algo_06_20185249;


class Node{
   int vertex;
   Node link;
}

public class GraphList {
   int n;
   int e;
   Node[] header;
   
   public GraphList(int noOfVertices) {
      n = noOfVertices;
      e = 0;
      header = new Node[n];
      int i=0;
      while(i<n) {
  		Node p = new Node();
  		p.vertex = i;
  		header[i]=p;
  		i++;
  	}
   }
   

   public void insertEdge(int i , int j) {
//      Node new1 = new Node();
//      Node in = header[i];
//      //in=in.link;
//      
//      new1.vertex=j;
//      
//      if(in==null) {
//    	  in.link=new1;
//      } 
//      else {
//    	while(in.link!=null) {
//    		in=in.link;
//    	in.link = new1;
//    	}
//      }
//      
//         
//      Node new2 = new Node();
//      Node jn = header[j];
//      jn=jn.link;
//      
//      new2.vertex=i;
//      
//      if(jn==null) {
//    	  jn.link=new2;
//      }
//      else {
//    	  while(jn.link!=null) {
//    		 jn=jn.link;
//          }
//          jn.link = new2;  
//      }

//===================================================
	  		   
	 Node in = new Node();
  	 // i���� ���� vertex�� ã�� ���� ���
  	
  	in=header[i];
  	
  	while(in.link!=null) {
  		in=in.link; //p.link ���� null �� �� ���� ã���ش�.
  	}
  	
  	Node newNode1 = new Node();
  	newNode1.vertex = j;
  
  	in.link = newNode1; //���� ��ũ�� null�� ����Ű�� �ʰ� header[j]�� ����Ű����.
  	newNode1.link = null;
  
  	//===================================================
  	
  	Node jn = new Node();
  	 
  	jn = header[j];
	
  	while(jn.link!=null) {
  		jn=jn.link; //p.link ���� null �� �� ���� ã���ش�.
  	}
  	
  	Node newNode2 = new Node();
  	newNode2.vertex = i;
  	
  	jn.link = newNode2;
  	newNode2.link = null;
   
   this.e++;
       
   }
   
   public void removeEdge(int i, int j) {
   	Node in = header[i];
   	
   	while(in.link.vertex!=j) {
   		in=in.link; //p.link ���� null �� �� ���� ã���ش�.
   	}
   	
   	in.link = in.link.link;; //���� ��ũ�� null�� ����Ű�� �ʰ� header[j]�� ����Ű����.
   	
   	//===================================================
   	
   	Node jn = header[j];

      	
   	while(jn.link.vertex!=i) {
   		jn=jn.link; //p.link ���� null �� �� ���� ã���ش�.
   	}
   
   	jn.link = jn.link.link;
   	
   	
   	this.e--;
   }
   
   
   public int[] adjacency(int u) {
      int adj[];
      int count=0;
      
      //Node p = new Node();
      Node p=header[u];
      
      Node c = new Node();
      c=p;
      
      while(c!=null) {
    	  count++;
    	  c=c.link;
      }
      
      p=p.link; 
      adj = new int[--count];
      
      int i=0;
      
      
      while(i<count) {
    	  adj[i++] = p.vertex;
    	  p=p.link;
      }
      return adj;
   }
   
   public void bfs(int v) {
	   
	  System.out.println("\nBFS");
	  
      Queue q = new Queue();
      
      int j = 0;
      int length =0;
      
      Node p = new Node();
      p=header[v];
      
      while(p!=null) {
         length++;
         p = p.link;
      }
      
      boolean visited[] = new boolean[n];
      
      for(int k = 0 ; k<length; k++) {
         visited[k] = false;
      }
      
      q.enqueue(v);
      
      while(!q.isEmpty()) {
         j = q.dequeue();
         if(visited[j] == false) {
            System.out.print(j+", ");
            visited[j] = true;
         }
         for( int k : adjacency(j) ) {
            if(visited[k] == false ) {
               q.enqueue(k);
            }
         }
         
      }
      
   }
   
   public void dfs(int v) {
	   System.out.println("\nDFS");
      Stack s = new Stack();
      int length =0;
      int j;
      Node p = header[v];
      while(p!=null) {
         length++;
         p = p.link;
      }
      boolean[] visited = new boolean[n];
      for(int k = 0 ; k<length ; k++ ) {
         visited[k] = false;
      }
      s.push(v);
      while(!s.isEmpty()) {
         j = s.pop();
            if(visited[j] == false) {
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