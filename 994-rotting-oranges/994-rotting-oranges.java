class Solution {
    public int orangesRotting(int[][] grid) {
        
        LinkedList<int[]> queue = new LinkedList<>();
        int freshCount=0;
        for(int i=0; i < grid.length;i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j]==2){
                    
                    queue.add(new int[]{i,j});
                    
                }else if(grid[i][j]==1){
                    
                    freshCount++;
                    
                }
            }
        }
        int minutes=0;
        int [][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
        while(freshCount>0 && !queue.isEmpty()){
            minutes++;
            int size= queue.size();
            for(int i=0 ;i < size;i++){
                int [] p = queue.poll();
                for(int [] dir: dirs){
                    int x = p[0] + dir[0];
                    int y = p[1] + dir[1];
                    if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y]==0 || grid[x][y]==2) 
                    continue;
                    
                    
                        grid[x][y]=2;
                        queue.add(new int[]{x,y});
                        freshCount--;
                    
                }
            }
        }
        return freshCount==0? minutes : -1;
    }
}