public class childrenSumPropertyOfBT {
    public static void main(String[] args) {
        Node root= new Node(40);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(2);
        root.left.right = new Node(5);
        root.right.left = new Node(30);
        root.right.right = new Node(40);
        

        changeTree(root);

        printTree(root);
    }
    static void changeTree(Node root)
    {
        int child =0;
        if(root== null)return ;
        if(root.left!=null)
        {
            child += root.left.data;
        }
        if(root.right!=null)
        {
            child+=root.right.data;
        }

        if(child>= root.data) root.data = child;
        else{
            if(root.left!=null) root.left.data = root.data;

            else if(root.right!=null)root.right.data = root.data;


        }

        changeTree(root.left);
        changeTree(root.right);

        int total =0;

        if(root.left!=null) total += root.left.data;
        if(root.right!=null) total += root.right.data;
        
        if(root.left!=null || root.right!= null) root.data = total;


    }

    static void printTree(Node root)//root left righ //preorder traversal
    {
        if(root==null )
        {
            return ;
        }
        System.out.println(root.data); 
      
        printTree(root.left);
      
        printTree(root.right);

    }
    
}
