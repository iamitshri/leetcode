class Solution {
    
    Map<Integer,Integer> map = new HashMap<>();
    
    public int climbStairs(int n) {
        
        if(n==0)
            return 1;
        
        if(n==1)
            return 1; 
        
        if(!map.containsKey(n))
            map.put(n,climbStairs(n-1) + climbStairs(n-2));
        
        return map.get(n);
    }
}