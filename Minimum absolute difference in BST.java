class Solution {
    List<Integer>list=new ArrayList<>();
    public void minimum(TreeNode root){
        if(root==null){
            return;
        }
        minimum(root.left);
        list.add(root.val);
        minimum(root.right);
    }
    public int getMinimumDifference(TreeNode root) {
        minimum(root);
        int min=10000000;
        for(int i=0;i<list.size()-1;i++){
            if(Math.abs(list.get(i)-list.get(i+1))<min){
                min=Math.abs(list.get(i)-list.get(i+1));
            }
        }
        return min;
    }
}