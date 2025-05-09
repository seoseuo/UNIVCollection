# 그래프 순회

**그래프 순회**

- 주어진 어떤 정점을 출발하여 체계적으로 그래프의 모든 정잠들을 순회하는 것

**********************************************그래프 순회의 종류**********************************************

- 깊이 우선 탐색 DFS
- 너비 우선 탐색 BFS

**그래프 순회의 응용**

- 연결 요소
- 신장 트리

**DFS 수행**

1. 정점 i를 방문한다
2. 정점 i 에 인접한 정점 중에서 아직 방문하지 않은 정점이 있으면 , 이 정점들을 모두 스택에 저장한다.
3. 스택에서 정점을 삭제하여 새로운 i 를 설정하고, 단계 1 을 수행한다.
4. 스택이 공백이 되면 연산을 종료한다.

**정점 방문 여뷰를 표시**

- 배열 visited[n]을 이용하여 표현
    - Boolean visited[i] = T or F

**************************그래프 배열************************** 

```java
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
}
```

**그래프 리스트**

```java
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
	  		   
	 Node in = new Node();
  	 
  	
  	in=header[i];
  	
  	while(in.link!=null) {
  		in=in.link; 
  	}
  	
  	Node newNode1 = new Node();
  	newNode1.vertex = j;
  
  	in.link = newNode1; 
  	newNode1.link = null;
  
  	//===================================================
  	
  	Node jn = new Node();
  	 
  	jn = header[j];
	
  	while(jn.link!=null) {
  		jn=jn.link; //p.link 
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
   		in=in.link; //p.link 
      }
   	
   	in.link = in.link.link;; 
   	
   	//===================================================
   	
   	Node jn = header[j];

      	
   	while(jn.link.vertex!=i) {
   		jn=jn.link; 
   	}
   
   	jn.link = jn.link.link;
   	
   	
   	this.e--;
   }
}
```

**adjecency 배열**

```java
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
```

**adjecency 리스트**

```java
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
```

배열 **DFS**

```java
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
```

**리스트 DFS**

```java
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
```

---

**너비 우선 탐색 BFS**

1. 정점 i를 방문한다
2. 정잠 i에 인접한 정점 중에서 아직 방문하지 않은 정점이 있으면, 이 정점들을 모두 큐에 저장한다.
3. 큐에서 이 정점을 삭제하여 새로운 i를 설정하고, 단계 1을 수행한다.
4. 큐가 공백이 되면 연산을 종료한다.

**정점 방문 여부를 표시**

- DFS와 마찬가지로 visited[n]을 이용한다.

배열 **BFS**

```java
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
```

**리스트 BFS**
```java
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
```
