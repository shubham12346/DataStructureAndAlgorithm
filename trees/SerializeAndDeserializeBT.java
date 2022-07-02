import java.util.LinkedList;
import java.util.Queue;

class SerializeAndDeserializeBT{
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        String serial = Serialize(root);
        System.out.println("Serilize data is  :"+serial);

       Node root2 =  deserialize(serial);
        printTree(root2);
    }
    static String Serialize(Node root){
        if(root == null) return "";

        Queue<Node>q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            if(curr== null)
            {
                res.append("n ");
                continue;

            }
            res.append(curr.data+" ");
            q.add(curr.left);
            q.add(curr.right);
        }

        return res.toString();
         
    }

    static Node deserialize(String data )
    {
        if(data== "")return null;
        Queue<Node> q = new LinkedList<>();
        String value[] = data.split(" ");
        
        Node root = new Node(Integer.parseInt(value[0]));
        q.add(root);

        for(int i=1;i<value.length;i++)
        {
            Node parent = q.poll();
            if(!value[i].equals("n"))
            {
                Node left = new Node(Integer.parseInt(value[i]));
                parent.left =left;
                q.add(left);
            }
            if (!value[++i].equals("n")) {
                Node right = new Node(Integer.parseInt(value[i]));
                parent.right= right;
                q.add(right);
            }
        }
        return root;

    }
    static void printTree(Node root)
    {
        if(root== null)
        {
            return;
        }

        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);

    }
}