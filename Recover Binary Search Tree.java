class Solution {
    public void inorder(TreeNode root,List<Integer>list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode recover(TreeNode root,int a,int b){
        if(root==null) return null;
        if(root.val==a) root.val=b;
        else if(root.val==b) root.val=a;
        recover(root.left,a,b);
        recover(root.right,a,b);
        return root;
    }
    public void recoverTree(TreeNode root) {
        List<Integer>list=new ArrayList<>();
        inorder(root,list);
        int a=0;
        int b=0;
        List<Integer>list1=new ArrayList<>(list);
        Collections.sort(list1);
        for(int i=0;i<list.size();i++){
            if(list.get(i)!=list1.get(i)){
                a=list.get(i);
                b=list1.get(i);
                break;
            }
        }
        System.out.println(a+" "+b);
        recover(root,a,b);
    }
}
