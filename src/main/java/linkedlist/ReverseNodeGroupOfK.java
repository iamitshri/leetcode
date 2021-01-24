package linkedlist;


import com.practice.linkedlist.ListNode;

public class ReverseNodeGroupOfK {

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int i=0;
        ListNode begin = dummy;
        while(head!=null){
            i++;
            if(i%k==0){
                begin = reverse(begin,head.next);
                head = begin.next;
            }else{
                head = head.next;
            }
        }

        return dummy.next;
    }

    ListNode reverse(ListNode begin, ListNode end){

        ListNode current = begin.next;
        ListNode first = current;
        ListNode prev = begin;
        while(current!=end){
            ListNode next = current.next;
            current.next=prev;
            prev = current;
            current = next;
        }
        begin.next = prev; // connect previous node to the newer head of ll
        first.next = current; // end of ll will point to next element
        return first;
    }
}
