class Solution {
    List<List<Integer>> adjList=new ArrayList<>();
    public void dfs(int source,boolean[] visited){
        visited[source]=true;
        for(int neigh:adjList.get(source)){
            System.out.println(neigh);
            if(!visited[neigh]){
                dfs(neigh,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int rows=isConnected.length;
        int columns=isConnected[0].length;
        boolean visited[]=new boolean[rows];
        for(int i=0;i<rows;i++) adjList.add(new ArrayList<Integer>());
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(i!=j && isConnected[i][j]==1){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int components=0;
        for(int i=0;i<rows;i++){
            if(!visited[i]){
                //System.out.println(i);
                dfs(i,visited);
                components++;
            }
        }
        return components;

    }
}
