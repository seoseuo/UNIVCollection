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
        
        ![image](https://user-images.githubusercontent.com/90320005/211132641-45c07c9e-0a03-4626-9887-0079f35e75c0.png)

        
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
