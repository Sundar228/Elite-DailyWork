import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> predecessorSuccessor(BinaryTreeNode<Integer> root, int key) {
		ArrayList<Integer>list=new ArrayList<>();
		int succ=-1;
		int pre=-1;
		while(root.data!=key){
			if(key<root.data){
				succ=root.data;
				root=root.left;
			}
			else{
				pre=root.data;
				root=root.right;
			}
		}
		BinaryTreeNode<Integer> curr=root.right;
		while(curr!=null){
			succ=curr.data;
			curr=curr.left;
		}
		BinaryTreeNode<Integer> curr1=root.left;
		while(curr1!=null){
			pre=curr1.data;
			curr1=curr1.right;
		}
		list.add(pre);
		list.add(succ);
		return list;
	}
}
