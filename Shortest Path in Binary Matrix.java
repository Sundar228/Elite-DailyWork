class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows=grid.length;
        Queue<Pair>queue=new LinkedList<>();
        HashMap<Pair,Integer>map=new HashMap<>();
        boolean visited[][]=new boolean[rows][rows];
        visited[0][0]=true;
        if(grid[0][0]!=0 || grid[rows-1][rows-1]!=0) return -1;
        queue.add(new Pair(0,0));
        map.put(new Pair(0,0),1);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pair curr=queue.poll();
                //System.out.println(map.get(curr));
                int r=(Integer)curr.getKey();
                int c=(Integer)curr.getValue();
                if(r==rows-1 && c==rows-1) break;
                //System.out.println(c);
                int offsetrow[]={-1,-1,0,1,1,1,0,-1};
                int offsetcol[]={0,1,1,1,0,-1,-1,-1};
                for(int j=0;j<8;j++){
                    int nextrow=r+offsetrow[j];
                    int nextcol=c+offsetcol[j];
                    if(nextrow<0 || nextcol<0 || nextrow>=rows || nextcol>=rows) continue;
                    if(grid[nextrow][nextcol]==0 && visited[nextrow][nextcol]==false){
                        visited[nextrow][nextcol]=true;
                        queue.offer(new Pair(nextrow,nextcol));
                        map.put(new Pair(nextrow,nextcol),map.get(curr)+1);
                    }
                }
            }
        }
        Pair p1 = new Pair(rows-1,rows-1);
        System.out.println(map.get(p1));
        if(map.get(p1)==null) return -1;
        int result=(Integer)map.get(p1);
        return result;
    }
}
