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
    int goodNodes=0;
    public int goodNodes(TreeNode root) {
         
         int max=root.val;
        
        helper(max,root);
            
          return goodNodes;
    }
    
    void helper(int max, TreeNode root){
        
        if(root==null)
            return;
        
        if(root.val >= max)
            goodNodes++;
        
        max=Math.max(root.val,max);
        helper(max,root.left);
        helper(max,root.right);
    }
}