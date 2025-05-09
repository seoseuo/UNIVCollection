package array_list;

public class List {

	private int size;
	private int array[];
	private static final int MAX = 100;
	
	public List() {
		size = 0;
		array = new int[MAX];
	}
	
	public boolean isEmpty() {
		if(size==0) return true;
		else return false;
	}
	
	public int length() {
		return size;
	}
	
	public int retrieve(int j) {
		if(!(isEmpty())) {
			return array[j];
		}
		else return -1;
	}
	
	public void replace(int j,int item) {
		if(!(isEmpty())) {
			array[j]=item;
		}
		else System.out.println("-1");
	}
	
	public void delete(int j) {
		
		int s = size-1;
		
		if(!(isEmpty())) {
			
			if(s==j) {
				size--;
			}
			else {
				for(int i=j; i<size; i++) {
					array[i]=array[i+1];
				}
				size--;
			}
		}

		else System.out.println("-1");
	}
	
	public void insert (int j,int k) {
		if(array[j]==0) {
			array[j]=k;
			size++;
		}
		
		else {
			size++;
			for(int i=size-1; i>j; i--) {
				array[i]=array[i-1];
			}
			array[j]=k;
		}
	}

}
