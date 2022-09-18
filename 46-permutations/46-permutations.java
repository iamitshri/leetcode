class Solution {
    List<List<Integer>> res = new ArrayList<>();
    boolean [] used ;
     
   public List<List<Integer>> permute(int[] nums) {
        
       LinkedList<List<Integer>> perms = new LinkedList<>();
       perms.add(new ArrayList<>());
       
       for(int n : nums){
           
           int size = perms.size();
           for(int j=0; j < size;j++){
               List<Integer> oldPerm = perms.poll();

               for(int i=0; i <= oldPerm.size();i++){
                   List<Integer> t = new ArrayList<>(oldPerm);
                    t.add(i,n);

                   if(t.size()==nums.length)
                       res.add(t);
                   else
                       perms.add(t);
                   }
             }
       }
       
       return res;
    }
    
    
    public List<List<Integer>> permute2(int[] nums) {
        used = new boolean[nums.length];
        helper(nums,new ArrayList<>(),used);
        return res;
    }
    
    void helper(int[] nums, List<Integer> list, boolean[] used){
        if(list.size()== nums.length){
            res.add(new ArrayList<>(list));
         }
        
        for(int i= 0; i < nums.length;i++){
            if(used[i]) continue;
            
            used[i]=true;
            list.add(nums[i]);
            helper(nums,list,used);
            used[i]=false;
            list.remove(list.size()-1);
        }
    }
}