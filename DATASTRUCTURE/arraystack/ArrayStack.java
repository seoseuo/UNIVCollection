package arraystack;

public class ArrayStack {

	private int top;;
	private int stackSize;
	private int increment;
	private Object[] itemArray;
	
	public ArrayStack() {
		top=-1;
		stackSize= 2 ;
		increment = 10;
		itemArray = new Object[stackSize];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public void push(Object x) {
		
		if(top==stackSize-1)  
			stackFull(); 
		
		itemArray[++top]=x;
		
		
		
		System.out.println("itemArray[] : "+x);
	
	}
	
	public void stackFull() {
		
		stackSize+=increment;
		
		Object[] newitemArray= new Object[stackSize];
		
		for(int i=0; i<=top; i++) {
			newitemArray[i] = itemArray[i];
		}
		itemArray=newitemArray;
		
		
	}
	
	public Object pop() {
		
		return itemArray[top--];
		
	}
	
	public void remove() {
		if(isEmpty()) return ; 
		else top--;
	}
	
	public Object peek() {
		if(isEmpty()) {return null;}
		else {
			return itemArray[top];
		}
	}
}
