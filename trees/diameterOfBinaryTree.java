public class diameterOfBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        


        int []arr =new int[1];
        arr[0] = Integer.MIN_VALUE;

        findDiameter(root,arr);
        System.out.println("The diameter of binary treee is  : "+arr[0]);
       
    }
    static int findDiameter(Node root, int []arr)
    {
        if(root== null)
        {
            return 0;
        }

        int lh = findDiameter(root.left, arr);
        int rh = findDiameter(root.right, arr);

        arr[0]= Math.max(arr[0], lh+rh);

        return 1 + Math.max(lh,rh);
    }
}
