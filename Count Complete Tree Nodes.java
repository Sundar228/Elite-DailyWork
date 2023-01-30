class Solution {
    int count=1;
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        if(root.left!=null){
            count++;
            countNodes(root.left);
        }
        if(root.right!=null){
            count++;
            countNodes(root.right);
        }
        return count;
    }
}
