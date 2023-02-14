import java.util.*;
public class Solution { 
    public static boolean bfs(int source,List<List<Integer>>adjList,boolean[] visited){
        visited[source]=true;
        //boolean result=false;
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(source,-1));
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pair curr=queue.poll();
                int s=curr.sce;
                int p=curr.parent;
                for(int neigh:adjList.get(s)){
                    if(visited[neigh] && neigh!=p) return true;
                    if(!visited[neigh]){
                        visited[neigh]=true;
                        queue.add(new Pair(neigh,s));
                    }
                }
            }
        }
        return false;
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
                boolean a=bfs(i,adjList,visited);
                if(a) return "Yes";
            }
        }
         return "No";
        
    }
    
}
class Pair{
    int sce,parent;
    Pair(int sce,int parent){
        this.sce=sce;
        this.parent=parent;
    }
}
