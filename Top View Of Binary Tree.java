public class Solution {
	public static ArrayList<Integer> getTopView(BinaryTreeNode root) {
		TreeMap<Integer,Integer>map=new TreeMap<>();
		Queue<BinaryTreeNode>queue=new LinkedList<>();
		Queue<Integer>queue1=new LinkedList<>();
		ArrayList<Integer>list=new ArrayList<>();
		if(root==null) return list;
		int offset=0;
		queue.offer(root);
		queue1.offer(offset);
		while(!queue.isEmpty()){
			int size=queue.size();
			for(int i=0;i<size;i++){
				BinaryTreeNode curr=queue.poll();
				offset=queue1.poll();
				if(!map.containsKey(offset)) map.put(offset,curr.val);
				if(curr.left!=null){
					queue.offer(curr.left);
					queue1.offer(offset-1);
				}
				if(curr.right!=null){
					queue.offer(curr.right);
					queue1.offer(offset+1);
				}
			}
		}
		for(Map.Entry<Integer,Integer> m:map.entrySet()){
			list.add(m.getValue());
		}
		return list;
	}
}
