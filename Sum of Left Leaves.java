class Solution {
    int sum=0;
    int a=0;
    int b=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) sum+=root.val;
        if(root.left!=null){
            a++;
            sumOfLeftLeaves(root.left);
        }
        if(root.right!=null){
            b++;
            if(root.right.left==null && root.right.right==null){
                sum-=root.right.val;
            }
            sumOfLeftLeaves(root.right);
        }
        if(a==0 && b==0){
            return 0;
        }
        return sum;
    }
}
