/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if(p==null && q==null)
            return true;
        
        if(p==null || q==null)
            return false;
        
        // ArrayDeque does not allow null values
        ArrayDeque<TreeNode> ps = new ArrayDeque();
        ArrayDeque<TreeNode> qs = new ArrayDeque();
        ps.add(p);
        qs.add(q);
        
        while(!ps.isEmpty() && !qs.isEmpty()){
            TreeNode p1 = ps.poll();
            TreeNode q1 = qs.poll();
            
            if(check(p1,q1)){
                
                if(!check(p1.left,q1.left)){
                    return false;
                }
                if(p1.left!=null){
                    ps.add(p1.left);
                    qs.add(q1.left);
                }
                
                if(!check(p1.right,q1.right)){
                    return false;
                }
                if(p1.right!=null){
                    ps.add(p1.right);
                    qs.add(q1.right);
                }
            }else{
               return false; 
            }
        }
        return ps.isEmpty() && qs.isEmpty();
    }
    
    boolean check(TreeNode p, TreeNode q){
        
        if(p==null && q==null)
            return true;
        
        if(p==null || q==null)
            return false;
        
         return p.val==q.val;
    }
    
    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        
        if(p==null && q==null)
            return true;
        
        if(p==null || q==null)
            return false;
        
        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }
}