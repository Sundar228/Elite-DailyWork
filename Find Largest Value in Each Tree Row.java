class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        List<Integer>list=new ArrayList<>();
        if(root==null) return list;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            int max=-Integer.MAX_VALUE-1;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                if(node.val>max) max=node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            list.add(max);
        }
        return list;
        
    }
}
