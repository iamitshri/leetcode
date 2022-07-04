class Solution {
    public int lengthOfLongestSubstring(String str) {
        int max=0;
        int windowStart=0;
        Set<Character> set = new HashSet<>();
        for(int windowEnd=0; windowEnd < str.length();windowEnd++) {
            while(set.contains(str.charAt(windowEnd))){
              set.remove(str.charAt(windowStart));
              windowStart++;
            }
          set.add(str.charAt(windowEnd));
          max = Math.max(max, windowEnd-windowStart + 1);
        }
        return max;
  }
}