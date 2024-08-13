package post;

public class PostFix {
	public static int evalPostFix(String exp) {
		
		String[] array = exp.split(" "); //����� �����Ѵ�.
		LinkedStack stack = new LinkedStack();
		
		int i=0,a=0,b=0; //i�� ���� a,b�� �ǿ�����
	
		while(i<array.length) {
			
			if(array[i].equals("+")) { //��� �����ٰ� ���� +�� ������
				a=(int)stack.pop(); //int�� ����ȯ�ϸ� a�� ����
				b=(int)stack.pop(); //���� ��.
				stack.push(b+a); //�� ����� ���ؼ� �ٽ� ���ÿ� ����.
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
			else { //������ ���ڰ� �ƴ϶��
				int num = Integer.parseInt(array[i]); //�� ���ڸ� ���ڷ� ��ȯ�Ͽ� 
				stack.push(num);	//���ÿ� �������ش�.
			}
			i++;	//���� ����
		}
		return (int)stack.pop(); //�����, �������� int�� ����ȯ�Ͽ� ������ش�.
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
				
				if(OutPriority==0) { //�켱������ ( �϶�
					stack.push(array[i]); //������ push
				}
				
				else if(array[i].equals(")")) { // ) �� ������
					
					while(true) { //if���� �Ȱɸ��� result�� ��� �߰��� ���ش�. pop�� �͵���
						
						if(PostFix.pis((String)stack.peek())==0) { //���� �켱������ 0, �� (�� ������ �� ���� �´ٸ�
							stack.pop();	 //pop�Ͽ��� �����Ѵ�
							break;			//�׸��� �޼ҵ� ����
						}
						result += (String)stack.pop()+" "; //��� �߰�
						
					}
				}
				
				else if(OutPriority==-1) { //���� �켱������ �Ϲݼ��� = >-1 �̶��
					result += array[i]+" "; //����� �״�� �����ش�.
				}
				
				else if(OutPriority>=PostFix.pis((String)stack.peek())) { // �켱������ ���� ���� �� ���� ���� �켱�������� ���ų� ������
					stack.push(array[i]);	//���ÿ� �����Ѵ�.
				}
				
				else if(OutPriority<PostFix.pis((String)stack.peek())) { //�켱������ ���� �ֻ��� ��ü �켱�������� ������ 
					while(true) {
						result += (String)stack.pop()+" "; //���ÿ��� ��� ����ְ� ����� ����.
						if(PostFix.pis((String)stack.peek())<OutPriority) { //���ष[ ���� �ֻ��� �켱������ �ܺ� �켱�������� ��������
							stack.push(array[i]);	//�Էµ� ��ü�� ���ÿ� Ǫ���Ѵ�,
							break;
						}
					}
				}
				
			}
			
			while(true) {
				if(stack.peek().equals("404")) {  //���࿡ ������ �ֻ����� 404���
					stack.pop();	//404�� �� ������.
				}
				if(stack.isEmpty()) {break;} //���� ������ ��������� �����.
				
				result+=(String)stack.pop()+" "; // ������ ������ ����ؼ� ����ش�.
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
	

