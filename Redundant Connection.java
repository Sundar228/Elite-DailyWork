class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] arr= null;
        int n = edges.length;
        List<Set<Integer>> adjList = new ArrayList<>(1002);
        for(int i=0; i <1002; i++)
            adjList.add(new HashSet<>());
        
        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            if(dfs(u, v, 0, adjList)){
                arr= edge;
            }else{
                adjList.get(u).add(v);
                adjList.get(v).add(u);
            }
        }
        return arr;
    }
    
    private boolean dfs(int u, int v, int pre, List<Set<Integer>> adjList){
        if(u == v)
            return true;
        for(int a: adjList.get(u)){
            if(a== pre) continue;
            boolean arr = dfs(a, v, u, adjList);
            if(arr) return true;
        }
        return false;
    }
}
