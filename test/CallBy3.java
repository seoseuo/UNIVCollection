package test;

public class CallBy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OnlyInt n1 = new OnlyInt(10);
		OnlyInt n2 = new OnlyInt(20);
		
		System.out.println("n1 : " + n1.number);
		System.out.println("n2 : " + n2.number);
		
		n1 = n2;
		
		System.out.println("n1 : " + n1.number);
		System.out.println("n2 : " + n2.number);

		n1.number = 30;
		
		System.out.println("n1 : " + n1.number);
		System.out.println("n2 : " + n2.number);
		
	}

}
