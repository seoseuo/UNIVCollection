package general;

public class GenList {
	private ListNode head; 

	public GenList copy() { 
		GenList gn = new GenList();
		gn.head = theCopy(head);
		return gn;
	}
	public boolean equal(GenList T) {
		return theEqual(this.head, T.head);
	}
	public int depth() {
		return theDepth(head);
	}
	
	public void insertData(Object x) { 
	
		ListNode p = new ListNode();
		
		p.data=x;
		p.link=head;
		head=p;
	
	}	
	public void printGL() {
		System.out.print("(");
		ListNode p =  this.head;
		while(p!=null) {
			if(p.data instanceof GenList) {
				((GenList)p.data).printGL();
			}
			else {
				System.out.print(p.data);
			}
			p=p.link;
			if(p!=null) {
				System.out.print(", ");
			}
		}
		System.out.print(")");
	}
	
	private boolean theEqual(ListNode s, ListNode t) {
		
		if(s==null &&t==null) return true;
		if((s!=null &&t==null) || (s==null &&t!=null)) return false;
		
		if(s.data instanceof GenList && t.data instanceof GenList) {
			return theEqual(s.link,t.link);
		}
		else if(!(s.data instanceof GenList) && !(t.data instanceof GenList)) {
			if(s.data.equals(t.data)) return true;
			else return false;
		}
		else return false;
	}
	
	
	private ListNode theCopy(ListNode h) { 
		
		ListNode p = new ListNode();;
		Object o;
		ListNode r;
		
		if(h != null) {
			
			if(!(h.data instanceof GenList)) { o = h.data; }
			else { 
				o = ( (GenList) h.data ).copy(); 
			}
			
			r = theCopy(h.link);
			p.data = o;
			p.link = r;
		}
		return p;
	}
	
	private int theDepth(ListNode h) {
		int result = 0,sub;
		ListNode p=h;
		
		if(head == null) return 0;
	
		while(p != null) {
			if(p.data instanceof GenList) {
				sub = ((GenList)p.data).depth();
				}
			else { sub = 0; }
			
			if(sub>result) { result = sub; }
			
			p = p.link;
		}
		return result+1;
	}
}
