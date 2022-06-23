public class checkBalancedTree {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);

        int check =  findBt(root);
        if(check==-1)
        {
            System.out.println("The tree is not balance ");
        }else{
            System.out.println("The tree is balanced ");
        }
    }

    static int  findBt(Node root)
    {
        if(root==null)
        {
            return 0;
        }

        int lh =findBt(root.left);
        int rh = findBt(root.right);
        
        if(lh==-1 || rh == -1) return -1;

        if(Math.abs(lh-rh)>1) return -1;

        return 1 + Math.max(lh,rh);
    }
    
}
