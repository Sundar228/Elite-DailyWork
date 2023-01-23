class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character>list=new ArrayList<>();
        int max=0;
        for(int i=0;i<s.length();i++){
            if(!list.contains(s.charAt(i))){
                list.add(s.charAt(i));
                if(list.size()>max){
                    max=list.size();
                    }
            }
            
            else if(list.contains(s.charAt(i))){
                int a=list.indexOf(s.charAt(i));
                for(int j=0;j<=a;j++){
                    list.remove(0);
                }
                list.add(s.charAt(i));
                if(list.size()>max){
                    max=list.size();
                }
            }
                    
        }
        return max;
    }
}