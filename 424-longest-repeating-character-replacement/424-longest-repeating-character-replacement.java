class Solution {
    public int characterReplacement(String str, int k) {
 
            // longest substring with repeating char, its ok to have k non-repeating chars in the total len 
            int max=0;
            int windowStart=0;
            int longest=0;
            Map<Character,Integer> map = new HashMap<>();
            for(int windowEnd=0;windowEnd < str.length();windowEnd++){
              // update count and max
              char c = str.charAt(windowEnd);
              map.put(c,map.getOrDefault(c,0)+1);
              max = Math.max(max,map.get(c));
              // windiw = k + maxCount;
              // window - maxCount = k 
              if(((windowEnd-windowStart+1) - max) > k){
                char s = str.charAt(windowStart);
                map.put(s,map.get(s)-1);
                if(map.get(s)==0){
                  map.remove(s);
                }
                // update max
                for(Character c1 : map.keySet()){
                  max = Math.max(max,map.get(c1));
                }
                windowStart++;
              }
              longest = Math.max(longest, windowEnd-windowStart+1);
            }
            return longest;
    }
}