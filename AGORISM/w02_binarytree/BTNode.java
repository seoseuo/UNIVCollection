package algo_02_m;

public class BTNode {

	String data;
	BTNode Lchild;
	BTNode Rchild;
	
	public BTNode(String dt) {
		this.data = dt;
	}
	
	public BTNode(BTNode lc,String dt,BTNode rc) {
		this.data = dt;
		this.Lchild=lc;
		this.Rchild=rc;
	}
	
}

class BinaryTree{
	
	BTNode root;
	
	public BinaryTree() {
		root=null;
	}
	
	public BinaryTree(BinaryTree ltree , String data, BinaryTree rtree) {
		root = new BTNode(data);
		root.Lchild=ltree.root;
		root.Rchild=rtree.root;
	}
	
	public boolean isEmpty() {
		if(root==null) return true;
		else return false;
	}
	
	public BinaryTree leftSubTree() {
		if(this.isEmpty()) {
			System.out.println("后 飘府");
			return null;
		}
		else {
			BinaryTree lt = new BinaryTree();
			lt.root=root.Lchild;
			
			return lt;
		}
		
	}
	
	public BinaryTree ReftSubTree() {
		if(this.isEmpty()) {
			System.out.println("后 飘府");
			return null;
		}
		else {
			BinaryTree rt = new BinaryTree();
			rt.root=root.Lchild;
			
			return rt;
		}
	}
	
	public String roodData() {
		if(this.isEmpty()) {
			String n= "后 飘府";
			return n;
		}
		else return root.data;
	}
	
	public int calculate() {
		return this.theCalculate(root);
	}
	
	private int theCalculate(BTNode n)  {
		
		int rst = 0;
		
		if(n.Lchild==null && n.Rchild==null) {
			rst = Integer.parseInt(n.data);
			return rst;
		}
		
		else {
			
			int li =  theCalculate(n.Lchild);
			int ri =  theCalculate(n.Rchild);
			
			switch(n.data) {
			case "*" : rst = li*ri;
			break;
			case "/" : rst = li/ri;
			break;
			case "+" : rst = li+ri;
			break;
			case "-" : rst = li-ri;
			break;
			
			}
			
			return rst;
		}
			
		
	}
}