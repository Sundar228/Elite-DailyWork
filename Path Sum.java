class Solution {
    public boolean check(TreeNode root, int targetSum,int sum){
        if(root==null) return false;
        sum+=root.val;
        if(sum==targetSum && root.left==null && root.right==null) return true;
        boolean left=check(root.left,targetSum,sum);
        boolean right=check(root.right,targetSum,sum);
        if(left || right) return true;
        return false;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        return check(root,targetSum,sum);       
    }
}
