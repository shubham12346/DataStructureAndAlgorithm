public class findHeightOfBt {
    public static void main(String[] args) {
        Node root =new Node(1); root.left = new Node(2);
        root.right = new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);

        int height = findHt(root);
        System.out.println("The height of binary tree is "+height);
}

static int findHt(Node root)
{
    if(root== null)
    {
        return 0;
    }
    int lh = findHt(root.left);
    int rh = findHt(root.right);
    return 1+ Math.max(lh, rh);
}
}
