package paren;

public class CharStack {

	private CharNode top;
	
	public boolean isEmpty() {
		return (top==null);
	}
	
	public void push(char x) {
		CharNode r = new CharNode();
		r.data=x;
		r.link=top;
		top=r;
	}
	
	public char pop() {
		if(isEmpty()) return '\u0000';
		else {
			char x = top.data;
			top=top.link;
			return x;
			}
		}
	
	public void remove() {
		if(isEmpty()) {
			return;
		}
		else
			top = top.link;
	}
	
	public char peek() {
		if(isEmpty()) {
			return '\u0000';
		}
		return top.data;
	}
}
