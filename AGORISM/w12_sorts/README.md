1. **선택 정렬**
    1. 잘못된 위치에 들어가 있는 원소를 찾아 그것을 올바른 위치에 집어 넣는 원소 교환 방식으로 정렬
        
        > **1.** 가장 적은 원소를 찾아 첫 번째 위치의 원소와 교환
        **2.** 두 번쨰로 작은 원소를 찾아 두 번째 위치의 원소와 교환
        **3.** 나머지 a[i] , - - - , a[n-1] 원소 중 가장 적은 원소를 선택해서 a[i] 원소와 계속 교환
        > 
        
        ```java
        public class Sorting {
        
        	public static void selectionSort(int[] a) {
        		int i,j,min;
        		int temp;
        		for(i=0; i<a.length-1; i++) {
        			min=i;
        			for(j=i+1; j<a.length; j++) {
        				if(a[j]<a[min]) min=j;
        			}
        	        swap(a, min, i);     
        		}
        	}
        	
        	public static void swap(int[] a,int j, int k) {
        		int temp=a[j];
        		a[j]=a[k];
        		a[k]=temp;
        	}
        	
        
        ```
        
2. **버블 정렬**
    1. 배열을 검사하여 두 인접한 원소가 오름차순 정렬 순서에 맞지 않으면 이들을 서로 교환
        
        > **1.** a[0]과 a[1]을 비교하여 정렬순서에 맞도록 교환
        **2.** a[0]과 a[1]을 비교하여 정렬순서에 맞도록 교환
        **3.** a[n-2]과 a[n-1]을 비교하여 정렬순서에 맞도록 교환
        4. 제일 큰 원소가 배열의 n-1 위치로 이동 → 패스
        5. 배열 처음부터 다시 비교 및 정렬
        마지막 패스로 a[0] 과 a[1]을 비교하여 정렬 → 패스
        > 
        
        ```java
        	public static void bubbleSort(int[] a) {
        		int i, j;
        	    for (i = a.length-1;  i>=0;  --i)
        	           for (j = 0;  j < i; j++)
        	                  if (a[j] > a[j+1])
        	                       swap(a, j, j+1);
        	}
        }
        
        public static void swap(int[] a,int j, int k) {
        		int temp=a[j];
        		a[j]=a[k];
        		a[k]=temp;
        	}
        ```
        
3. **삽입 정렬**
    1. 가정 사항
        1. S  : 정렬되어 있는 배열의 왼쪽 부분
        2. U : 정렬되어 있지 않은 배열의 오른쪽 부분
    2. 정렬되어 있지 않은 U의 왼쪽 끝에서 삽입할 원소를 찾아 정렬되어 있는 S의 적절한 위치에 삽입
        
        > 1. U의 왼쪽에서 삽입할 원소 k를 선택
        2. k를 삭제 (빈자리)
        3. S에 있는 k보다 큰 원소들을 오른쪽으로 이동
        4. k를 S에 만들어진 빈자리에 삽입
        5. U의 모든 원소들이 S에 삽입될 때 까지 반복
        시간 복잡도 =0(n^2)
        > 
    
    ```java
    public static void insertionSort(int[] a) {
    		int k,j;
    		int n=a.length;
    		boolean move ;
    		
    		for(int i=1; i<n; i++) {
    			k=a[i];
    			j=i;
    			
    			if(a[j-1]>k) move=true;
    			else move = false;
    			
    			while(move) {
    				a[j]=a[j-1];
    				j--;
    				
    				if( (j>0) && (a[j-1]>k) ) move = true;
    				else move = false;	
    			}
    			a[j] = k;
    		}
    	}
    ```
    
4. **합병 정렬**
    1. 배열을 이등분하여 각각을 정렬한 후 합병
        
        > 1. 배열 a를 L과 R로 이등분 한 후 배열 L과 R을 각각 정렬
        
        2. 정렬 된 배열 L과 R에서 작은 원소를 삭제하려 새로운 임시 공백 
        배열 S에 차례대로 삽입
        
        3. 원래의 배열 a에 복사
        
        4. 시간 복잡도 : O(n log n)
        > 
    
    ```java
    public static void mergeSort(int[] a) {
    		int[] temp = new int[a.length];
    		theMergeSort(a,temp,0,a.length-1);
    	}
    
    	
    	private static void theMergeSort(int[] a,int[] temp,int left,int right) {
    		if(left<right) {
    			int middle=(left+right)/2;
    			theMergeSort(a,temp,left,middle);
    			theMergeSort(a,temp,middle+1,right);
    			merge(a,temp,left,middle,middle+1,right);
    			
    		}
    	}
    
    	
    	private static void merge(int[] a,int[] temp, int m, int p, int q, int n) {
    		int t=m;
    		int numElements = n-m+1;
    		
    		while( (m<=p)&&(q<=n) ) {
    			if(a[m]<a[q]) temp[t++] = a[m++];
    			else temp[t++] = a[q++];
    		}
    		
    		while(m<=p) {temp[t++] = a[m++];}
    		while(q<=n) {temp[t++] = a[q++];}
    		
    		for(int i=0; i<numElements; i++,n--) {
    			a[n]=temp[n];
    		}
    	}
    ```
    
