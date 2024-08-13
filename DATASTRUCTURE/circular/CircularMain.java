package circular;

public class CircularMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularList c1 = new CircularList();
		
		c1.addFirst("3");
		c1.addFirst("2");
		c1.addFirst("1");
		
		c1.addLast("4");
		
		c1.print();
		
		c1.insert(c1.listSearch("3"), "3.5");
		
		c1.print();
		
		c1.delete(c1.listSearch("4"));
		
		c1.print();
	}

}
