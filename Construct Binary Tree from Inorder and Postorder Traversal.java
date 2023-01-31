class Solution {
    HashMap<Integer,Integer>map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return constructTree(postorder,0,postorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode constructTree(int[] postorder,int ps,int pe,int[] inorder,int is,int ie,Map<Integer,Integer>map){
        if(ps>pe || is>ie) return null;
        TreeNode node=new TreeNode(postorder[pe]);
        int index=map.get(node.val);
        int numsleft=index-is;
        node.left=constructTree(postorder,ps,ps+numsleft-1,inorder,is,index-1,map);
        node.right=constructTree(postorder,ps+numsleft,pe-1,inorder,index+1,ie,map);
        return node;
    }
}
