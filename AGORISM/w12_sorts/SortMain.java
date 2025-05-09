package algo_12_20185249;

public class SortMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = {5,2,8,3,1};
		
		System.out.println("정렬 전 배열 원소 : ");
		
		int i;
		for(i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		Sorting.selectionSort(a);
		System.out.println("정렬 된 배열 원소 : ");
		for(i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		int[] b = {5,2,11,8,3,1,7};
		System.out.println("정렬 전 배열 원소");
		for(i=0; i<b.length; i++) {
			System.out.print(b[i]+ " ");
		}
		System.out.println(); 
		
		
		Sorting.bubbleSort(b);
		System.out.println("정렬 된 배열 원소");
		for(i=0; i<b.length; i++) {
			System.out.print(b[i]+ " ");
		}
		System.out.println();
	}

}
