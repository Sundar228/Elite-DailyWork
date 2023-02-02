class Solution {
    public TreeNode convert(int[] nums,int low,int high){
        if(low>high) return null;
        int mid=(low+high)/2;
        TreeNode newNode=new TreeNode(nums[mid]);
        newNode.left = convert(nums,low,mid-1);
        newNode.right = convert(nums,mid+1,high);
        return newNode;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return convert(nums,0,nums.length-1);
    }
}
