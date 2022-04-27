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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
       
        TreeNode node = root;
        while(node!=null){
             
            while(node!=null){
                stack.push(node);
                node = node.left;
            }
            
            node = stack.pop();
            
            list.add(node.val);
            
            if(node.right==null){
                
                while(node.right==null){
                   
                    if(stack.isEmpty()){
                        break;
                    }
                     node = stack.pop();
                     list.add(node.val);
                } 
                if(node!=null)
                    node = node.right;
            }else{
                node = node.right;
            }
            
        }
        return list;
    }
}