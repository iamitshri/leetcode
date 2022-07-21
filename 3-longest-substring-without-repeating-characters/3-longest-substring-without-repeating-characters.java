class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int max=0;
        int windowStart=0;
        Set<Character> set = new HashSet<>();
        for(int windowEnd=0;windowEnd < s.length();windowEnd++){
            if(!set.add(s.charAt(windowEnd))){
                while(set.contains(s.charAt(windowEnd))){
                    set.remove(s.charAt(windowStart));    
                    windowStart++;
                }
                set.add(s.charAt(windowEnd));
            }
            max = Math.max(max, windowEnd-windowStart+1);
        }
        return max;
    }
}