package list;

public class LinkedList {

	private int length;
	private ListNode first;
	
	public LinkedList() {
		length = 0;
		first = null;
	}
	
	public int length() {
		return length;
	}
	
	public ListNode firstNode() {
		return first;
	}
	
	public void addFirst(String name) {
		ListNode a = new ListNode(name);
		a.setLink(first);
		first=a;
		length++;
	}
	
	public void print() {
	
		for(ListNode target=first; target!=null; target = target.getLink()) {
			System.out.println(target.getName());
		}
	}
	
	public void insert(String name, ListNode target) {
		ListNode a = new ListNode(name);
		
		if(first==null) {
			first = a;
			first.setLink(null);
		}
		else if(target==null) {
			a.setLink(first);
			first =a;
		}
		else {
			a.setLink(target.getLink());
			target.setLink(a);
		}
		length++;
	}
	
	public ListNode searchNode(String name) {
		ListNode r = null;
		ListNode p = first;
		while(p!=null) {
			if(p.getName().equals(name)) {
			r=p;
			break;
			}
			p=p.getLink();
		}
		return r;
	}
	
	public void insertFront(String name, ListNode target) {
		
		ListNode a = new ListNode(name);
		
		if(first==target) {
			first=a;
			first.setLink(target);
			
		}
		else if(target == null) {
			a.setLink(first);
			first=a;
		}
		else {
			ListNode p = first;
			
			a.setLink(target);
			
			while(p!=null) {
				if(p.getLink()==target) {
					p.setLink(a);
					break;
				}
				p=p.getLink();
			}		
		}
		length++;	
	}
	
	public void delete(ListNode p) {
		if(first==null) { }
		else if(p==null) {first.setLink(first);}
		else {
			if(p.getLink()==null) { }
			else {
				p.setLink(p.getLink().getLink());
			}
			length--;
		}
		
	}
	
	public void invert() {
		ListNode p =first;
		ListNode q = null;
		
		while(p!=null) {
			ListNode r = q;
			q=p;
			p=p.getLink();
			q.setLink(r);
			}
		first=q;
		}
	
	
	
	public void deleteLastNode() {
		if(first==null) { }
		else {
			ListNode p=first;
			while(p.getLink().getLink()!=null) { p=p.getLink(); }
			p.setLink(null);
		}
	}
	
	public static LinkedList concatList(LinkedList list1, LinkedList list2) {
		if(list1.first==null) { return  list2; }
		else if(list2.first==null) { return list1; }
		else {
			LinkedList p = new LinkedList();
			ListNode a=list1.first;
			ListNode b = list2.first;
			
			while(a!=null) {
				p.addFirst(a.getName());
				a=a.getLink();
			}
			while(b!=null) {
				p.addFirst(b.getName());
				b=b.getLink();
			}
			p.length=list1.length+list2.length;
			p.invert();
			return p;
		}
	}
	
//	public static LinkedList concatList1(LinkedList list1, LinkedList list2) {
//		if(list1.first==null) { return  list2; }
//		else if(list2.first==null) { return list1; }
//		else {
//
//			ListNode r=list1.first; //∆˜¿Œ≈Õ
//			
//			int sum_length = list1.length+list2.length;
//			
//			while(r.getLink()!=null) { r=r.getLink(); }
//		
//			r.setLink(list2.first);
//			
//			LinkedList p = new LinkedList();
//			
//			p.length=sum_length;
//			p.first=list1.first;
//			
//			return p;
//		}
//	}
	
	
//	public void append(String name) {
//		
//		ListNode p = new ListNode(name);
//		ListNode r = this.first;
//		
//		while(r.getLink() != null) { 
//			r=r.getLink();
//		}
//		r.setLink(p);		
//	}
}


	
 
