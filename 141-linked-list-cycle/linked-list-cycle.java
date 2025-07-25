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
/*public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast= head;
        int c=0;//zero indexed

        boolean result= true;
        //edge case
        if(head== null || head.next== null)
        {
            if(slow.next == slow)
            {
                return true;
            }
            return false;
        }

        while(fast.next!= slow )
       {
        slow= slow.next;
        fast= fast.next.next;
       
       return true;
       }
       return false;
    }
}*/

public class Solution {
    public boolean hasCycle(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast= head;

        while(fast!= null && fast.next!= null)
        {
            slow= slow.next;
            fast= fast.next.next;

            if(fast == slow)
            {
                return true;
            }
            
        }
        return false;
    }
}