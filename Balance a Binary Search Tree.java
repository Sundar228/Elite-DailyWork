class Solution {
    public void inorder(TreeNode root,List<Integer>list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode convert(List<Integer>list,int low,int high){
        if(low>high) return null;
        int mid=(low+high)/2;
        TreeNode newNode=new TreeNode(list.get(mid));
        newNode.left=convert(list,low,mid-1);
        newNode.right=convert(list,mid+1,high);
        return newNode;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inorder(root,list);
        return convert(list,0,list.size()-1);
    }
}
