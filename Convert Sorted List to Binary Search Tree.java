class Solution {
    public TreeNode convert(List<Integer>list,int low,int high){
        if(low>high) return null;
        int mid=(low+high)/2;
        TreeNode newNode=new TreeNode(list.get(mid));
        newNode.left=convert(list,low,mid-1);
        newNode.right=convert(list,mid+1,high);
        return newNode;
    }
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer>list=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            list.add(curr.val);
            curr=curr.next;
        }
        return convert(list,0,list.size()-1);
    }
}
