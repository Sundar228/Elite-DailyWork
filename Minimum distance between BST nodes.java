class Solution {
    List<Integer>list=new ArrayList<>();
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        int min=1000000;
        for(int i=0;i<list.size()-1;i++){
            if(Math.abs(list.get(i)-list.get(i+1))<min){
                min=Math.abs(list.get(i)-list.get(i+1));
            }
        }
        return min;
    }
}