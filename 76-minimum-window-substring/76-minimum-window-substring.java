class Solution {
    public String minWindow(String s, String t) {
        
        if(t.length() > s.length()) return "";
        
        // pattern map ready 
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        
        String result = "";
        // create a loop to iterate over chars in s 
        int windowStart=0;
        int min=Integer.MAX_VALUE;
        int minS=0;
        int minE=0;
        // distinct keys in map
        int cnt = map.size();
        for(int windowEnd=0; windowEnd < s.length();windowEnd++){
            
            char rightChar = s.charAt(windowEnd);
            if(map.containsKey(rightChar)){
                map.put(rightChar,map.get(rightChar)-1);
                if(map.get(rightChar)==0)
                    cnt--;
            }
            
            while(cnt==0){
                char leftChar = s.charAt(windowStart);
                if(map.containsKey(leftChar)){
                    if(map.get(leftChar)==0)
                        cnt++;
                    map.put(leftChar,map.get(leftChar)+1);
                }
                if((windowEnd-windowStart+1) < min ){
                    min = windowEnd-windowStart+1;
                    minS = windowStart;
                    minE = windowEnd;
                     
                }
                windowStart++;
            }
            
            
        }
        return min < Integer.MAX_VALUE? s.substring(minS,minE+1) : "";
        
    }
}