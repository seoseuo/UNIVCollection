package algo_04_20185249;


class TreeNode {

	String key;
	TreeNode lchild;
	TreeNode rchild;
}


public class BinarySearchTree {

	private TreeNode rootNode;
	
	
	
	
	public TreeNode BSTsearch(String k) {
		TreeNode p = new TreeNode();
		p=this.rootNode;
		
		while(true) {
			if(p==null) return null;
			else if(p.key.equals(k)) return p;
			else if(p.key.compareTo(k)<0) p=p.rchild;
			else p=p.lchild;
		}
	}
	
	
	
	public void BSTinsert(String k) {
		TreeNode p = rootNode;
		TreeNode q = null;
	

		while(p!=null) {
			if(p.key.compareTo(k)==0) {return;}
				
			q=p;
				
			if(p.key.compareTo(k)>0) {p=p.lchild;}
			else {p=p.rchild;}
		}
			
		TreeNode newNode = new TreeNode();
		newNode.key = k;
			
		if(this.rootNode==null) this.rootNode=newNode;
		else if(q.key.compareTo(k)>0) q.lchild = newNode;
		else q.rchild = newNode; 
		
	}
   
   private TreeNode maxNode(TreeNode root) {
      TreeNode p = root;
      
      if(p.rchild == null)
         return p;
      else
         return maxNode(p.rchild);
   }

//	private TreeNode maxNode(TreeNode root) {
//		TreeNode p = new TreeNode();
//		
//		p=root.lchild;
//		
//		while(true) {
//			if(p.rchild!=null) maxNode(p.rchild);
//			else {
//				p=p.lchild;
//				break;
//			}
//		}
//		
//		return  p;
//	}
//	   
	
//	private TreeNode delete(TreeNode root , String k) {
//	      TreeNode p = root;
//	      TreeNode parents = p;
//
//	      while(true) {
//	         if(p == null) {
//	            return root;
//	         }
//	         if(k.compareTo(p.key) == 0 ) 
//	            break;
//	         parents = p;
//	         if(p.key.compareTo(k) > 0)
//	            p = p.lchild;
//	         else
//	            p = p.rchild;
//	      }
//
//	      if(p.lchild == null && p.rchild == null) {
//	         if(parents.lchild == p)
//	            parents.lchild =  null;
//	         else 
//	            parents.rchild =null;   
//	      }
//	      else if(p.lchild == null  ||  p.rchild == null) {
//	         if(p.lchild != null) {
//	            if(parents.lchild ==  p) {
//	               parents.lchild = p.lchild;
//	            }else{
//	               parents.rchild = p.lchild;
//	            }
//	         }else {
//	            if(parents.lchild == p) {
//	               parents.lchild = p.rchild;
//	            }else {
//	               parents.rchild = p.rchild;
//	            }
//	         }
//	      }
//	      else  if(p.lchild != null  &&  p.rchild != null){
//	         TreeNode q = new TreeNode();
//	         q = maxNode(p.lchild);
//	         p.key = q.key;
//	         if(p.lchild.key.compareTo(p.key) == 0) {
//	            p.lchild = null;
//	         }else
//	         delete(p.lchild , p.key);
//	      }
//	      else {
//	         return p;
//	      }
//	      return p;
//	   }

   
   
   
   private TreeNode delete(TreeNode root, String k) {
	      //TreeNode knode=BSTsearch(k);
	      TreeNode p=rootNode; //부모 노드를 찾기 위해서 만듬
	      TreeNode parent=null; //부모 노드
	      
	      while(p!=null) {
	         if(k.equals(p.key))
	            break;
	         parent=p;
	         if(k.compareTo(p.key)<0)
	            p=p.lchild;
	         else
	            p=p.rchild;
	      }
	      
	      
	      
	      if(p==null) 
	         return null;
	      if(p.lchild==null && p.rchild==null) {
	         if(parent.lchild==p)
	            parent.lchild=null;
	         else
	            parent.rchild=null;
	      }else if(p.lchild==null || p.rchild==null) {
	         
	    	  if(p.lchild!=null) {
	            
	        	 if(parent.lchild==p)
	               parent.lchild=p.lchild;
	            
	        	 else
	               parent.rchild=p.lchild;
	         }
	         
	    	  	
	    	  

	         else {
	            if(parent.lchild==p)
	               parent.lchild=p.rchild;
	            else
	               parent.rchild=p.rchild;
	         }
	      }else if(p.lchild!=null && p.rchild!=null) {
	    	 TreeNode q=new TreeNode();
	         q=maxNode(p.lchild);
	         delete(p.lchild, q.key);
	         p.key=q.key;
	      }
	      return root;
	   }

	public void BSTdelete(String k) {
		this.delete(rootNode, k);
	}
	
	public boolean BSTsplit(String x, BinarySearchTree SmallTree, BinarySearchTree LargeTree) {
		TreeNode p = new TreeNode();
		p=this.rootNode;
		TreeNode small = new TreeNode();
		TreeNode large = new TreeNode();
		TreeNode s = small;
		TreeNode l = large;

		
		while(p!=null) {
			
			if(x.equals(p.key) ) {
	            s.rchild = p.lchild;
	            l.lchild = p.rchild;
	            SmallTree.rootNode = small.rchild;
	            LargeTree.rootNode = large.lchild;

				return true;
			}
			
			else if(p.key.compareTo(x)>0) {
	            l.lchild = p;
	            l = p;
	            p = p.lchild;
			}
			else {
		          s.rchild = p;
		            s = p;
		            p = p.rchild;
			}
		}
		
		return false;
	}
	
	 private void printNode(TreeNode n) {
		if(n!=null) {
			System.out.print("(");
			
		
				printNode(n.lchild);
				System.out.print(" "+n.key+" ");
				printNode(n.rchild);

			System.out.print(")");
		}
		
	}
	
	public void print() {
		
		printNode(this.rootNode);
		System.out.println();
	}
	
}
