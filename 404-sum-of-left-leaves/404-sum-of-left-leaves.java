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
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root);
    }
    
    int helper(TreeNode root){
        if(root==null)
            return 0;
        
        int l = helper(root.left);
        int r = helper(root.right);
        
        if(root.left!=null && root.left.left==null && root.left.right==null){
            return root.left.val + r ;
        }
        
        return l + r ;
    }
}