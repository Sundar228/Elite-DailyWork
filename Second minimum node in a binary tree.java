class Solution {
    Set<Integer>set=new HashSet<>();
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        set.add(root.val);
        inorder(root.right);
    }
    public int findSecondMinimumValue(TreeNode root) {
        inorder(root);
        List<Integer>list=new ArrayList<>(set);
        Collections.sort(list);
        if(list.size()!=1){
            return list.get(1);
        }
        return -1;

    }
}