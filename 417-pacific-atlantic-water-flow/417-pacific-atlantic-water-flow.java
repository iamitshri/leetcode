class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        Set<Integer> pac = new HashSet<>();
        Set<Integer> atl = new HashSet<>();
        
        for(int i=0;i<cols;i++){
            dfs(heights,0,i,heights[0][i],pac);    
            dfs(heights,rows-1,i,heights[rows-1][i],atl);    
        }
        
        for(int i=0;i<rows;i++){
            dfs(heights,i,0,heights[i][0],pac);    
            dfs(heights,i,cols-1,heights[i][cols-1],atl);    
        }
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int current = cols * i + j;
                if(pac.contains(current) && atl.contains(current)){
                    result.add(List.of(i,j));
                }
                    
            }
        }
        return result;
    }
    
    
    void dfs(int [][] heights, int r, int c, int prevHeight, Set<Integer> visited){
        
        int rows = heights.length;
        int cols = heights[0].length;
        int current = (r * cols) + c;
        if(visited.contains(current) || r < 0 || r > heights.length-1 || c < 0 || c > heights[0].length-1 || prevHeight > heights[r][c])
            return;
        visited.add(current);
        dfs(heights,r+1,c,heights[r][c],visited);
        dfs(heights,r-1,c,heights[r][c],visited);
        dfs(heights,r,c+1,heights[r][c],visited);
        dfs(heights,r,c-1,heights[r][c],visited);
    }
}