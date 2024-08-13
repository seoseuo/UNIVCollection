package post;

public class LinkedStack {

	private ListNode top;
	
	public boolean isEmpty() {
		return (top == null);
	}
	
	public void push(Object x) {
		
		ListNode p = new ListNode();
		p.data=x;
		p.link=top;
		top=p;
	}
	
	public Object pop() {
		if(isEmpty()) return null;
		else {
		Object x= top.data;
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
	
	
	public Object peek() {
		if(isEmpty()) return null;
		else return top.data;
	
	}
 }
