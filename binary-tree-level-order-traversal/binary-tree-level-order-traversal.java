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
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> lists = new ArrayList<>();
        if(root==null)
            return lists;
       
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode r = q.poll();
                list.add(r.val);
                if(r.left!=null)
                    q.offer(r.left);
                if(r.right!=null)
                    q.offer(r.right);
            }
            lists.add(list);
        }
        return lists;
    }
}