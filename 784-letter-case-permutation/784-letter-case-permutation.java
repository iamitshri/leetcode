class Solution {
    public List<String> letterCasePermutation(String s) {
        
        List<String> perms = new ArrayList<>();
        perms.add(s);
        
        for(int i =0;i< s.length();i++ ){
            if(Character.isLetter(s.charAt(i))){
                int size = perms.size();
                for(int j=0; j < size;j++){
                    char c [] = perms.get(j).toCharArray();
                    if(Character.isLowerCase(c[i])){
                        c[i] = Character.toUpperCase(c[i]);
                    }else{
                        c[i] = Character.toLowerCase(c[i]);
                    }
                    perms.add(new String(c));
                }
            }
        }
        
        return perms;
    }
}