**신장트리** 

- 하나의 그래프가 있을 때 모든 노드를 포함하면서 사이클이 존재하지 않는 부분 그래프
- 이 때 모든 노드가 포함되어 서로 연결되면서 사이클이 존재하지 않는다는 조건
- 정점의 갯수가 n개일 때, 간선은 n-1 개가 된다.

**********************************최소 신장 트리********************************** : 신장 트리 중에서도 최소한의 비용으로 만들 수 있는 신장트리

---

## 크루스칼 알고리즘

- 가장 적은 비용으로 모든 노드를 연결하기 위한 알고리즘
- 모든 노드를 최대한 적은 비용으로 ‘연결만’ 시기면 되기 때문에 모든 간선 정보를 오름차순으로 정렬한 뒤 비용이 적은 간선부터 차근 차근 그래프에 포함

1. 간선 데이터를 비용에 따라 오름차순으로 정렬
2. 간선을 하나씩 확인하며 현재의 간선이 사이클을 발생 시키는지 확인
    1. 사이클이 x → 최소 신장 트리에 포함
    2. 사이클이 o → 최소 신장 트리에 포함 x
3. 모든 간선에 대하여 2.의 과정을 반복한다.

- 사이클을 만들면 안된다.

### 크루스칼 알고리즘 실습 코드

- **CompKey 인터페이스** → 오브젝트 값 비교 인터페이스
- **Edge 클래스**
    
    <aside>
    🟢 CompKey를 Implements하고 head, tail, weight 필드가 있다.
    
    | head | weight | tail |
    | --- | --- | --- |
    | 머리 | 가중치 | 꼬리 |
    
    CompareTo 메소드로 현재 가중치와 비교할 가중치값의 차이를 리턴해준다.
    
    </aside>
    
- **minHeap 클래스**
    
    <aside>
    🟢 힙 정렬 만들어줌. insert, delete 기능 모두 수행 가능
    
    </aside>
    
- **UnionFind 클래스**
    
    <aside>
    🟢 사이클을 확인하기 위해서 사용하는 메소드를 제공하는 클래스
    
    </aside>
    
- **Wgraph 클래스**
    
    <aside>
    🟢 n 노드, e 간선 weight[][] 를 필드로 가지며 실질적으로 2차원 배열로 가중치 그래프를 표현해준다. insertEdge() , removeEdge() 메소드를 포함
    
    </aside>
    

**크루스칼 코드**

```java
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
```

![Also Final-8.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8603a646-c5c0-4e2c-9946-aeb0c35bc75b/Also_Final-8.jpg)

---

## 프림 알고리즘

- 시작 정점에서부터 출발하여 신장트리의 집합을 단계적으로 확장해 나가는 방법

1. 시작 단계에서 시작 정점만이 MST 집합에 포함된다
2. 앞 단계에서 만들어진 MST집합에 인접한 정점들 중에서 최소 간선으로 연결된 정점을 선택하여 트리를 확장.
    1. 가장 작은 가중치를 선택한다는 뜻
3. 위의 과정을 트리가 (N-1) 개의 간선을 가질 때 까지 반복한다.

- 마찬가지로 사이클을 만들면 안된다.

### 프림 알고리즘 실습코드

- 크루스칼과 같은 클래스 공유

**프림 코드**

```java
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
```

![Also Final-9.jpg](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7aba97f0-a27e-4c78-92f0-fd8ca0b15698/Also_Final-9.jpg)

**동작 예시 : [https://ongveloper.tistory.com/376](https://ongveloper.tistory.com/376)**

---
