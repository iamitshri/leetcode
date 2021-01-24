package com.practice.linkedlist;

import ListNode;

public class AddNumber {

    public ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode runner = dummy;

        int sum=0;

        while(l1!=null || l2!=null){

            sum/=10;

            if(l1!=null){
                sum+= l1.val;
                l1=l1.next;
            }

            if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }

            runner.next = new ListNode(sum%10);
            runner=runner.next;
        }

        if(sum/10==1){
            runner.next=new ListNode(sum/10);
        }

        return dummy.next;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result=null;
        ListNode ret=null;
        int carry=0;

        while(l1!=null && l2!=null){

            int s = l1.val + l2.val+ carry;
            int sum = s%10;
            carry = s/10;

            ListNode n = new ListNode(sum);

            if(result!=null){
                result.next = n;
                result = result.next;
            }
            else{
                result=n;
                ret=n;
            }


            l1 = l1.next;
            l2=  l2.next;
        }

        while(l1!=null){

            int s =l1.val+carry;
            int sum = s%10;
            carry = s/10;
            ListNode n = new ListNode(sum);

            if(result!=null){
                result.next = n;
                result = result.next;
            }else{
                result=n;
                ret=result;
            }

            l1 = l1.next;
        }

        while(l2!=null){

            int s =l2.val+carry;
            int sum = s%10;
            carry = s/10;
            ListNode n = new ListNode(sum);

            if(result!=null){
                result.next = n;
                result = result.next;
            } else{
                result=n;
                ret=result;
            }


            l2 = l2.next;
        }

        if(carry!=0){
            ListNode n = new ListNode(carry);
            if(result!=null){
                result.next = n;
                result = result.next;
            } else{
                result=n;
                ret=result;
            }
        }
        return ret;
    }
}
