import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;



 class Touple{
    Node node;
    int row;
    int col;
    public Touple(Node node ,int row,int col)
    {
        this.node = node;
        this.row = row;
        this.col = col;

    }

}

public class verticalOrderTraversal {
    public static void main(String[] args) {
       Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(7);
        root.right.left = new Node(5);


         List<List<Integer>> ans = new ArrayList<>();
         ans = verticalTraversal(root);
         System.out.println(ans);;

    }

    static  List<List<Integer>> verticalTraversal(Node root)
    {
        TreeMap <Integer ,TreeMap<Integer ,PriorityQueue<Integer>>> map = new TreeMap<>(); 
        Queue<Touple> q =new LinkedList<Touple>();
        q.offer(new Touple(root, 0, 0));
        while(!q.isEmpty())
        {
            Touple touple = q.poll();
            Node node= touple.node;
            int x = touple.row;
            int y = touple.col;
            if(!map.containsKey(x))
            {
                map.put(x,new TreeMap<>());
            }
            if(!map.get(x).containsKey(y))
            {
                map.get(x).put(y,new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.data);

            if(node.left!=null)
            {
                q.offer(new Touple(node.left, x-1, y+1));
            }
            if(node.right!=null)
            {
                q.offer(new Touple(node.right, x+1, y+1));

            }


        }

        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>>ys : map.values())
        {
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values())
            {
                while(!nodes.isEmpty())
                {
                    list.get( list.size()-1).add(nodes.poll());
                }
            }
        }

        return list;
    } 
    
}
