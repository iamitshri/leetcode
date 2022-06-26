class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            
            int [] arr = new int[26];
            for(char c: s.toCharArray()){
                arr[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i =0 ; i < 26;i++){
                sb.append('$');
                sb.append(arr[i]);
            }
            String n = sb.toString();
            var list = map.getOrDefault(n,new ArrayList<String>());
            list.add(s);
            map.put(n,list);           
        }
        // List<List<String>> result = new ArrayList<>();
        // for(String s : map.keySet()){
        //     result.add(map.get(s));
        // }
        return new ArrayList(map.values());
    }
    
    public List<List<String>> groupAnagrams1(String[] strs) {
        
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char [] arr = s.toCharArray();
            Arrays.sort(arr);
            String n = new String(arr);
            var list = map.getOrDefault(n,new ArrayList<String>());
            list.add(s);
            map.put(n,list);           
        }
        // List<List<String>> result = new ArrayList<>();
        // for(String s : map.keySet()){
        //     result.add(map.get(s));
        // }
        return new ArrayList(map.values());
    }
}