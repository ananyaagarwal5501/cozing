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
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode temp= head;
        int c=0;
        ListNode prev= head;

        if(head== null || head.next== null)
        {
            return null;
        }

        while(temp!= null)
        {
            c++;
            temp=temp.next;
        }
        
        int l=0;
        temp=head;
        while( temp!= null)
        {
            l++;
            if(l== (c-n+1))
            {
                if(l==1)
                {
                    return temp.next;
                }
                prev.next= temp.next;
                break;

            }

            

            prev= temp;
            temp= temp.next;

        }

        return head;
    }
}