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
    public ListNode reverseList(ListNode head) {
       
        // 3- 1 - 2 - null
         
        if(head==null)
            return null;
        
        if(head.next==null)
            return head;
        
        ListNode rev = reverseList(head.next);
        
        head.next.next=head;
        head.next=null;
        
        return rev;
        
        
    }
    
    public ListNode reverseList2(ListNode head) {
        
        ListNode temp=null;
        ListNode rev=null;
        while(head!=null){
            temp = head.next;
            
            head.next= rev;
            rev=head;
            
            head=temp;
        }
        
        return rev;
    }
}