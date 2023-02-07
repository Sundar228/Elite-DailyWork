class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer>queue=new LinkedList<>();
        ArrayList<Integer>list=new ArrayList<>();
        boolean visited[]=new boolean[V];
        queue.offer(0);
        list.add(0);
        visited[0]=true;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            for(int neigh:adj.get(curr)){
                if(!visited[neigh]){
                    visited[neigh]=true;
                    list.add(neigh);
                    queue.offer(neigh);
                }
            }
        }
        return list;
    }
}
