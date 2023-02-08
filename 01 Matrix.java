class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length;
        int columns=mat[0].length;
        Queue<Node>queue=new LinkedList<>();
        boolean visited[][]=new boolean[rows][columns];
        int result[][]=new int[rows][columns];
        for(int i = 0;i<rows;i++) {
	        for(int j = 0;j<columns;j++) {
	            if(mat[i][j] == 0) {
	                queue.add(new Node(i, j, 0)); 
	                visited[i][j] =true; 
	            }
	            else {
	                visited[i][j] =false; 
	            }
	        }
	    }
        while(!queue.isEmpty()){

                int r= queue.peek().first; 
	            int c= queue.peek().second; 
	            int steps = queue.peek().third; 
                queue.remove(); 
	            result[r][c] =steps; 
                int offsetrow[]={-1,0,1,0};
                int offsetcol[]={0,1,0,-1};
                for(int j=0;j<4;j++){
                    int nextrow=r+offsetrow[j];
                    int nextcol=c+offsetcol[j];
                    if(nextrow<0 || nextcol<0 || nextrow>=rows || nextcol>=columns) continue;
                    if(visited[nextrow][nextcol]==false){
                        visited[nextrow][nextcol]=true;
                        queue.offer(new Node(nextrow, nextcol, steps+1));
                    }
                    
                }
            }
        return result;
    }
}
class Node {
    int first;
    int second;
    int third; 
    Node(int _first, int _second, int _third) {
        this.first = _first; 
        this.second = _second; 
        this.third = _third; 
    }
}
