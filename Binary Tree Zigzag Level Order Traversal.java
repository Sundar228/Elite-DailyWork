class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode>queue=new LinkedList<>();
        List<List<Integer>>list=new LinkedList<>();
        if(root==null) return list;
        queue.offer(root);
        int a=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer>list1=new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode curr=queue.poll();
                list1.add(curr.val);
                if(curr.left!=null) queue.offer(curr.left);
                if(curr.right!=null) queue.offer(curr.right);
            }
            if(a%2==0) list.add(list1);
            else{
                Collections.reverse(list1);
                list.add(list1);
            }
            a++;
        }
        return list;
    }
}
