class Solution {
    public void dfs(int source,List<List<Integer>> rooms,boolean[] visited){
        visited[source]=true;
        for(int neigh:rooms.get(source)){
            if(!visited[neigh]){
                dfs(neigh,rooms,visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int rows=rooms.size();
        boolean visited[]=new boolean[rows];
        dfs(0,rooms,visited);
        for(int i=0;i<rows;i++){
            if(visited[i]==false) return false;
        }
        return true;
    }
}
