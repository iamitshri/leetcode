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
class Solution {
    public ListNode middleNode(ListNode head) {
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