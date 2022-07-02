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
    public ListNode reverseKGroup(ListNode head, int k) {
        //  know items in the list 
        
        // stop reverse when less than k 
        // 1 2 3 4 5 6 7 8 9
        ListNode current = head; 
        ListNode previous = null; 
        while(current !=null ){
            // save the head of the current sublist
            ListNode lastNodeOfSubList = current;
            
            ListNode lastNodeOfPrevList = previous;  // 3 2 1->6 5 4->7 8 9
            
            ListNode runner = current; int cnt=0;
            while(cnt < k && runner != null){
                runner = runner.next;
                cnt++;
            }
            if(cnt < k)
                break;
            
            ListNode next=null;
            for(int i=0; i < k && current!=null; i++){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            
            // connect to next
            lastNodeOfSubList.next = current;
            
            // connect to prev
            if(lastNodeOfPrevList!=null){
                lastNodeOfPrevList.next = previous;
            }else{
                head = previous;
            }
            
            // update previous
            previous = lastNodeOfSubList;
        }
        
        return head;
        
    }
}