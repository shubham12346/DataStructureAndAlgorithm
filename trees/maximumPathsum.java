public class maximumPathsum {
    public static void main(String[] args) {
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new  Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);


        int maxSum[]= new int [1];
        maxSum[0] = Integer.MIN_VALUE;

        findSum(root,maxSum);
        System.out.println("the Maximu path sum of BT  is  "+maxSum[0]);
        

    }
    static int findSum(Node root ,int [] arr)
    {
        if(root== null)
        {
            return 0;
        }

        int lh = Math.max(0,findSum(root.left, arr ));
        int rh = Math.max(0,findSum(root.right, arr));

        arr[0] = Math.max( arr[0], lh+rh+root.data);
        return root.data + Math.max(lh, rh);
    }
}
