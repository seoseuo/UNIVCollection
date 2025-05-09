package poly;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Poly y1 = new Poly();
		
		y1.addTerm(7, 3);
		y1.addTerm(5, 2);
		y1.addTerm(7, 1);
		y1.addTerm(1, 0);
		System.out.print("y1 =");y1.printResult();
		
		Poly y2 = new Poly();
		
		y2.addTerm(8, 4);
		y2.addTerm(2, 3);
		y2.addTerm(1, 2);
		y2.addTerm(3, 1);
		System.out.print("y2 =");y2.printResult();
		
		System.out.println("\n+ ------------------");
		y1.polyAdd(y2).printResult();
	}

}
