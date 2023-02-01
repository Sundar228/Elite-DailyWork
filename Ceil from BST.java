public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {
        int c=-1;
        while(node!=null && x!=node.data){
            if(x<node.data){
                c=node.data;
                node=node.left;
            }
            else{
                node=node.right;
            }
        }if(node!=null && node.data==x) return node.data;
        if(node==null) return c;
        TreeNode<Integer> curr=node.right;
        while(curr!=null){
            if(curr.data==x) return curr.data;
            c=curr.data;
            curr=curr.left;
        }
        return c;
    }
}
