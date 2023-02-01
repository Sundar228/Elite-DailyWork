class Solution {
    int sum=0;
    public void gst(TreeNode root){
        if(root==null) return;
        gst(root.right);
        sum+=root.val;
        root.val=sum;
        gst(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        gst(root);
        return root;
    }
}
