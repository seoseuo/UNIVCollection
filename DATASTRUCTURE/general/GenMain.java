package general;

public class GenMain {

	public static void main(String[] args) {
		
		GenList p = new GenList(); 
		
		p.insertData(82); 
		p.insertData("Korea"); 
			
		GenList q = new GenList(); 
		q.insertData(p); //( 82 , Korea )
		q.insertData("Seoul"); // seoul,(82 , korea)		
		
		GenList r = new GenList(); 
		r.insertData(p);
		r.insertData("Busan"); 
		
		GenList L = new GenList();
		L.insertData(r);
		L.insertData(q);
		L.insertData("City");
		L.printGL();
		
		System.out.println();
		
		System.out.println(L.depth());
		
		GenList copy = p.copy();
		
		System.out.println(copy.equal(p));
	}
}

