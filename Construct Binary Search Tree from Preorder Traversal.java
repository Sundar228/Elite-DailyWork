class Solution {
    public TreeNode createTree(int[] preorder,int upper,int[]curr){
        if(curr[0]==preorder.length) return null;
        if(preorder[curr[0]]>upper) return null;
        TreeNode node=new TreeNode(preorder[curr[0]++]);
        node.left=createTree(preorder,node.val,curr);
        node.right=createTree(preorder,upper,curr);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int upper=10000000;
        return createTree(preorder,upper,new int[]{0});
    }
}
