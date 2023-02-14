class Solution {
    public boolean dfs(int a,int b,int parx,int pary,char[][] grid,boolean[][] visited,int rows,int columns){
        visited[a][b]=true;
        int offsetrow[]={-1,0,1,0};
        int offsetcol[]={0,1,0,-1};
        boolean result=false;
        for(int i=0;i<4;i++){
            int nextrow=a+offsetrow[i];
            int nextcol=b+offsetcol[i];
            if(nextrow<0 || nextcol<0 || nextrow>=rows || nextcol>=columns) continue;
            if(grid[a][b]==grid[nextrow][nextcol]){
                if(nextrow!=parx || nextcol!=pary){
                        if(visited[nextrow][nextcol]) return true;
                        else result=result||dfs(nextrow,nextcol,a,b,grid,visited,rows,columns);
                    }
            }
        }
        return result;
    }
    public boolean containsCycle(char[][] grid) {
        int rows=grid.length;
        int columns=grid[0].length;
        boolean result=false;
        boolean[][] visited=new boolean[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                if(!visited[i][j]){
                    result=result||dfs(i,j,-1,-1,grid,visited,rows,columns); 
                }
            }
        }
        return result;
    }
}
