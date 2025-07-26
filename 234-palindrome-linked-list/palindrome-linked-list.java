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
 
//OPTIMAL= TORTOISE AND HARE
/*
step 1. middle elements
step 2 rev the second half
step 3 compare through pointers
step 4 rev the reversed half and return  */
class Solution {
    public boolean isPalindrome(ListNode head) 
    {
        //EDGE CASES
        if(head == null || head.next== null)
        {
            return true;//single node is palindrome by defult
        }
       // step 1. middle elements
       ListNode slow= head;
       ListNode fast= head;

       while(fast.next!= null && fast.next.next != null)
       {
        slow= slow.next;
        fast= fast.next.next;
       }

       //step 2. reverse the second half and make a newHead
       ListNode newHead= reverse(slow.next);

       //step 3. compare through pointers
       ListNode first= head;
       ListNode second= newHead;

       while(second!= null)
       {
        if(first.val != second.val)
        {
            reverse(newHead);
            return false;
        }
        second= second.next;
        first= first.next;

       }

       //step 4. again correct the format of the given list

       reverse(newHead);
       return true;     
    }


    private static ListNode reverse(ListNode node)
    {
        ListNode prev= null;
        ListNode current= node;

        while(current!= null)
        {
        ListNode front= current.next;
        current.next= prev;

        prev= current;
        current= front;
        }

        return prev;
    }


}