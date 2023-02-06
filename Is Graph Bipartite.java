class Solution {
    public boolean bfs(int[][] graph, int source,Queue<Integer> queue){
        int[] arr = new int[graph.length];
        queue.offer(source);
        arr[source]=1;
        while(!queue.isEmpty()){
            int curr= queue.poll();
            for(int i=0;i<graph[curr].length;i++){
                if(arr[curr]==arr[graph[curr][i]]){
                    return false;
                }else if(arr[graph[curr][i]]==0){
                    arr[graph[curr][i]]=0-arr[curr];
                    queue.offer(graph[curr][i]);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> queue= new LinkedList<>();
        for(int i=0;i<graph.length;i++){
            if(bfs(graph,i,queue)==false){
                return false;
            }
        }
        return true;
    }
}
