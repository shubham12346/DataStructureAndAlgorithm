class Nodevalue{
    public int maxNode,minNode,maxSize;

    Nodevalue(int minNode,int maxNode,int maxSize){
        this.maxNode = maxNode;
        this.maxSize = maxSize;
        this.minNode = minNode;
    }
  
}
public class LargestBSTInBinaryTree {

    public static void main(String[] args) {
        Node root= new Node(60);
        root.left = new Node(65);
        root.right = new Node(70);
        root.left.left = new Node(50);

        System.out.println(largestBinaryTreeHelper(root).maxSize);


    }

    static Nodevalue largestBinaryTreeHelper(Node root){
        if(root == null){
            return new Nodevalue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }
    Nodevalue left = largestBinaryTreeHelper(root.left);
    Nodevalue right = largestBinaryTreeHelper(root.right);
    

    if(left.maxNode <root.data && right.minNode > root.data){
        return new Nodevalue(Math.min(root.data,left.minNode), Math.max(root.data,right.maxNode), left.maxSize + right.maxSize+1);
    }

    return new Nodevalue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));

}



    
}
