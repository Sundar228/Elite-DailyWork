public class Solution {

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int f=-1;
        while(root!=null && X!=root.data){
            if(X<root.data){
                root=root.left;
            }
            else{
                f=root.data;
                root=root.right;
            }
        }
        if(root!=null && root.data==X) return root.data;
        if(root==null) return f;
        TreeNode<Integer> curr=root.left;
        while(curr!=null){
            if(curr.data==X) return curr.data;
            f=curr.data;
            curr=curr.right;
        }
        return f;
    }
}
