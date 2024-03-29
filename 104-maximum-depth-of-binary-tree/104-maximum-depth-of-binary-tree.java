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
    
    public int maxDepth(TreeNode root) {
            if(root==null)
                return 0;
        
          return 1 + Math.max( maxDepth(root.left), maxDepth(root.right));
     }
    
    public int maxDepth2(TreeNode root) {
        if(root==null)
            return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i < size; i++){
                TreeNode node = queue.poll();
                
                 if(node.left!=null)
                     queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
             level++;
        }
        
        return level;
    }
}