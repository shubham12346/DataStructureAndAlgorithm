public class RecoveryBinarySearchTree {
    private static  Node first,middle,prev,last;
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.left.right = new Node(2);
        first = last = middle = null;
        prev = new Node(Integer.MIN_VALUE);
        System.out.println("before ");
        displayTree(root);
        System.out.println("");
       
        inorder(root);

        if( first!= null&& last!=null){
            int t= first.data;
            first.data= last.data;
            last.data =t;
        }else if(first!= null && middle!=null  ){
            int t = first.data;
            first.data = middle.data;
            middle.data = t;

        }
        System.out.println("after ");
        displayTree(root);


    }
    static void inorder(Node root){
        if(root == null) return;
        inorder(root.left);

        if(prev!=null && (root.data <prev.data)){
            if(first ==null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    static void displayTree(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        displayTree(root.left);
      

        displayTree(root.right);
    }
    
}
