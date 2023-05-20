import java.util.*;
public class AVLtree{
    public class Node{
        int key;
        Node r_node;
        Node l_node;
        int cost;
        public Node(int key){
            this.key=key;
            this.r_node=  null;
            this.l_node=null;
            this.cost=0;
        }
        }

        private Node root;
        private boolean tall;
        private boolean shorter;
        public AVLtree()
        {
        root=null;
        }

        public boolean isEmpty(){
            return (root==null);
        }
        public void display()
        {
            display(root,0);
            System.out.println();
        }

        private void display(Node p,int level)
	{
		int i;
		if(p==null)
			return;
	
		display(p.r_node, level+1);
			System.out.println();
	
		for(i=0; i<level; i++)
			System.out.print("    ");
		System.out.print(p.key);
	
		display(p.l_node, level+1);
        public void inorder()
	{
		inorder(root);
		System.out.println();
	}
	}

}