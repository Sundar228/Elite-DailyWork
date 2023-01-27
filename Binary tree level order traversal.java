class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if(root==null){
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list1 = new LinkedList<Integer>();
            for(int i=0; i<size; i++){
                TreeNode curr=queue.poll();
                list1.add(curr.val);
                if(curr.left!=null){
                    queue.offer(curr.left);
                }

                if(curr.right!=null){
                    queue.offer(curr.right);
                }
            }
            list.add(list1);
        }
        return list;
    }
}