package poly;

public class Poly {

	private static final int MAX = 30;
	private int [] coef;
	private int degree;
	
	public Poly() {
		coef = new int [MAX+1];
		for(int i=0; i<=MAX; i++) {
			coef[i]=0;
		}
		degree=-1;
	}
	
	public boolean isPezo() {
		if(degree==-1); {return true;}
	}
	
	public int coef(int e) {
		return coef[e];
	}
	
	public int maxExp() {
		return degree;
	}
	
	public boolean addTerm(int c, int e) {
		if(coef[e]==0) {
			coef[e]=c;
			
			if(e>degree) {degree=e;}
			return true;
		}
		else return false;
	}
	
	public boolean delTerm(int e) {
		if(coef[e]==0) {
			return true;
		}
		else
			coef[e]=0;
			
			int i=e-1;
			
			while(i>-1 && coef[e]==0) {
				i--;
				degree=i;
			}
			
			return true;
	}
	

	public Poly sMult(int c, int e) {
		
		Poly p = new Poly();
		
		for(int i=0; i<=degree; i++) {
			if(coef[i]!=0) {
			p.coef[i+e]=coef[i]*c;
			}
		}
		p.degree=degree+e;
		
		return p;
	}
	
	public Poly polyAdd(Poly p) {
		
		Poly r = new Poly();
		
		int bigger;
		
		if(p.degree>this.degree) {bigger=p.degree;}
		else {bigger=this.degree;}
		
		for(int i=0; i<=bigger; i++) {
			r.coef[i] = this.coef[i]+p.coef[i];
		}
		
		r.degree = bigger;
		return r;
	}
	
	public Poly polyMult(Poly p) {
		
		Poly r = new Poly();
		r.degree=p.degree+this.degree;
		
		for(int i=0; i<=p.degree; i++) {
			r= r.polyAdd(this.sMult(p.coef[i], i));		
		}
		
		return r;
	}
/*	
	public void print() {
		for(int i=this.degree; i>=0; i--) {
			if(coef[i]==0) {continue;}
			
			if(i==0) {
				System.out.println(coef[i]);
				break;
			}
			System.out.print(coef[i]+"x^"+i+" ");
			System.out.print("+");
			}
		}
	}
*/

	public void printResult() {
		for(int i=degree; i>=0; i--) {
			if(i==0) {
				System.out.println(coef[i]);
				break;
			}
			if(coef[i] != 0)
				System.out.print(coef[i]+ "x^" + i + " + ");
		}
	}
}
	

		
	
		
	
	

