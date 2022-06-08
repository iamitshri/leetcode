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
    public List<Integer> getLonelyNodes(TreeNode root) {
        
        helper(root);
        return list;
    }
    
    List<Integer> list = new ArrayList<>();
    
    void helper(TreeNode root){
        
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right!=null)
            list.add(root.right.val);
        else if(root.right==null && root.left!=null)
            list.add(root.left.val);
        
        helper(root.left);
        helper(root.right);
    }
}