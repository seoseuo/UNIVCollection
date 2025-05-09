package doublelist;

public class DListMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DList d1 = new DList();
		
		d1.addFirst("3");
		d1.addFirst("2");
		d1.addFirst("1");
		
		d1.print();
		
		d1.insert(d1.search("3"), "3.5");
		d1.print();
		
		d1.delete(d1.search("2"));
		d1.print();
	}

}
