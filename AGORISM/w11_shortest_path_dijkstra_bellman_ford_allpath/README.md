# 최단경로

## 최단경로 알고리즘

- 가장 짧은 경로를 찾는 알고리즘.
- 그래프로 표현, 각 지점을 노드, 연결된 도로는 간선이라 함.

### 다익스트라 알고리즘 (양의 가중치)

- 그래프에 여러 노드가 있을 때 특정한 노드에서 출발하여 다른 노드로 가는 각각의 최단 경로를 구해주는 알고리즘
- 음의 간선이 없어야한다, 즉 음의 가중치값이 없어야 한다.

********************동작원리********************

<aside>

1. 출발 노드를 설정한다.

2. 출발 노드를 기준으로 각 노드의 최소 비용을 저장합니다.

3. 방문하지 않은 노드 중에서 최단 거리가 가장 짧은 노드를 선택한다.

4. 해당 노드를 거쳐 다른 노드로 가는 비용 계산

5. 위 과정에서 3,4번을 반복

각 노드에 대한 현재까지의 최단 거리 정보를 1차원 리스트에 저장하여 리스트를 갱신하고 매번 현재 처리하고 있는 노드를 기준으로 주변을 확이나여 노드아 인접한 노드로 도달하는 더 짧은 경로를 찾으면 해다 경로를 제일 짧은 경로로 판단한다.

</aside>

1**번 노드에서 다른 모든 노드로 가는 최단경로 구하기**

- 출발 노드인 1번 노드에서 다른 노드로의 최단 거리를 표시하는 테이블을 생성한다.
- 초기 상태에서는 출발 노드 외에 다른 노드로 가는 최단 거리를 모두 무한으로 초기화한다.

**요점)**

**1→3 값이 5이고**

**1→2→3 값이 4이면**

**1→3 을 4로 갱신하여준다.**

---

### 벨만포드 알고리즘 (음의 가중치)

- 가중치가 음수 일 때도 사용 가능
- 음수 사이클 감지 가능
- 시간 복잡도 O(VE)
- 음의 가중치가 추가된 다익스트라 알고리즘
- **음수 간선의 순환을 감지할 수 있다.**

매번 모든 간선을 확인한다.

음수 간선이 포함된 경우 음수 사이클을 탐지할 수 있다.

**동작원리**

<aside>

1. 시작 노드를 설정한다.

2. 최단 거리 테이블을 만들어준다.

3. 다음 과정을 N-1번 반복한다.

    3-1 전체 간선 E개를 하나씩 확인한다.
    
    3-2 각 간선을 거쳐서 다른 노드로 가는 비용을 계산하여 최단 거리 테이블을 갱신한다.
    

**음수 간선 순환이 발생하는지 확인하는 방법**

     위 과정에서 3번 과정을 한번 더 수행
     이 때 최단거리 테이블의 갱신이 이뤄진다면 음수 사이클이 존재

</aside>

### 모든 쌍의 최단거리

### 다익스트라, 벨만포드, 모든 쌍 실습 코드

```java
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

```

```java
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

//다익스트라 알고리즘
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

//벨만 포드 알고리즘
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

//모든 쌍의 경로
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
```
