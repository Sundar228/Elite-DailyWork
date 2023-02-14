import java.util.ArrayList;
import java.util.*;
public class Solution {
  public static boolean dfs(int source,List<List<Integer>>adjList,boolean[] visited,boolean[] predecessor){
    visited[source]=true;
    predecessor[source]=true;
    boolean result=false;
    for(int neigh:adjList.get(source)){
      if(predecessor[neigh] && visited[neigh]) return true;
      if(!visited[neigh]) result=result||dfs(neigh,adjList,visited,predecessor);
    }
    predecessor[source]=false;
    return result;
  }
  public static boolean detectCycleInDirectedGraph(int n, ArrayList < ArrayList < Integer >> edges) {
    // Write your code here.
    List<List<Integer>>adjList=new ArrayList<>();
    for(int i=0;i<=n;i++){
      adjList.add(new ArrayList<Integer>());
    }
    for(int i=0;i<edges.size();i++){
      adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
    }
    boolean visited[]=new boolean[n+1];
    boolean predecessor[]=new boolean[n+1];
    //return dfs(1,adjList,visited,predecessor);
    for(int i=1;i<=n;i++){
      if(!visited[i]){
        if(dfs(i,adjList,visited,predecessor)){
          return true;
        }
      }
    }
    return false;
  }
}
