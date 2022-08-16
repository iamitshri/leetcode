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
        
        if(head==null)
            return head;
        
        ListNode fp = head;
        ListNode sp = head;
        // 1 2 3
        while(fp!=null){
            fp = fp.next;
            if(fp!=null){
                fp = fp.next;
                sp = sp.next;
            }
        }
        // 1  1 2  1 2 3 
        return sp;
    }
}