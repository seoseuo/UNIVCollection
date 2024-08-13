package circular;

public class CircularList {

	private ListNode tail;
	public CircularList() {
		tail = null;
	}
	
	public int size() {
		if(tail==null) return 0;
		else {
			int count=1;
			ListNode p =tail;
			
			while(p.getLink()!=tail) {
				count++;
				p=p.getLink();
			}
			return count;
		}
	}
	
	public void addFirst(String name) {
		ListNode p = new ListNode(name);
		
		if(tail==null) {
			tail = p;
			tail.setLink(p);			
		}
		
		else {
			p.setLink(tail.getLink());
			tail.setLink(p);
		}
	}
	
	public void addLast(String name) {
		ListNode p = new ListNode(name);
		
		if(tail == null) {
			tail = p;
			tail.setLink(p);
		}
		
		else {
			p.setLink(tail.getLink());
			tail.setLink(p);
			tail=p;
		}
	}
	
	public ListNode listSearch(String targetName) {
		ListNode p = tail;
		
		while(p.getLink() != tail) {
			if(p.getName().equals(targetName)) {
				break;
			}
			p=p.getLink();
		}
		return p;
	}
	
	public void insert(ListNode target, String name) {
		ListNode p = new ListNode(name);
		
		if(target==tail) {
			p.setLink(tail.getLink());
			target.setLink(p);
			tail=p;
		}
		
		else {
			p.setLink(target.getLink());
			target.setLink(p);
			}	
		}
//	public int size() {
//		
//		int cnt=1;
//		
//		if(tail==null) {
//			return 0;
//		}
//			else {
//				ListNode p = tail;
//				while(p.getLink() != tail) {
//					cnt++;
//					p=p.getLink();
//				}
//		return cnt;
//		}
//	}
//	public void addFirst(String name) {
//		ListNode r = new ListNode(name);
//		
//		if(tail == null) {
//			tail = r;
//			r.setLink(r);
//		}
//		else {
//			r.setLink(tail.getLink());
//			tail.setLink(r);
//		}
//	}
//	
//	public void addLast(String name) {
//		ListNode r = new ListNode(name);
//		
//		if(tail==null) {
//			tail = r;
//			r.setLink(r);
//		}
//		else {
//			r.setLink(tail.getLink());
//			tail.setLink(r);
//			tail=r;
//		}
//	}
//	
//	public ListNode listSearch(String name) {
//		ListNode p = tail.getLink();
//		
//		while(p!=tail) {
//			if(p.getName().equals(name)) {
//				return p;
//			}
//			p=p.getLink();
//		}
//		
//		if(p.getName().equals(name)) {return p;}
//		else return null;
//	}
//	
//	public void insert(ListNode target,String name) {
//		ListNode r = new ListNode(name);
//		if(target==tail) {
//			r.setLink(target.getLink());
//			target.setLink(r);
//			tail = r;
//		}
//		else {
//			r.setLink(target.getLink());
//			target.setLink(r);
//		}
//	}
//			
	public void delete(ListNode target) {
		if(target == null) {
			target = this.tail;
		}	
		if(target.getLink() == tail ) {
			target.setLink(tail.getLink());
			tail = target;
		}	
		else {
			target.setLink(target.getLink().getLink());
		} 	
	}		
			
	public void print() {
		ListNode target;
		if(tail != null) {
			target = tail.getLink();
			while(target != tail) {
				System.out.print(target.getName()+", ");
				target=target.getLink();
			}
			System.out.println(target.getName());
		}
	}
}
