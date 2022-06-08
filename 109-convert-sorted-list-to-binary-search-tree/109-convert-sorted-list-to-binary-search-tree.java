/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        
        return helper(head);
        
    }
    // 1
    TreeNode helper(ListNode head){
        
        if(head==null)
            return null;
        
        ListNode ll = middleNode(head);
        
        // cutting the linked list
        if(ll!=null && ll==head){
            head.next=null;
            return new TreeNode(ll.val);
        }
        
        if(ll!=null){ // cut the linkedlist
            ListNode temp = head;
            while(temp!=null && temp.next!=ll){
                temp=temp.next;
            }
            if(temp!=null && temp.next==ll)
                temp.next=null;
        }
        
        TreeNode node=null;
        if(ll!=null){
            ListNode next = ll.next;
            node = new TreeNode(ll.val);
            node.left =  helper(head);
            node.right = helper(next);
        }
        
        return node;
    }
    
    
    ListNode middleNode(ListNode head) {
        // 1 2 3 4 5 
        // 1 2
        if(head==null)
            return null;
        
        ListNode f = head;
        ListNode l = head;
         // 1 2
        while(f!=null){
            f = f.next;
            if(f!=null){
                f=f.next;
                l = l.next;
            }
        }
        
        
        return l;
    }
}