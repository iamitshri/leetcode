class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc]==color)
            return image;
        
        helper(image, sr, sc, color, image[sr][sc]);
       return image; 
    }
    
   void helper(int[][] image, int sr, int sc, int color, int startingPixelColor){
        
        if(sr < 0 || sr > image.length-1 || sc < 0 || sc >= image[sr].length || image[sr][sc]!=startingPixelColor)
            return;
        
        image[sr][sc] = color;
        
       helper(image, sr+1, sc, color,startingPixelColor);
       helper(image, sr-1, sc, color,startingPixelColor);
       helper(image, sr, sc+1, color,startingPixelColor);
       helper(image, sr, sc-1, color,startingPixelColor);
    }
}