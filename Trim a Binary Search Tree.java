class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        else if(root.val<low) root=trimBST(root.right,low,high);
        else if(root.val>high) root=trimBST(root.left,low,high);
        else if(root.val==low){
            root.left=null;
            root.right=trimBST(root.right,low,high);
        }
        else if(root.val==high){
            root.right=null;
            root.left=trimBST(root.left,low,high);
        }
        else{
            root.right=trimBST(root.right,low,high);
            root.left=trimBST(root.left,low,high);
        }
        return root;
    }
}
