class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if(s==null || t==null)
            return false;
        
        if(s.length()!=t.length())
            return false;
        
        char [] src = s.toCharArray();
        char [] dest = t.toCharArray();
        
        Map<Character,Character> map = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        // f o o 
        // b a r 
        
        for(int i=0;i < src.length;i++){
            if(!map.containsKey(src[i])){
                if(!visited.add(dest[i])){
                    return false;
                }
                map.put(src[i],dest[i]);
                src[i] = dest[i];
                
            }else{
                src[i] = map.get(src[i]);
            }
            
             if(src[i]!=dest[i])
                return false;
        }
        
        return true;
        
    }
}