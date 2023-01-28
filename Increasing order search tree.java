class Solution {
    TreeNode root1=null;
    TreeNode root2=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null){
            return null;
        }
        increasingBST(root.left);
        TreeNode newNode=new TreeNode(root.val);
        System.out.println(root.val);
        if(root1==null){
            root1=newNode;
            root2=root1;
        }else{
            root1.right=newNode;
            root1=newNode;
        }
        increasingBST(root.right);
        return root2;
    }
}