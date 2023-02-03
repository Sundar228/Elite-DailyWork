class Solution {
    public void convert(TreeNode root,List<Integer>list) {
        if(root==null) return;
        list.add(root.val);
        convert(root.left,list);
        convert(root.right,list);
    }
    public void flatten(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        convert(root,list);
        if(root==null) return;
        root.left=null;
        root.right=null;
        for(int i=1;i<list.size();i++){
            TreeNode newNode=new TreeNode(list.get(i));
            System.out.println(root.left);
            root.right=newNode;
            root=root.right;
        }
        
    }
}
