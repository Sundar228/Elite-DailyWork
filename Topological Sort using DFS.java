import java.util.* ;
import java.io.*; 
public class Solution 
{
    static Stack<Integer>stack=new Stack<>();
    public static void dfs(int source,List<List<Integer>>adjList,boolean[] visited){
        visited[source]=true;
        for(int neigh:adjList.get(source)){
            if(!visited[neigh]) dfs(neigh,adjList,visited);
        }
        stack.push(source);
    }
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, int v, int e) 
    {
        // Write your code here
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<v;i++){
        adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<edges.size();i++){
        adjList.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]) dfs(i,adjList,visited);
        }
        ArrayList<Integer>list=new ArrayList<>();
        while(!stack.isEmpty()){
            int a=stack.pop();
            list.add(a);
        }
        return list;
    }
}
