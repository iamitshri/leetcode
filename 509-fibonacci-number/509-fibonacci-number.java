class Solution {
    public int fib(int n) {
        if(n <=0)
            return 0;
        if(n==1)
            return 1;
        
      int oneBack=1;
      int twoBack=0;
        
        
        // 0 1 2 3 
        for(int i=1;i < n;i++){
            int t = oneBack+twoBack;
            twoBack = oneBack;
            oneBack=t;
        }
        return oneBack;
    }
    
     public int fib2(int n) {
        if(n <=0)
            return 0;
        if(n==1)
            return 1;
        
        int fib[] = new int[n+1];
        fib[0]=0;
        fib[1]=1;
        fib[2]=1;
        
        for(int i=3;i <= n;i++){
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n];
    }
}