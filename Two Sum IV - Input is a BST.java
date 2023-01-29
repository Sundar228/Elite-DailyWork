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
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        for(int i=0;i<list.size();i++){
            int a=list.get(i);
            list.remove(i);
            if(list.contains(k-a)){
                return true;
            }
            list.add(i,a);
        }
        return false;
    }
}