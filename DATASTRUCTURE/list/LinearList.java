package list;

public class LinearList {

	private String strArray[];
	private int size;
	public static int MAX = 100;
	
	public LinearList() {
		size = 0;
		strArray = new String [MAX];
	}
	
	public boolean isEmpty() {
		if(size==0) return true;
		else return false;
	}
	
	public int length() {
		return size;
	}
	
	public String retrieve(int i) {
		if(i<0 || i>=size) return "오류";
		else return strArray[i];
	}
	
	public int find(String str) {
		int a=0;
		
		for(int i=0; i<size; i++) {
			if(strArray[i].equals(str)) {a=i; break;}
			else {a=-1;}
		}
		return a;
	}
	
	public void replace(int i, String str) {
		strArray[i] = str;	
	}
	
	public void replace(String str1, String str2) {
		for(int i=0; i<size; i++) {
			if(str1.equals(strArray[i])) {
				strArray[i] = str2;
				return;
				}
		}
		System.out.println(str1+"값 없습니다.");
	}
	
	public void delete(int i) {
		if(i>size || i<0) { System.out.println("범위 오류"); }
		else {
		for(int j=i; j<size-1; j++) {
			strArray[j]=strArray[j+1];
			}
		size--;
		}
	}
	
	public void delete(String str) {
		delete(find(str));
		}
	
	public void insert(int i,String str) {
		for(int j = size; j>i; j--) {
			strArray[j]=strArray[j-1];
		}
		strArray[i] = str;
		size++;
	}
	
	public void insert(String str) {
		size++;
		strArray[size-1]=str;
	}
	
	public void printArray() {
		for(int i=0; i<size; i++) {
			System.out.println("["+i+"] : "+strArray[i]);
		}
	}
}
