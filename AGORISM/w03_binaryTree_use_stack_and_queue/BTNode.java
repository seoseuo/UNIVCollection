package algo_03_20185249;

import java.util.*;

public class BTNode {

	String data;
	BTNode Lchild;
	BTNode Rchild;
	
	public BTNode() {
		
	}
	
	public BTNode(String dt) {
		this.data=dt;
	}
	
	public BTNode(BTNode lc,String dt,BTNode rc) {
		this.data=dt;
		this.Lchild = lc;
		this.Rchild = rc;
	}
}

class BinaryTree {
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
			System.out.println("빈 트리");
			return null;
		}
		else {
			BinaryTree lt = new BinaryTree();
			lt.root=root.Lchild;
			
			return lt;
		}
	}
	
	public BinaryTree rightSubTree() {
		if(this.isEmpty()) {
			System.out.println("빈 트리");
			return null;
		}
		else {
			BinaryTree rt = new BinaryTree();
			rt.root=root.Rchild;
			
			return rt;
		}
	}
	
	public String roodData() {
		if(this.isEmpty()) {
			String n= "빈 트리";
			return n;
		}
		else return root.data;
	}
	
	public void inorder() {
		
		//1. 중위 순회를 root를 사용
		System.out.println("\nInorder");
		theInorder(this.root);
		//2. 반복문을 사용
		System.out.println("\nInorderlter");
		this.inoderlter();
	}
	
	public void preorder() {

		//1. 전위 순회를 root를 사용
		System.out.println(("\nPreorder"));
		thePreorder(this.root);
		//2. 반복문을 사용
		System.out.println(("\nPreorderlter"));
		this.preoderlter();
	}
	
	public void postorder() {
		//1. 후위 순회를 root를 사용
		System.out.println("\nPostorder");
		thePostorder(this.root);
	
	}
	
	private void theInorder(BTNode t) {

		if(t!=null) {
			theInorder(t.Lchild);
			System.out.println(t.data);
			theInorder(t.Rchild);
		}
	}
	
	private void thePreorder(BTNode t) {
		if(t!=null) {
			System.out.println(t.data);
			thePreorder(t.Lchild);
			thePreorder(t.Rchild);	
		}
	}
	
	private void thePostorder(BTNode t) {
		if(t!=null) {
			thePostorder(t.Lchild);
			thePostorder(t.Rchild);
			System.out.println(t.data);
		}
	}
	
	private void inoderlter() {
		
		BTNode p = this.root;
		Stack s = new Stack();
		
		while(p!=null || !(s.empty())) {
			
			if(p!=null) {
				s.push(p);
				p=p.Lchild;
			}
			
			else {
				p=(BTNode) s.pop();
				System.out.println(p.data);
				p=p.Rchild;
				
				
			}
		}
	}
	
	private void preoderlter() {
		BTNode p = root;
		Stack s = new Stack();
		
		while(p!=null || !(s.empty())) {
			
			if(p!=null) {
				System.out.println(p.data);
				s.push(p);
				p=p.Lchild;
			}
			else {
				p=(BTNode)s.pop();
				p=p.Rchild;
			}
		}
	}
	
	public void levelorder() {
		System.out.println("Levelorder");
		BTNode t = root;
		Queue q = new Queue();
		
		q.enqueue(t);
		
		BTNode p;
		
		while(!(q.isEmpty())) {
			p = (BTNode)q.dequere();
			
			if(p!=null) {
				System.out.println(p.data);
				q.enqueue(p.Lchild);
				q.enqueue(p.Rchild);
			}
			
		}
	}
	
	public BinaryTree copy() {
		BinaryTree newTree = new BinaryTree();
		
		newTree.root = theCopy(root);
		
		return newTree;
	}


	public BTNode theCopy(BTNode t) {
		BTNode s = null;
		
		if(t!=null) {
			BTNode l = theCopy(t.Lchild);
			BTNode r = theCopy(t.Rchild);
			s = new BTNode(l,t.data,r);
		}
		return s;
	}
	
	public boolean equals(BinaryTree tr) {
		return theEqual(this.root,tr.root);
	}
	
	public boolean theEqual(BTNode s,BTNode t) {
		
		if(s==null && t==null) {
			return true;
			}
		
		else if(s!=null && t!=null) {
			if(theEqual(s.Lchild,t.Lchild)) {
				return theEqual(s.Rchild,t.Rchild);
				
			}
			else {
				return false;
			}
		}
		
		else return false;
		
	}	
}


