import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int num;
    Node node;
    public Pair(Node node,int num)
    {
        this.num = num;
        this.node = node;
    }
}

public class MaxWidhtOfBinaryTree {
    public static void main(String[] args) {
        Node root =new Node(1);
        root.left =  new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(5);
        root.left.right = new Node(4);
        root.right.right = new Node(6);
        

        int widht  = findW(root);
        System.out.println("The widht of BT is : " + widht);


    }
    static int findW(Node root)
    {
        Queue<Pair> q = new LinkedList<>();
        if(root==null)return 0;
        int ans=0;
        q.offer(new Pair(root, 0));
        while(!q.isEmpty())
        {
            int size = q.size();
         
            int first =0,last = 0;
            for(int i=0;i<size;i++)
            {
                Node currN = q.peek().node;
                int currVal = q.peek().num;
                q.poll();
                if(i==0) first = currVal;

                if(i==size-1) last = currVal;

                if(currN.left!=null)
                {
                    q.offer(new Pair(currN.left, currVal*2+1));
                }
                if(currN.right!=null)
                {
                    q.offer(new Pair(currN.right, currVal*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }

    
}
