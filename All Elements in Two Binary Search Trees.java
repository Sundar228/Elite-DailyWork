class Solution {
    public void inorder1(TreeNode root1,List<Integer>list){
        if(root1==null) return;
        inorder1(root1.left,list);
        list.add(root1.val);
        inorder1(root1.right,list);
    }
    public void inorder2(TreeNode root2,List<Integer>list){
        if(root2==null) return;
        inorder2(root2.left,list);
        list.add(root2.val);
        inorder2(root2.right,list);
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>list=new ArrayList<>();
        inorder1(root1,list);
        inorder2(root2,list);
        Collections.sort(list);
        return list;
    }
}
