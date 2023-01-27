class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }
    int max=0;
    public int diameter(TreeNode root){
        if(root==null){
            return 0;
        }
        int left=diameter(root.left);
        int right=diameter(root.right);
        if(left+right>max){
            max=left+right;
        }
        return 1 + Math.max(left,right);
    }
}