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
    public TreeNode sortedArrayToBST(int[] nums) {
        
            
        int l = 0;
        int h = nums.length-1;
       return helper(nums,l,h);
        
    }
    // 0
    TreeNode helper(int [] nums, int l, int h){
        
        if(l >= nums.length || h >= nums.length)
            return null;
        
        if(l>h)
            return null;
        
        if(l==h)
            return  new TreeNode(nums[l]);
        
        int mid = (l + h)/2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = helper(nums,l,mid-1);
        t.right= helper(nums,mid+1,h);
        return t;
    }
}