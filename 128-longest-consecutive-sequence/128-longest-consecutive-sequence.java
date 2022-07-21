class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        
        for(int n : nums)
            set.add(n);
        
        int maxCnt=0;
        for(int n : nums){
            if(set.contains(n-1))
                continue;
            int temp=n;
            while(set.contains(temp)){
                temp+=1;
            }
            maxCnt = Math.max(maxCnt,(temp-n));
        }
        return maxCnt;
    }
}