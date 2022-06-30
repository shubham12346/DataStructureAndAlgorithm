public class lowestCommonAncestor {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
      
        root.right.left.left = new Node(8);

        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);
        
        Node p =  root.right.left.left;
        Node q= root.right.right.left;

        Node ans = lca(root,p,q);
        System.out.println(ans.data);

    }
    static Node lca(Node root,Node p,Node q )
    {
        if(root== null || root == p || root ==q)
        {
            return root;
        }

        Node left = lca(root.left ,p,q);
        Node right = lca (root.right ,p,q);

        if(left==null)
        {
            return right;
        }else if(right==null)
        {
            return left;
        }else{
            return root;
        }
    }
    
}
