class Solution {
     public void bfs(char[][] grid,int a,int b,boolean[][] visited){
        int rows=grid.length;
        int columns=grid[0].length;
        Queue<Pair>queue=new LinkedList<>();
        visited[a][b]=true;
        queue.offer(new Pair(a,b));
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
                    if(grid[nextrow][nextcol]=='1' && !visited[nextrow][nextcol]){
                        visited[nextrow][nextcol]=true;
                        queue.offer(new Pair(nextrow,nextcol));
                    }
                }
            }
        }
     }
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        int columns=grid[0].length;
        boolean[][] visited=new boolean[rows][columns];
        int islands=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    islands++;
                    bfs(grid,i,j,visited);
                }
            }
        }
        return islands;    
        }
}
