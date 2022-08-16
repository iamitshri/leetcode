/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode tortoise = head;
        ListNode hare = head; 
        boolean found=false;
        while(hare!=null){
        
            hare=hare.next;
            
            if(hare!=null){
                tortoise = tortoise.next;    
                hare=hare.next;
            }
            if(tortoise==hare){
                found=true;
                break;
            }
        }
        
        if(!found){
            return null;
        }
        
        ListNode ptr1 = tortoise;
        
        ListNode ptr2 = head; 
        
        while(ptr1!=ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        
        return ptr1;
    }
}