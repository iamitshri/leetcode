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
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if(list1==null && list2==null)
            return null;
        
        if(list1==null)
            return list2;
        
        if(list2==null)
            return list1;
        
        
        
        ListNode resultHead=null;
        ListNode result=null;
        while(list1!=null && list2!=null){
            if( list1.val <= list2.val){
                if(result==null){
                    result = resultHead = list1;
                }else{
                    result.next = list1;    
                    result = list1;
                }
                list1 = list1.next;
            }else{
                if(result==null){
                    result = resultHead = list2;
                }else{
                    result.next= list2;
                    result=list2;
                }
                list2 = list2.next;
            }
        }
        
        while(list1==null && list2!=null){
               if(result==null){
                    result = resultHead = list2;
               }else 
                    result.next= list2;
                   
                result=list2;
                list2 = list2.next;
        }
        
        while(list2==null && list1!=null){
            if(result==null){
                result = resultHead = list1;
            }else 
                 result.next= list1;
                  
            result=list1;
            list1 = list1.next;
        }
        
        return resultHead;
        
    }
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        
        if(list1==null && list2==null)
            return null;
        
        if(list1==null)
            return list2;
        
        if(list2==null)
            return list1;
        
        
        if( list1.val <= list2.val){
            list1.next = mergeTwoLists(list1.next,list2);
            return list1;
        }
            // list2.val
            
            list2.next = mergeTwoLists(list1,list2.next);
            return list2;
    
    }
}