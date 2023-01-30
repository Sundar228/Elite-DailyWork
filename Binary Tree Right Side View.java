class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        List<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size-1;i++){
                TreeNode curr=queue.poll();
                if(curr.left!=null){
                    queue.offer(curr.left);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                }

            }
            TreeNode curr1=queue.poll();
            list.add(curr1.val);
            if(curr1.left!=null){
                queue.offer(curr1.left);
            }
            if(curr1.right!=null){
                queue.offer(curr1.right);
            }
        }
        return list;
    }
}
