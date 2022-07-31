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
    int result = 0;
    int k=0;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        helper(root);
        return result;
    }
    
    void helper(TreeNode root ){
        
        if(root==null)
            return;
        if(k<1)
            return;
       helper(root.left);
        if(k==1 ){
            result = root.val;
        }
        k=k-1;
        helper(root.right);
    }
    
}