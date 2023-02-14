import java.util.*;
public class Solution { 
    public static boolean dfs(int source,int parent,List<List<Integer>>adjList,boolean[] visited){
        visited[source]=true;
        boolean result=false;
        for(int neigh:adjList.get(source)){
            if(visited[neigh] && neigh!=parent) return true;
            if(!visited[neigh]){
                result=result||dfs(neigh,source,adjList,visited);
            }
        }
        return result;
    }
    public static String cycleDetection(int[][] edges, int n, int m) {
        // Write your code here.
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.length;i++){
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }
        boolean visited[]=new boolean[n+1];
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                boolean a=dfs(i,-1,adjList,visited);
                if(a) return "Yes";
            }
        }
         return "No";
        
    }
    
}
