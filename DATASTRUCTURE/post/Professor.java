package post;

import java.util.Arrays;

public class Professor {
	
	private int id;
	private String name;
	
	Professor(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getID() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}

}

class ProfessorList {
	
	private Professor[] pfs;
	private int number;
	
	public ProfessorList() {
		
		pfs=new Professor[20]; //길이가 벌써 20으로 잡혀있잖아.
		//객체배열이야 
		number=0;
	}
	
	public ProfessorList(int n) {
		
		pfs=new Professor[n]; //길이가 벌써 20으로 잡혀있잖아.
		//객체배열이야 
		number=0;
		
	}
	
	public void append(Professor p) {
		pfs[number++]=p; 
	}
	
	public Professor getById(int id) {
		
		Professor result = null;
		
		for(int i=0; i<number; i++) {
			if(pfs[i].getID() == id) {
				result=pfs[i];
			}
		}
		return result;	
	}
	
	public Professor getByName(String name) {
		
		Professor result = null;
		
		for(int i=0; i<number; i++) {
			if(pfs[i].getName().equals(name)) {
				result=pfs[i];
			}
		}
		return result;	
	}
	
	public Professor professorAt(int i) {
	      if(i > -1 && i < number)
	         return pfs[i];
	      else
	         return null;
	   }
	
	public void print() {
		for(int i=0; i<number; i++) {
			System.out.println("id :"+pfs[i].getID() + "  name : "+pfs[i].getName());
		}
	}
}
