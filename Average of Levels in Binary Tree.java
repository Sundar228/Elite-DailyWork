class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        List<Double>list=new ArrayList<>();
        queue.offer(root);
        if(root==null) return list;
        while(!queue.isEmpty()){
            int size=queue.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode node=queue.poll();
                sum+=node.val;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            list.add(sum/size);
        }
        return list;
    }
}
