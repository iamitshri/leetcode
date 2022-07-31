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
    boolean found=false;
    int k=0;
    public int kthSmallest(TreeNode root, int k) {
        this.k=k;
        helper(root);
        return result;
    }
    
    void helper(TreeNode root ){
        
        if(root==null)
            return;
        if(found)
            return;
       
       
        helper(root.left);
         
        if(k==1 && !found){
            result = root.val;
            found=true;
        }
        
        k=k-1;
        helper(root.right);
    }
    
}