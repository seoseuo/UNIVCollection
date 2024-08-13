package node;

public class TestNode {

	public static final String[] NODE_DATA_ARRAY = {"1","2","3","4","5"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node[] node = new Node[NODE_DATA_ARRAY.length];
		
		for(int i=0; i<NODE_DATA_ARRAY.length; i++) {
			node[i] = new Node(NODE_DATA_ARRAY[i]);
		}
		
		System.out.println("문제 1");
		node[0].setLink(node[1]);
		node[1].setLink(node[2]);
		node[2].setLink(node[3]);
		node[3].setLink(node[4]);
		
		printNode(node[0]);
		
		node[0].setLink(null);
		printNode(node[0]);
		
		System.out.println("문제 2");
		linkAllNodes(node);
		printNode(node[0]);
		node[1].setLink(node[3]);
		printNode(node[0]);
		
		System.out.println("문제3");
		
		linkAllNodes(node);
		printNode(node[0]);
		node[0] = node[2];
		printNode(node[0]);
	}

	public static void printNode(Node start) {
		System.out.println("------------------------");
		for(Node target = start; target != null; target = target.getLink()) {
			System.out.println(target.getData());
		}
		System.out.println("------------------------\n");
	}
	
	public static void linkAllNodes(Node[] array) {
		for(int i=0; i<array.length-1; i++) {
			array[i].setLink(array[i+1]);
		}
 	}
}
