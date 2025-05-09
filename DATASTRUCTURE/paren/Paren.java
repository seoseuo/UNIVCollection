package paren;

public class Paren {
	public static boolean check(String exp) {
		
		CharStack s = new CharStack();
		
		for(int i=0; i<exp.length(); i++) {
			
			char c = exp.charAt(i);
			
			if(c=='(' || c=='{' || c=='[') {
				s.push(c);
			} 
			else if(c == ')') {
				if(!(s.pop()=='(')) {
					return false;
				}
			}
			else if(c == '}') {
				if(!(s.pop()=='{')) {
					return false;
				}
			}
			else if(c == ']') {
				if(!(s.pop()=='[')) {
					return false;
				}
			}
			
		}
		return s.isEmpty();
		
	}   
}