5. **퀵 정렬**
    1. 분할 정복 정렬 방법의 하나
        
        > 1. 배열 a[m:b] 의 한 원소를 pivot으로 선정
        
        2. pivot 을 기준으로 두개의 파티션으로 분할
                 왼쪽 파티션 : pivot보다 작은 값의  원소들의 구성
                 오른쪽 파티션 : pivot보다 크거나 같은 값의 원소들로 구성
        
        3. 각각의 파티션에 대해 다시 퀵 정렬을 순환 적용 
        시간 복잡도 : O( n log n )
        > 
        
    2. partition 알고리즘
        1. 부분 배열 a[ i : j ] 의 중앙 원소를 pivot 값으로 정하고 왼쪽과 오른쪽 파티션으로 분할
        
    3. 단계별 분할 과정
        
        > 1. a[i:j]의 중앙 인덱스 값 middle을 선정하여 a[middle]의 원소 x를 분할의 기존 값, pivot으로 정한다.
        
        2. a[middle]의 원소 x와 a[]의 제일 왼쪽 끝에 있는 a[i]의 원소 y를 서로 교환 (pivot 인덱스 p는 i를 지시)
        
        3. a[i+1 : j]의 모든 원소 a[k]를 검사하여
         pivot 보다 작을 경우 : a[i+1:p]에 삽입 (p를 1확장)
         pivot보다 크거나 같은 경우 : a[p+1: j ]에 삽입
        항상 (a[i+1 : p] < pivot , a[p+1 : k] ≥ pivot) 을 유지  
        
        4. 모든 원소 검사 완료 후 pivot 인덱스가 확정되면 a[i] 와 a[p]를 교환하여 pivot값을 제자리에 저장
        
        5. 분할 완료 시 확정 된 pivot 인덱스 p를 반환
        > 
        
        ```java
        public static void quickSort(int[] a) {
        		theQuickSort(a,0,a.length-1);
        	}
        	
        	private static void theQuickSort(int[] a, int left, int right) {
        		int p;
        		if(left>right) return;
        		
        		p=partition(a,left,right);
        		theQuickSort(a,left,p-1);
        		theQuickSort(a,p+1,right);
        	}
        	
        	private static int partition(int[] a, int i, int j) {
        		int middle = (i+j)/2;
        		int pivot = a[middle];
        		a[middle] = a[i];
        		a[i]=pivot;
        		int p=i;
        		int temp;
        		
        		for(int k=i+1; k<=j; k++) {
        			if(a[k]<pivot) {
        				p++;
        				temp=a[p];
        				a[p]=a[k];
        				a[k]=temp;
        			}
        		}
        		temp=a[i];
        		a[i]=a[p];
        		a[p]=temp;
        		return p;
        	}
        ```
        
6. **히프 정렬**
    1. 최대 히프를 이용한 정렬 기법
        
        > 1. 정렬할 원소를 모두 공백 히프에 삽입
        2. 루트 도느(가장 큰 원소) 를 삭제하여 리스트 뒤에 삽입
        3. 삽입된 원소를 제외한 나머지 원소들에 대해 반복 수행
        시간 복잡도 O(n log n)
        > 
        - Heapify()를 호출하여 배열 a[1:n]을 히프 구조로 변환
        - 원소를 교환하여 최대 원소 저장
        - Heapify()를 호출하여 나머지 원소를 히프로 재구성
        - 완전 2진 트리를 히프로 변환
        
        ![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/962fee1e-1d6a-4883-87da-468753bbbfea/Untitled.png)
        
        ```java
        class Sorting {
        	public static void heapSort(int[] a) {
        		int n = a.length-1;
        		int temp;
        		
        		for(int i=n/2; i>=1; i--) {
        			heapify(a,i,n);
        			}		
        		
        		for(int i=n-1; i>=1; i--) {
        				temp = a[1];
        				a[1]=a[i+1];
        				a[i+1] = temp;
        				heapify(a,1,i);
        			}
        	}
        	
        	private static void heapify(int[] a,int h,int m) {
        		int ah=a[h];
        		int i;
        		
        		for(i=2*h; i<=m; i*=2) {
        			if(i<m) {
        				if(a[i]<a[i+1]) i++;
        			}
        			if(ah>=a[i]) break;
        			else a[i/2] = a[i];
        		}
        		a[i/2] = ah;
        	}
        }
        ```
