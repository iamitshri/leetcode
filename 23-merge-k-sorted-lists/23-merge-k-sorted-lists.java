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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists==null || lists.length==0)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1,n2) -> Integer.compare(n1.val,n2.val));
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        ListNode result=null,tail=null;   
        while(!pq.isEmpty()){
            ListNode ln = pq.poll();
            ListNode t = ln.next;
            
            if(tail==null){
                result =ln;
                tail=ln;
            }else{
                tail.next = ln;
                tail = ln;
            }

            if(t!=null)
                pq.offer(t);
        }
        
        return result;
    }
}