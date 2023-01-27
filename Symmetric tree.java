class Solution {
    public boolean isSymmetric(TreeNode root) {
        return symmetric(root,root);
    }
    public boolean symmetric(TreeNode p,TreeNode q){
        if(p==null && q==null){
            return true;
        }
        else if(p==null && q!=null){
            return false;
        }
        else if(p!=null && q==null){
            return false;
        }
        else if(p.val!=q.val){
            return false;
        }
        return symmetric(p.left,q.right) && symmetric(p.right,q.left);
    }
}