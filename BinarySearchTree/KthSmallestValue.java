import java.util.ArrayList;

public class KthSmallestValue {
    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.right = new Node(12);
        root.right.left = new Node(9);

        int key = 6;
        ArrayList ans = new ArrayList<>();

        findKth(root,ans);
        System.out.println("The kth value is in  :"+ ans.get(key-1));

    }

    static void findKth(Node root ,ArrayList<Integer>ans){
        if(root== null){
            return;
        }
        ans.add(root.data);
        findKth(root.left, ans);
        findKth(root.right, ans);        
    }
    
}
