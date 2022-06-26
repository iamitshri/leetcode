class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
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