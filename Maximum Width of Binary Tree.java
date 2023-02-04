class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode>queue=new LinkedList<>();
        Queue<Integer>queue1=new LinkedList<>();
        queue.offer(root);
        queue1.offer(0);
        List<Integer>list=new ArrayList<>();
        while(!queue.isEmpty()){
            int size=queue.size();
            int a=0;
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                int id=queue1.poll();
                if(i==0) a=id;
                if(i==size-1) list.add(id-a);
                if(curr.left!=null){
                    queue.offer(curr.left);
                    queue1.offer(id*2+1);
                }
                if(curr.right!=null){
                    queue.offer(curr.right);
                    queue1.offer(id*2+2);
                }
            }
        }
        //for(int i=0;i<list.size();i++) System.out.println(list.get(i));
        return Collections.max(list)+1;
    }
}
