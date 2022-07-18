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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
            if(root==null && subRoot==null)
            return true;
        
         if(root==null || subRoot==null)
            return false;
        
         return (root.val==subRoot.val && isSame(root,subRoot))
             || isSubtree(root.left,subRoot)
             || isSubtree(root.right,subRoot);
        
    }
    
    boolean isSame(TreeNode root, TreeNode subRoot){
        if(root==null && subRoot==null)
            return true;
        
        if(root==null || subRoot==null)
            return false;
        
        return root.val==subRoot.val && isSame(root.left,subRoot.left) && isSame(root.right,subRoot.right);
    }
}