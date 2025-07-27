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
    public ListNode deleteMiddle(ListNode head) 
    {
        ListNode fast= head;
        ListNode slow= head;
        ListNode prev= null;
        ListNode temp= head;


        if(head==null || head.next== null)
        {
            return prev;
        }

        while(fast!= null && fast.next!= null)
        {
            slow= slow.next;// agya element to be removed in slow
            fast= fast.next.next;
            //prev= prev.next;
        }

            //prev.next= slow.next;
            //prev= slow.next;
        
        while( temp!= null)
        {
           
            if(temp.next== slow)
            {
                temp.next= temp.next.next;
                break;

            }
            
                temp=temp.next;

        }
        return head;



        
    }
}