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
	
	public boolean isPZero() {
		if(degree==-1) return true;
		else return false;
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
			if(e>degree) {degree = e;}
			return true;
		}
		else return false;
	}
	
	public boolean delTerm(int e) {
		if(coef[e]==0) return true;
		else {
			coef[e]=0;
			
			if(degree==e) {
				
				int i= e-1;
				while(i>-1 && coef[i]==0) {
					i--;
					degree = i;
				}
			}
			return true;
		}
	}
	
	public Poly sMult(int c, int e) {
		
		Poly p = new Poly();
		
		for(int i=0; i<=this.degree; i++) {
			if(this.coef[0]!=0) {
				p.coef[i+e]=coef[i]*c;
			}
		}
		p.degree=degree+e;
		return p;
	}
	
	public Poly polyAdd(Poly p) {
		Poly r = new Poly();
		
		int bigger;
		if(degree>p.degree) bigger = degree;
		else bigger=p.degree;
		
		for(int i=0; i<=bigger; i++) {
			r.coef[i]=coef[i]+p.coef[i];
		}
		
		r.degree = bigger;
		return r;
	}
	
	public Poly polyMult(Poly p) {
		Poly r = new Poly();
		
		for(int i=0; i<=p.degree; i++) {
			if(p.coef[i]!=0) {
				Poly t = this.sMult(p.coef[i],i);
				r=t.polyAdd(t);
			}
		}
		return r;
	}
	
	public void printResult() {
		
		for(int i=degree; i>=0; i--) {
			
			if(coef[i]!=0) { //0이면 출력 x
				
				if(i==degree) {System.out.print(coef[degree]+"x^"+i);} //최대 지수 계수 값 출력
				
				else {
					if(i==0) {
						System.out.println(" + "+coef[i]); //상수항일 때
						break;}
				
					System.out.print(" + "+coef[i]+"x^"+i);
				}	
			}
		}
	}
}
		
	
		
	
	

