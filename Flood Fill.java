class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int rows=image.length;
        int columns=image[0].length;
        Queue<Pair>queue=new LinkedList<>();
        if(image[sr][sc]==color){
            return image;
        }
        int startingpixel=image[sr][sc];
        image[sr][sc]=color;
        queue.offer(new Pair(sr,sc));
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
                    if(image[nextrow][nextcol]==startingpixel && image[nextrow][nextcol]!=color){
                        image[nextrow][nextcol]=color;
                        queue.offer(new Pair(nextrow,nextcol));
                    }
                }
            }
        }
        return image;
    }
}
