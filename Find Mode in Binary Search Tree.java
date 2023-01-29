class Solution {
    HashMap<Integer,Integer>map=new HashMap<>();
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(!map.containsKey(root.val)){
            map.put(root.val,1);
        }
        else{
            int a=map.get(root.val);
            map.put(root.val,++a);
        }
        inorder(root.right);
    }
    public int[] findMode(TreeNode root) {
        inorder(root);
        List<Integer>list=new ArrayList<>();
        int max=0;
        for(Map.Entry m:map.entrySet()){
            int a=(Integer)m.getValue();
            if(a>max){
                max=a;
            }
        }
        for(Map.Entry m:map.entrySet()){
            int b=(Integer)m.getValue();
            if(b==max){
                int c=(Integer)m.getKey();
                list.add(c);
            }
        }
        if(list.size()==0){
            int arr[]=new int[1];
            return arr;
        }
        int arr[]=new int[list.size()];
        for(int i=0;i<list.size();i++){
            arr[i]=list.get(i);
        }
        return arr;
    }
}
