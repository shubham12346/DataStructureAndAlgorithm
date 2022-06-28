import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TreeNode{
    TreeNode left;
    TreeNode right;

    int data,pointer;
 
    public TreeNode(int data)
    {
        this.data = data;
        this.left =null;
        this.right=null;
    

    }
}
public class buttomViewOfBT{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right =new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left =new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.right.left = new TreeNode(8);
        root.left.right.right = new TreeNode(9);
        

        ArrayList<Integer> ans = new ArrayList<>();
        ans = findBTV(root);
        System.out.println(ans);

        
    }

    static ArrayList<Integer> findBTV(TreeNode root)
    {
            ArrayList<Integer>ans = new ArrayList<>();
            Map<Integer,Integer>map= new TreeMap<>();
            Queue<TreeNode> q = new LinkedList<>();

            if(root == null)return ans;
            root.pointer =0;
            q.offer(root);
            while(!q.isEmpty())
            {
                
                TreeNode curr = q.poll();
                int index  = curr.pointer;
                map.put(index,curr.data);

                if(curr.left!=null)
                {
                    curr.left.pointer = index-1;
                    q.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    curr.right.pointer = index+1;
                    q.offer(curr.right);
                }

            }

            for ( Map.Entry<Integer,Integer> entry : map.entrySet()) {
                ans.add(entry.getValue());
                
            
        }
        return ans;

}
}