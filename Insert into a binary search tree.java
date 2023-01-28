class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode=new TreeNode(val);
        if(root==null){
            root=newNode;
            return root;
        }
        TreeNode curr=root;
        TreeNode parent=null;
        while(curr!=null){
            parent=curr;
            if(val<curr.val){
                curr=curr.left;
            }
            else{
                curr=curr.right;
            }
        }
        if(val<parent.val){
            parent.left=newNode;
        }
        else{
            parent.right=newNode;
        }
        return root;
    }
}