public class floorInBST {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(2);
        root.left.right = new Node(6);


        int key =7;
        int ans = findFloor(root,key);
        System.out.println("The floor is  : "+ans);
    }
    static int findFloor(Node root,int key){
    int floor =-1;
    while(root!=null){
        if(key== root.data){
            floor = root.data;
            return floor;
        }
        else if(key>= root.data ){
            floor = root.data;
            root = root.right;
        }
        else{
            root = root.left;
        }
    }
    return floor;
    }
    
}
