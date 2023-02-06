class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair>queue=new LinkedList<>();
        int rows=grid.length;
        int columns=grid[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]==2){
                    queue.offer(new Pair(i,j));
                }
            }
        }
        int time=0;
        int a=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            int offsetrow[]={-1,0,1,0};
            int offsetcol[]={0,1,0,-1};
            for(int i=0;i<size;i++){
                Pair curr=queue.poll();
                int r=(Integer)curr.getKey();
                int c=(Integer)curr.getValue();
                for(int j=0;j<4;j++){
                    int nextrow=r+offsetrow[j];
                    int nextcol=c+offsetcol[j];
                    if(nextrow<0 || nextcol<0 || nextrow>=rows || nextcol>=columns) continue;
                    if(grid[nextrow][nextcol]==1){
                        grid[nextrow][nextcol]=2;
                        queue.offer(new Pair(nextrow,nextcol));
                    }
                }
            }
            if(a==0) a++;
            else time++;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return time;
    }
}
