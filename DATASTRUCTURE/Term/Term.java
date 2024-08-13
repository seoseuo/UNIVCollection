package Term;

public class Term {
		private int coef;
		private int exp;
		
		public Term(int c, int e) {
			this.coef =c;
			this.exp =e;
		}
		
		public int getCoef() {
			return coef;
		}
		
		public int getExp() {
			return exp;
		}
}


class polynomial {
	private final int MAX = 10;
	private int NOT; //NumOfTerms
	public Term[] terms;
	
	public polynomial() {
		terms = new Term[MAX];
		NOT=0;
	}


	
	public int coef(int e) {
		int coefE=0;;
		for(int i=0; i<NOT; i++) {
			if(terms[i].getExp()==e) {coefE=terms[i].getCoef();}
			else coefE=0;
			}
		return coefE;
		}
	
	public boolean addTerm(int c, int e) {
		if(coef(e)!=0) return false;
		else {
			Term nt = new Term(c,e);
			int index = findNextindex(e);//e가 삽입될 위치를 리턴하는 메소드
			
			for(int i=NOT; i>index; i--) {
				terms[i]=terms[i-1];
				terms[index]=nt;
				NOT++;
				}
			return true;
			}
		}
	
	public int findNextindex(int e) {
		int i;
		int findex = 0;
		for(i=0; i<NOT; i++) {
			if(terms[i].getExp()==e) findex= -1;
			if(terms[i].getExp()<e) findex= i;
			}
		return findex;
		}
	
	public polynomial sMult(int c, int e) {
		
		polynomial p = new polynomial();
		
		int exp, coef;
		
		for(int i=0; i<NOT; i++) {
			exp = terms[i].getExp();
			coef= terms[i].getCoef();
			p.terms[i]=new Term(coef,exp);
		}
		p.NOT=NOT;
		return p;
	}
	
	public polynomial polyAdd(polynomial p) {
		polynomial r = new polynomial();
		
		int tp=0,pp=0;
		
		while(tp<this.NOT && pp<this.NOT) {
			if(this.terms[tp].getExp()==this.terms[pp].getExp()) {
				r.addTerm(this.terms[tp].getCoef(),this.terms[pp].getCoef());
				tp++; pp++;
			}
			else if(this.terms[tp].getExp()<this.terms[pp].getExp())  {
				r.addTerm(this.terms[pp].getCoef(),this.terms[pp].getExp());
				pp++;
			}
			else {
				r.addTerm(this.terms[tp].getCoef(),this.terms[tp].getExp());
				tp++;
			}
			while(tp<this.NOT) {
				r.addTerm(this.terms[tp].getCoef(),this.terms[tp].getExp());
				tp++;	
			}
			while(pp<p.NOT) {
				r.addTerm(p.terms[pp].getCoef(),p.terms[pp].getExp());
				pp++;
			}
		}
		return r;
	}
	
	public polynomial polyMult(polynomial p) {
		polynomial r = new polynomial();
		
		for(int i=0; i<NOT; i++) {
			polynomial t = sMult(p.terms[i].getCoef(),p.terms[i].getExp());
			r=r.polyAdd(t);
		}
		return r;
	}
	
	public void print() {
		for(int i=0; i<NOT; i++) {
			System.out.print(terms[i].getCoef());
		}
	}
}


























