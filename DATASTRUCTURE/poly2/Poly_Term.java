package poly2;

public class Poly_Term {

		private final int MAX = 10;
		int NOT; //no0Terms;
		public Term[] terms;
		
		public Poly_Term() {
			terms = new Term[MAX];
			NOT=0;
		}
		
		public boolean isPZero() {
			return (NOT==0);
		}
		
		public int coef(int e) {
			int r=0;
			for(int i=0; i<NOT; i++) {
				if(terms[i].getExp()==e) {
					r= terms[i].getCoef();
				}
			}
			return r;
		}
		
		public int maxEXP() {
			int max = 0;
			for(int i=0; i<NOT; i++) {
				if(max<=terms[i].getExp()) {
					max=terms[i].getExp();
				}
			}
			return max;
		}
		
		/*
		public int findIndex(int e) {
			int r=0;
			for(int i=0; i<NOT; i++) {
				if(terms[i].getExp()==e) {r=-1;}
				if(terms[i].getExp()<e) {r=i;}
				else return -1;
			}
			return r;
			
		}
		*/
		
		public boolean addTerm(int c, int e) {
			
			 if(coef(e)==0) {
		         Term nt=new Term(c, e);
		         
		         int index=NOT;
		         
		         for(int i=NOT-1; i>=0; i--) {
		            if(terms[i].getExp()<e) {
		               terms[i+1]=terms[i];
		               
		               index=i;
		            }
		         }
		         terms[index]=nt;
		         NOT++;
		         
		         return true;
		      }else
		         return false;
		}
		
		
		public Poly_Term polyAdd(Poly_Term p) {
			Poly_Term r = new Poly_Term();
			
			int tp=0,pp=0;
			
			while(tp<this.NOT && pp<p.NOT) {
				if(this.terms[tp].getExp()==p.terms[pp].getExp()) {
					r.addTerm(this.terms[tp].getCoef()+p.terms[pp].getCoef(),this.terms[tp].getExp());
					tp++;
					pp++;
				}
				else if(this.terms[tp].getExp()<p.terms[pp].getExp()) {
					r.addTerm(p.terms[pp].getCoef(),p.terms[pp].getExp());
					pp++;
				}
				else {
					r.addTerm(this.terms[tp].getCoef(),this.terms[tp].getExp());
					tp++;
				}
			}
			
			while(tp<this.NOT) {
				r.addTerm(this.terms[tp].getCoef(),this.terms[tp].getExp());
				tp++;
			}
			while(pp<p.NOT) {
				r.addTerm(p.terms[pp].getCoef(),p.terms[pp].getExp());
				pp++;
			}
			return r;
		}
		
		public Poly_Term sMult(int c, int e) {
			
			Poly_Term p = new Poly_Term();

			int exp, coef;
			
			for(int i=0; i<NOT; i++) {
				exp = this.terms[i].getExp()+e;
				coef = this.terms[i].getCoef()*c;
				p.terms[i] = new Term(coef,exp);
			}
			p.NOT=NOT;
			return p;
		}
		
		public Poly_Term polyMult(Poly_Term p) {
			
			Poly_Term r= new Poly_Term();
			
				for(int i=0; i<NOT; i++) {
					Poly_Term t= sMult(p.terms[i].getCoef(),p.terms[i].getExp());
					r=r.polyAdd(t);
				}	
			
				return r;
			}

		public void printResult() {
			for(int i=0; i<NOT; i++) {
				if(coef(i)==0) {continue;}
				if(terms[i].getExp()==0) {
					System.out.println(terms[i].getCoef());
					break;
					}
				if(i==NOT-1) {
					System.out.println(terms[i].getCoef()+"x^"+terms[i].getExp());
					break;
				}
					System.out.print(terms[i].getCoef()+"x^"+terms[i].getExp()+" + ");	
				}
			}
		
		}
	



