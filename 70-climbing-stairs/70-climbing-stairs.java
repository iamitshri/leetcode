class Solution {
    
    Map<Integer,Integer> map = new HashMap<>();
    
    public int climbStairs(int n) {
        
        int [] ways = new int[n+1];
        ways[0]=1;
        ways[1]=1;
        for(int i=2;i< (n+1);i++){
            
            ways[i] = ways[i-1] + ways[i-2];
        }
        return ways[n];
    }
    
    
    public int climbStairs2(int n) {
        
        if(n==0)
            return 1;
        
        if(n==1)
            return 1; 
        
        if(!map.containsKey(n))
            map.put(n,climbStairs(n-1) + climbStairs(n-2));
        
        return map.get(n);
    }
}