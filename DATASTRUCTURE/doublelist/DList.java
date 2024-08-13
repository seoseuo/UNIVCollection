package doublelist;

public class DList {
	DNode first;
	public DList() {
		first = null;
	}
	
	public void addFirst(String name) {
		DNode p = new DNode(name);
		
		if(first==null) {
			first=p;
			first.setRightLink(null);
			
		}
		else {
			p.setRightLink(first);
			first.setLeftLink(p);
			first=p;
		}
	}
	
	public void delete(DNode target) {
		if(target==first) {
			first=first.getRightLink();
		}
		
		else {
			target.getLeftLink().setRightLink(target.getRightLink());
			target.getRightLink().setLeftLink(target.getLeftLink());
		}
	}
	
	public void insert(DNode target, String name) {
		DNode p = new DNode(name);
		
		if(target == null) {
			DNode r = first;
			while(r.getRightLink()!=null) {r=r.getRightLink();}
			
			p.setRightLink(null);
			p.setLeftLink(r);
			r.setRightLink(p);
		}
		
		else if(target.getRightLink() == null) {
			target.setRightLink(p);
			p.setRightLink(null);
			p.setLeftLink(target);
		}
		
		else {
			p.setRightLink(target.getRightLink());
			target.getRightLink().setLeftLink(p);
			p.setLeftLink(target);
			target.setRightLink(p);
		}
	}
	
	public DNode search(String name) {
		DNode p = first;
		
		while(p!=null) {
			if(p.getName().equals(name)) {
				break;
			}
			p=p.getRightLink();
		}
		return p;
	}
	
	public void print() {
		DNode target = first;
		while(target != null) {
			if(target.getRightLink()==null) {
				System.out.println(target.getName());
				break;
			}
			System.out.print(target.getName() + ", ");
			target = target.getRightLink();
		}
	}
}
