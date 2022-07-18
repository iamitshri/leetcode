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
    int longest=0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null || (root.left==null && root.right==null))
            return 0;
       helper(root);
        return longest;
    }
    
    int helper(TreeNode root){
         
        if(root==null)
            return 0;
            
        
        int left = helper(root.left);
        
        int right = helper(root.right);
        
        if(left==0 && right >0)
            longest = Math.max(longest, right);
        else if(right==0 && left >0)
            longest = Math.max(longest, left);
        else if(left != 0 && right!=0)
            longest = Math.max(longest, left+right);
        
        
        return  1 + (left > right ? left : right);
    }
}