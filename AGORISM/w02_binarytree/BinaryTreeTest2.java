/**
 * 
 */
package algo_02_m;


public class BinaryTreeTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTree abtree;
		BinaryTree altree;
		BinaryTree artree;
		
		BinaryTree bbtree;
		BinaryTree bbrtree;
		
		BinaryTree crtree;
		BinaryTree cltree;
		BinaryTree ctree;
		
		BinaryTree dtree;
		
		BinaryTree current;
		
		altree = new BinaryTree(new BinaryTree(),"1",new BinaryTree());
		artree = new BinaryTree(new BinaryTree(),"2",new BinaryTree());
		abtree = new BinaryTree(altree,"+",artree);
		
		bbrtree = new BinaryTree(new BinaryTree(),"3",new BinaryTree());
		bbtree = new BinaryTree(abtree,"*",bbrtree);

		cltree = new BinaryTree(new BinaryTree(),"4",new BinaryTree());
		crtree = new BinaryTree(new BinaryTree(),"5",new BinaryTree());
		ctree = new BinaryTree(cltree,"+",crtree);
		
		
		dtree =  new BinaryTree(bbtree,"-",ctree);
		
		
		System.out.println(dtree.calculate());
		}
	}


