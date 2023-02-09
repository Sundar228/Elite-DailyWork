class Solution {
    int max=0;
    public void bfs(int headID,List<List<Integer>>adjList,int[] informTime){
        Queue<Pair>queue=new LinkedList<>();
        queue.add(new Pair(0,headID));
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pair curr=queue.poll();
                int dis=(Integer)curr.getKey();
                int des=(Integer)curr.getValue();
                for(int neigh:adjList.get(des)){
                    queue.add(new Pair(dis+informTime[des],neigh));
                    if(dis+informTime[des]>max){
                        max=dis+informTime[des];
                    }

                }
            }
        }
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>>adjList=new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            if(i!=headID) adjList.get(manager[i]).add(i); // adding employees for particular manager
        }
        for(int i=0;i<n;i++) System.out.println(adjList.get(i));
        bfs(headID,adjList,informTime);
        return max;
    }
}
