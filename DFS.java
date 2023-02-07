class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    ArrayList<Integer>list=new ArrayList<>();
    public void dfs(int source,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[source]=true;
        for(int neigh:adj.get(source)){
            if(!visited[neigh]){
                list.add(neigh);
                dfs(neigh,adj,visited);
            }
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean visited[]=new boolean[V];
        list.add(0);
        dfs(0,adj,visited);
        return list;
    }
}
