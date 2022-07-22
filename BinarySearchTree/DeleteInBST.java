public class DeleteInBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(6);

    Node newNode =    deleteNode(root,5);
    display(newNode);


    }
    static Node deletNode(Node root,int val){
        if(root==null){
            return null;
        }
        if(root.data == val){
            return helper(root);
        }
        Node dummpy = root;
        while(root!=null){
            if(root.data >val){
                if(root.left!=null && root.left.data == val){
                    root.left = helper(root.right);
                    break;
                    
                }else{
                    root = root.left;
                }
            }
            else{
                if(root.right!=null && root.right.data== val){
                    root.right = helper(root.right);
                }
            }
        }
        return dummpy;
    }

    static Node helper(Node root){
        if(root.left==null){
            return root.right;
        }
        else if(root.right == null){
            return root.left;
        }
        else{
            Node rchild = root.right;
            Node lastright = findLastright(root.left);
            lastright.right = rchild;
            return root.left;
        }


    }

    static Node findLastright(Node root){
        if(root.right== null){
            return root;
        }
        return findLastright(root.right);
    }

    static void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.left);
        display(root.right);
    }
}

