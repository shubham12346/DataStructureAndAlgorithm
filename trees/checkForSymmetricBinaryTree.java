public class checkForSymmetricBinaryTree {
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);


        if(isSymmetric(root))
        {
            System.out.println("The tree is symmteric ");

        }else{
            System.out.println("The tree is not Symmetric ");
        }
    }

    static boolean isSymmetric(Node root)
    {
        return root ==null || SymmetricHelp(root.left ,root.right);
    }

    static boolean SymmetricHelp(Node left,Node right )
    {
        if(left==null ||  right == null)
        {
            return left == right;
        }
        if(left.data!= right.data)return false;

        return SymmetricHelp(left.left, right.right) &&  SymmetricHelp(left.right, right.left);
    } 
}
