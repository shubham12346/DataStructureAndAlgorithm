import java.util.ArrayList;
import java.util.List;

public class rightSideView {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);
        root.left.right.left = new Node(6);
        
        
        List<Integer> ans = new ArrayList<>();
        int currLevel =0;
        rightSV(root,currLevel,ans);

        System.out.println(ans);
    }
    static void rightSV(Node root,int currLevel ,List<Integer> ans)
    {
        if(root == null)
        {
            return ;
        }

        if(ans.size()== currLevel)
        {
            ans.add(root.data);
        }

        rightSV(root.right, currLevel+1, ans);
        rightSV(root.left, currLevel+1, ans);
    }
    
}
