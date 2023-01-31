class Solution {
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return constructTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode constructTree(int[] preorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer>map){
        if(ps>pe || is>ie) return null;
        TreeNode node=new TreeNode(preorder[ps]);
        int index=map.get(node.val);
        int numsleft=index-is;
        node.left=constructTree(preorder,ps+1,ps+numsleft,inorder,is,index-1,map);
        node.right=constructTree(preorder,ps+numsleft+1,pe,inorder,index+1,ie,map);
        return node;
    }
}
