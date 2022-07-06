
class BinarySearchTree{
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right= new Node(11);
        root.left.left =  new Node(2);
        root.left.right = new Node(6);
        root.right.right = new Node(12);
        root.right.left =new Node(9);

        displayTree(root);
        System.out.println("  .......................     ");

        
     Node findNode =   findElement( root,9);
     if(findNode!=null)
     {
        System.out.println("Element found ");
        System.out.println(findNode.data);
     }else{
        System.out.println("Not found ");
     }
 


    }
    
    static Node findElement(Node root ,int key){
        while( root != null && root.data!=key ){

            root = (key < root.data )?root.left: root.right ;

        }
        return root ;
    }

    static void displayTree(Node root){
       if(root== null){
        return;
       }
       System.out.print(root.data + " ");
       displayTree(root.left);
      
       displayTree(root.right);
    }



}