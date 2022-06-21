import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
class Node{
    int data;
    Node left,right;

    

    public Node(int data)
    {
        this.left= null;
        this.right= null;
        this.data = data;
    }
}


class BFS{
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left= new Node(4);
        root.left.right= new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.right = new Node(8);

        List<List<Integer>>ans = BfsTraverse(root);
        System.out.print(ans);

        
    }

    static List<List<Integer>> BfsTraverse(Node root)
    {
            List<List<Integer>>ansArr = new ArrayList<>();

            Queue<Node> queue = new LinkedList<>();
            if(queue == null)
            {
                return ansArr;
            }

            queue.offer(root);
            while(!queue.isEmpty())
            {
                int level = queue.size();
                List<Integer>  sublist = new ArrayList<>();
                for(int i=0;i<level;i++)
                {
                    Node curr = queue.poll();
                    sublist.add(curr.data);

                    if (curr.left != null) {
                        queue.offer(curr.left);
                    }
                    if (curr.right != null) {
                        queue.offer(curr.right);
                    }


                }
                ansArr.add(sublist);
               
            }
            return ansArr;
    }

}