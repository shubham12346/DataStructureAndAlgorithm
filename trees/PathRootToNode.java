import java.util.ArrayList;
import java.util.List;

public class PathRootToNode {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right =new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);


        List<Integer> ans = new ArrayList<>();
        int val=7;
   
        getPath(ans,root,val);
        System.out.println(ans);
        
    }

    static boolean getPath(List<Integer>ans,Node root,int val){
        if(root==null)
        {
            return false;
        }
        ans.add(root.data);
        if(root.data == val)return true;

        if( getPath(ans, root.left, val) || getPath(ans, root.right, val))
        {
            return true;
        }

        ans.remove(ans.size()-1);
        return false;

    }


    
}
