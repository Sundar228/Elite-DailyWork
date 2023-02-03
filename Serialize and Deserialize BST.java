public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode>queue= new LinkedList<>();
        String s="";
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) {
                s+=("$ ");
            }
            else{
                s+=curr.val + " ";
                if(curr.left==null) queue.offer(null);
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right==null) queue.offer(null);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        System.out.println(s);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data=="") return null;
        String[] arr=data.split(" ");
        Queue<TreeNode>queue=new LinkedList<>();
        TreeNode newNode=new TreeNode(Integer.valueOf(arr[0]));
        queue.offer(newNode);
        for(int i=1;i<arr.length;i++){
            TreeNode node=queue.poll();
            if(!arr[i].equals("$")){
                TreeNode node1=new TreeNode(Integer.valueOf(arr[i]));
                node.left=node1;
                queue.offer(node1);
            }
            if(!arr[++i].equals("$")){
                TreeNode node2=new TreeNode(Integer.valueOf(arr[i]));
                node.right=node2;
                queue.offer(node2);
            }
        }
        return newNode;
    }
}
