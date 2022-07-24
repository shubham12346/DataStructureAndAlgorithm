public class LArgestSubBSTinBT {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(9);
        root.right = new Node(2);
        root.left.left = new Node(6);
        root.right.right =new Node(3);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(7);

        System.out.println(MaxSumBst(root));
    }
    static class INT{
        int a;
    }
    static int MaxSumBst(Node root){
        INT maxsum = new INT();
        maxsum.a = Integer.MIN_VALUE;
    return MaxSumBsthelper(root,maxsum).curmax;

    }
    static class Info{
        int max,min,sum,curmax;
        boolean isBSt;
        Info (int max,int min ,int sum ,int curmax,boolean isBst){
            this.max = max;
            this.min =min;
            this.curmax = curmax;
            this.sum = sum;
            this.isBSt = isBst;
            
        }

        Info(){}
    }
    static Info MaxSumBsthelper(Node root,INT maxsum){
        if(root == null){
            return new Info(Integer.MIN_VALUE,Integer.MAX_VALUE,0,0,true);
        }

        if(root.left== null && root.right== null){
            maxsum.a  = Math.max(root.data ,maxsum.a);
            return new Info(root.data ,root.data,root.data,maxsum.a,true);
        }

        Info L = MaxSumBsthelper(root.left, maxsum);
        Info R = MaxSumBsthelper(root.right, maxsum);
        
        Info Bst = new Info();

        if(L.isBSt && R.isBSt && L.max <root.data && R.min >root.data){
            Bst.max = Math.max(root.data ,Math.max(L.max ,R.max));
            Bst.min = Math.min(root.data,Math.min(L.min,R.min));

            maxsum.a = Math.max(maxsum.a ,R.sum +root.data +L.sum);
            Bst.curmax = maxsum.a;
            Bst.sum = R.sum +root.data + L.sum;
          Bst.isBSt = true;
        return Bst;       
         } 
         Bst.isBSt= false;
         Bst.curmax = maxsum.a;
        Bst.sum =R.sum + root.data +L.sum;

        return Bst;
        
    }
    
}
