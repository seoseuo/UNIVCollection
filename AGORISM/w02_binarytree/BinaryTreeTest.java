package algo_02_m;

public class BinaryTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		BinaryTree btree;
		BinaryTree ltree;
		BinaryTree rtree;
		BinaryTree current;
		
		ltree = new BinaryTree(new BinaryTree(),"1",new BinaryTree());
		rtree = new BinaryTree(new BinaryTree(),"2",new BinaryTree());
		btree = new BinaryTree(ltree,"+",rtree);
		ltree=btree;
		

		rtree = new BinaryTree(new BinaryTree(),"3",new BinaryTree());
		btree = new BinaryTree(ltree, "*" , rtree);
		
		System.out.println(btree.calculate());
	}

}
