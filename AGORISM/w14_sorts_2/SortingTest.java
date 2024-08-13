package algo_14_20185249;

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

public class SortingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int test[] = {0,2,4,5,6,3,10,8,1,9,6};
		Sorting.heapSort(test);
		
		System.out.println();
		
		for(int i=0; i<test.length; i++) {
			System.out.print(test[i]+" ");
		}
		
	}

}
