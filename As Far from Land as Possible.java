class Solution {
    public int maxDistance(int[][] grid) {
         int rows=grid.length;
        Queue<Pair>queue=new LinkedList<>();
        //HashMap<Pair,Integer>map=new HashMap<>();
        boolean visited[][]=new boolean[rows][rows];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]!=0){
                    queue.add(new Pair(i,j));
                }
            }
        }
        int result=0;
        while(!queue.isEmpty()){
            result=result+1;
            int size=queue.size();
            for(int i=0;i<size;i++){
                Pair curr=queue.poll();
                //System.out.println(map.get(curr));
                int r=(Integer)curr.getKey();
                int c=(Integer)curr.getValue();
                //System.out.println(c);
                int offsetrow[]={-1,0,1,0};
                int offsetcol[]={0,1,0,-1};
                for(int j=0;j<4;j++){
                    int nextrow=r+offsetrow[j];
                    int nextcol=c+offsetcol[j];
                    if(nextrow<0 || nextcol<0 || nextrow>=rows || nextcol>=rows) continue;
                    if(grid[nextrow][nextcol]>0) continue;
                    grid[nextrow][nextcol]=2;
                    queue.offer(new Pair(nextrow,nextcol));
                    }
                }
            }
            if(result-1==0) return -1;
        return result-1;
    }
}
