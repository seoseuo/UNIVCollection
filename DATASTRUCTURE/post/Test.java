package post;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProfessorList p1 = new ProfessorList(10);
		
		p1.append(new Professor(2022,"±Ë√§¿∫"));
		p1.append(new Professor(2021,"±Ë±‚¿∫"));
		p1.append(new Professor(2023,"±Ë¿Ã¿∫"));
		p1.append(new Professor(2024,"±Ëº“¿∫"));
		
		System.out.println(p1.getByName("±Ë±‚¿∫").getID());
		
		p1.print();
	}

}
