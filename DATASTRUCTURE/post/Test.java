package post;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ProfessorList p1 = new ProfessorList(10);
		
		p1.append(new Professor(2022,"��ä��"));
		p1.append(new Professor(2021,"�����"));
		p1.append(new Professor(2023,"������"));
		p1.append(new Professor(2024,"�����"));
		
		System.out.println(p1.getByName("�����").getID());
		
		p1.print();
	}

}
