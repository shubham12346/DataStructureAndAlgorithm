public class validBST {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.right = new Node(12);
        root.right.left = new Node(9);

        System.out.println(isValid(root ,Long.MAX_VALUE ,Long.MIN_VALUE));
    }
    static boolean isValid(Node root, long maxVal,long minVal){
        if(root== null)return true;

        if(root.data>=maxVal || root.data<= minVal) return false;
        return isValid(root.left, root.data, minVal)&& isValid(root.right, maxVal, root.data);
    } 
    
}
