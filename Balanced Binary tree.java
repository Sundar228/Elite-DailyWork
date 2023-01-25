class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        else if(height(root)==-1){
            return false;
        }
        return true;
        
    }
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        if(height(root.left)==-1 || height(root.right)==-1 || Math.abs(height(root.left)-height(root.right))>1){
            return -1;
        }
        return Math.max(height(root.left),height(root.right))+1;
    }
}