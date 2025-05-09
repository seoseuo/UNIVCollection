package linked_list;

public class LinkedList {

	public ListNode firstNode;
	
	public LinkedList() {
		firstNode=null;
	}
	
	public ListNode firstNdoe() {
		return firstNode;
	}
	
	public void insert(ListNode p, Object x) {
		ListNode a = new ListNode(x);
		
		if(firstNode == null) {
			firstNode = a;
			a.put_link(null);
		}
		
		else if(x==null) {
			a.put_link(firstNode);
			firstNode=a;
		}
		else {
			a.put_link(p.get_Link());
			p.put_link(a);
		}
	}
	
	public void append(Object x) {
		
		ListNode a = new ListNode(x);
		ListNode r = this.firstNode;
		
		if(firstNode==null) {
			firstNode=a;
			a.put_link(null);
		}
		else {
			while(r.get_Link()!=null) {
				r=r.get_Link();
			}
			r.put_link(a);
		}
	}
	
	public void delete(ListNode p ) {
		if(firstNode==null) {}
		else if(p==null) {firstNode.put_link(firstNode);}
		else {
			if(p.get_Link()==null) {}
			else {
				p.put_link(p.get_Link().get_Link());
			}
		}
	}
	
	public ListNode listSearch(Object data) {
		ListNode p;
		p = firstNode;
		while(p!=null) {
			if(data.equals(p.get_name())) {
				return p;	
			}
			p=p.get_Link();
		}
		return p;
	}
	
	public void print() {
		ListNode p ;
		System.out.print("(");
		p=firstNode;
		
		while(p!=null) {
			System.out.print(p.get_name());
			p=p.get_Link();
			if(p!=null) {
				System.out.print(",");
			}
		}
		System.out.print(")");
	}
	
	
}
