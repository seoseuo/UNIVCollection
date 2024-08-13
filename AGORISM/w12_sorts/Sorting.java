package algo_12_20185249;

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
	
	public static void bubbleSort(int[] a) {
		int i, j;
	    for (i = a.length-1;  i>=0;  --i)
	           for (j = 0;  j < i; j++)
	                  if (a[j] > a[j+1])
	                       swap(a, j, j+1);
	}
}
