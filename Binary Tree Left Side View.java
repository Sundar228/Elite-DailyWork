import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        Queue<TreeNode<Integer>>queue=new LinkedList<>();
        ArrayList<Integer>list=new ArrayList<>();
        queue.offer(root);
        if(root==null){
            return list;
        }
        while(!queue.isEmpty()){
            int size=queue.size();
            TreeNode<Integer> curr=queue.poll();
            list.add(curr.data);
            if(curr.left!=null){
                queue.offer(curr.left);
            }
            if(curr.right!=null){
                queue.offer(curr.right);
            }
            for(int i=1;i<size;i++){
                TreeNode<Integer> curr1=queue.poll();
                if(curr1.left!=null){
                    queue.offer(curr1.left);
                }
                if(curr1.right!=null){
                    queue.offer(curr1.right);
                }
            }
        }
        return list;
    }
}
