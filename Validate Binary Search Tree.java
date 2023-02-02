class Solution {
    public boolean check(TreeNode root,long lower,long upper){
        if(root==null) return true;
        if(root.val>lower && root.val<upper) return check(root.left,lower,root.val) && check(root.right,root.val,upper);
        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return check(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
}
