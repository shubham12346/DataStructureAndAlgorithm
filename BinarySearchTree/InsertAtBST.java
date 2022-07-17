public class InsertAtBST {
    
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(6);

        int nodeVal = 8;
        insetNode(root,nodeVal);
        display(root);
    }
    static Node  insetNode(Node root,int val){
        if(root== null) return new Node(val);

        while(true){
            if(root.data<= val){
                if(root.right!=null) root = root.right;

                else{
                    root.right = new Node(val);
                    break;
                }
            }else{
                if(root.left!=null) root = root.left;
                else{
                    root.left = new Node(val);
                    break;
                }
                
            }
        }
        return root;
    }

    static void display(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        display(root.left);
        display(root.right);
    }
}
