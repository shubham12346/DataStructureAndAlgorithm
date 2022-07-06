public class CeilInBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.right = new Node(12);
        root.right.left = new Node(9);
        System.out.println("PreOder Traversal ");
        displayTree(root);

        int ans  = findCeil(root,7);
       System.out.println("  ......   ");
         System.out.println("The ceile is " + ans);

        
      
    }
    static int  findCeil(Node root ,int key){
        int ceil =-1;
        while(root!=null){
            if(root.data == key)
            {
                ceil = root.data; 
            }
            if(key >root.data){
                root = root.right;
            }else{
                ceil = root.data;
                root = root.left;
            }

        }
        return ceil;

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
