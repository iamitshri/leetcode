/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    Robot robot;
    public void cleanRoom(Robot robot) {
        
        // our convention is to move right always in up, right, down and left direction
        this.robot = robot;
        visited.add(0+"-"+0);
        backtrack(0,0,0);
    }
    
    Set<String> visited = new HashSet<>();
    void goBack(){
        this.robot.turnRight(); // start turning 
        this.robot.turnRight(); // turn to go back one step
        this.robot.move(); // move one step 
        this.robot.turnRight(); // start facing same direction again
        this.robot.turnRight(); // face in same direction as before
    }
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    
   void backtrack(int x, int y, int d){
        
        robot.clean(); // clean the current spot
        for(int i=0;i<4;i++){
            int newD = (d + i)%4;
            int x1 = x + dirs[newD][0];
            int y1 = y + dirs[newD][1];
            if(!visited.contains(x1+"-"+y1) && robot.move()){
                visited.add(x1+"-"+y1);
                backtrack(x1,y1,newD);
                goBack();
            }
            this.robot.turnRight(); // turnRight
        }    
    }
}