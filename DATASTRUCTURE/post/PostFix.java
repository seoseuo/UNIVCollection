package post;

public class PostFix {
	public static int evalPostFix(String exp) {
		
		String[] array = exp.split(" "); //띄어쓰기로 구분한다.
		LinkedStack stack = new LinkedStack();
		
		int i=0,a=0,b=0; //i는 순서 a,b는 피연산자
	
		while(i<array.length) {
			
			if(array[i].equals("+")) { //계속 돌리다가 만약 +를 만나면
				a=(int)stack.pop(); //int로 형변환하며 a에 저장
				b=(int)stack.pop(); //위와 동.
				stack.push(b+a); //그 결과를 더해서 다시 스택에 저장.
			}
			else if(array[i].equals("-")) {
				a=(int)stack.pop();
				b=(int)stack.pop();
				stack.push(b-a);
			}	
			else if(array[i].equals("*")) {
				a=(int)stack.pop();
				b=(int)stack.pop();
				stack.push(b*a);
			}	
			else if(array[i].equals("/")) {
				a=(int)stack.pop();
				b=(int)stack.pop();
				stack.push(b/a);
			}	
			else { //연산자 문자가 아니라면
				int num = Integer.parseInt(array[i]); //그 문자를 숫자로 변환하여 
				stack.push(num);	//스택에 저장해준다.
			}
			i++;	//순서 증가
		}
		return (int)stack.pop(); //결과값, 최종값을 int로 형변환하여 출력해준다.
	}
	
	public static String makePostFix(String exp) {
		if(exp.length()==0) return null;
		
		else {
			
			String result = "";
			String end = "404";
			int OutPriority=0;
			String[] array = exp.split(" ");
		
			LinkedStack stack = new LinkedStack();
			stack.push(end); 
			
			for(int i=0; i<array.length; i++) { 
				OutPriority = PostFix.pis(array[i]);
				
				if(OutPriority==0) { //우선순위가 ( 일때
					stack.push(array[i]); //무조건 push
				}
				
				else if(array[i].equals(")")) { // ) 를 만나면
					
					while(true) { //if문에 안걸리면 result에 계속 추가를 해준다. pop한 것들을
						
						if(PostFix.pis((String)stack.peek())==0) { //만약 우선순위가 0, 즉 (이 스택의 맨 위로 온다면
							stack.pop();	 //pop하여서 삭제한다
							break;			//그리고 메소드 종료
						}
						result += (String)stack.pop()+" "; //계속 추가
						
					}
				}
				
				else if(OutPriority==-1) { //만약 우선순위가 일반숫자 = >-1 이라면
					result += array[i]+" "; //결과에 그대로 더해준다.
				}
				
				else if(OutPriority>=PostFix.pis((String)stack.peek())) { // 우선순위가 스택 내부 최 상위 것의 우선순위보다 높거나 같으면
					stack.push(array[i]);	//스택에 저장한다.
				}
				
				else if(OutPriority<PostFix.pis((String)stack.peek())) { //우선순위가 스택 최상위 객체 우선순위보다 낮으면 
					while(true) {
						result += (String)stack.pop()+" "; //스택에서 계속 뱉어주고 결과에 저장.
						if(PostFix.pis((String)stack.peek())<OutPriority) { //만약ㅇ[ 스택 최상위 우선순위가 외부 우선순위보다 낮아지면
							stack.push(array[i]);	//입력된 객체를 스택에 푸쉬한다,
							break;
						}
					}
				}
				
			}
			
			while(true) {
				if(stack.peek().equals("404")) {  //만약에 스택의 최상위가 404라면
					stack.pop();	//404를 뱉어서 버린다.
				}
				if(stack.isEmpty()) {break;} //만약 스택이 비어있으면 멈춘다.
				
				result+=(String)stack.pop()+" "; // 스택의 값들을 계속해서 뱉어준다.
			}
			return result;
			}
	}	
	
	
	private static int pis(String x) {
		if(x.equals("*") || x.equals("/"))
			return 2;
		if(x.equals("+") || x.equals("-"))
			return 1;
		if(x.equals("("))
			return 0;
		
		return -1;
	}
	
	private static int pie(String x) {
		if(x.equals("*") || x.equals("/"))
			return 2;
		if(x.equals("+") || x.equals("-"))
			return 1;
		if(x.equals("("))
			return 4;
	
		return -1;
	}
		
		
}
	

