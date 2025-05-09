package poly3;

public class Polynomial {
	private PolyNode firstNode;
	private PolyNode lastNode;
	
	public Polynomial() {
		firstNode=null;
		lastNode=null;
	}
	
	public boolean ispZero() {
		if(firstNode==null) return true;
		else return false;
	}
	
	public void addTerm(int c, int e) {
		PolyNode p = new PolyNode(c,e);
		
		if(firstNode == null) {
			firstNode = p;
			lastNode = p;
		}
		else if(e>firstNode.exp) {
			p.link = firstNode;
			firstNode=p;
		}
		else {
			PolyNode r = firstNode;
			
			while(r.link!=null) {
				if(e>r.link.exp) {
					p.link = r.link;
					r.link=p;
					break;
				}
				else if(e==r.exp) {
					System.out.println("°ãÃÄ¼­ ¾ÈµÅ¿ä ¤Ì¤Ì");
					break;
				}
				r=r.link;
			}
			r.link=p;
			lastNode=p;
		}
	}
	public void delTerm(int e) {
		PolyNode p = firstNode;
		while(p.link != null) {
			if(e==p.link.exp) {
				p.link=p.link.link;
			}
			p=p.link;
		}
	}
	
	public void appendTerm(int c, int e) {
		PolyNode p = new PolyNode(c,e);
		
		if(firstNode==null) {
			firstNode =p;
			lastNode=p;
		}
		else {
			lastNode.link=p;
			lastNode=p;
		}
	}
	
	public Polynomial sMult(int c, int e) {
		Polynomial n = new Polynomial();
		PolyNode p = firstNode;
		
		while(p.link != null) {
			n.appendTerm(p.coef*c, p.exp+e);
			p=p.link;
		}
		return n;
	}
	
	public Polynomial polyAdd(Polynomial poly) {
		
		Polynomial result = new Polynomial();
		
		PolyNode tp = this.firstNode;
		PolyNode pp = poly.firstNode;
		
		while(tp!=null && pp!=null) {
			
			if(tp.exp==pp.exp) {
				result.appendTerm(tp.coef+pp.coef, pp.exp);
				tp=tp.link;
				pp=pp.link;
			}
			else if(tp.exp>pp.exp) {
				result.appendTerm(tp.coef, tp.exp);
				tp=tp.link;
			}
			else {
				result.addTerm(pp.coef, pp.exp);
				pp=pp.link;
			}
		}
		
		while(tp!=null) {
			result.addTerm(tp.coef, tp.exp);
			tp=tp.link;
		}
		
		while(pp!=null) {
			result.addTerm(pp.coef, pp.exp);
			pp=pp.link;
		}
		
		return result;
	}
	
	public Polynomial polyMult(Polynomial q) {
		Polynomial result = new Polynomial();
		Polynomial r = new Polynomial();
		PolyNode p = q.firstNode;
		
		while(p!=null) {
			r=this.sMult(p.coef, p.exp);
			result=result.polyAdd(r);
			p=p.link;
		}
		return result;
	}
//	public boolean ispZero() {
//		if(firstNode==null) return true;
//		else return false;
//	}
//	
//	public void addTerm(int c, int e) {
//		
//		PolyNode p = new PolyNode(c,e);
//		
//		if(firstNode == null) {
//			firstNode=p;
//			lastNode=p;
//		}
//		
//		else if(e>firstNode.exp) {
//			p.link=firstNode;
//			firstNode=p;
//		}
//		
//		else {
//			PolyNode r = firstNode;
//			while(r.link != null) {
//				if(e>r.link.exp) {
//					p.link = r.link;
//					r.link = p;
//					break;
//				}
//				r=r.link;
//			}
//			r.link=p;
//			lastNode=p;
//		}
//	}
//	
//	public void delTerm(int e) {
//		PolyNode p = this.firstNode;
//		PolyNode s = null;
//		
//		while(p != null) {
//			if(p.exp == e) {
//				if(p.exp == firstNode.exp) {
//				firstNode = p.link;
//				}
//				else if(p.exp == lastNode.exp) {
//					s.link = null;
//					lastNode = s;
//				}
//				else {
//					s.link = p.link;
//				}
//			}
//			s = p;
//			p = p.link;
//		}
//	}
//	
//	public Polynomial sMult(int c , int e) {
//		PolyNode p = firstNode;
//		Polynomial rv = new Polynomial();
//		while(p != null) {
//			rv.appendTerm(c*p.coef,e+p.exp);
//			p = p.link;
//		}
//		return rv;
//	}
//	
//	public Polynomial polyMult(Polynomial q) {
//		PolyNode p = q.firstNode;
//		Polynomial res = new Polynomial();
//		Polynomial rv = new Polynomial();
//		
//		while(p != null) {
//			
//			rv = this.sMult(p.coef, p.exp);
//			res = res.polyAdd(rv);
//			p = p.link;
//		}
//		return res;
//	}
//	
//	public void appendTerm(int c, int e) {
//		PolyNode newnode = new PolyNode(c,e);
//		if(firstNode == null) {
//			firstNode = newnode;
//			lastNode = newnode;
//		}else {
//			lastNode.link = newnode;
//			lastNode = newnode;
//		}
//	}
//	
//	public Polynomial polyAdd(Polynomial poly) {
//		Polynomial res = new Polynomial();
//		PolyNode p = this.firstNode;
//		PolyNode q = poly.firstNode;
//		
//		while(p!=null && q!=null) {
//			if(p.exp == q.exp) {
//				res.appendTerm(p.coef+q.coef, p.exp);
//				p = p.link;
//				q = q.link;
//			}
//			else if(p.exp > q.exp) {
//				res.appendTerm(p.coef,p.exp);
//				p = p.link;
//			}
//			else if(p.exp < q.exp) {
//				res.appendTerm(q.coef, q.exp);
//				q = q.link;
//			}
//		}
//		while( p != null) {
//			res.addTerm(p.coef, p.exp);
//			p = p.link;
//		}
//		while(q != null) {
//			res.addTerm(q.coef, q.exp);
//			q = q.link;
//		}
//		return res;
//	}
//	
	public void print() {
		PolyNode p = firstNode;
		while(p != null) {
			//if(p.coef==0) {continue;}
			System.out.print(p.coef + "x^" + p.exp + " + ");
			p = p.link;
		}
		System.out.println();
	}
}
