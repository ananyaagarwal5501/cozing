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
        int n1=0;
        ListNode t= head;

        if(head == null || head.next == null)
        {
            return null;
        }
        
        while(t!= null)
        {
            n1++;
            t= t.next;
        }

        t= head;
        ListNode prev= null;
        int d= n1/2;

        for(int i=0; i<d-1; i++)
        {
            t= t.next;
        }

        t.next= t.next.next;
        return head;
    }
}