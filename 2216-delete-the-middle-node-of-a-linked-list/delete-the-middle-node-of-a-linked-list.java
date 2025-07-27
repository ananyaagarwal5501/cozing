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
 /*
 //mine: by logic of traversal of fast and slow, removing slow'th element.  done
 //TC= 0(N/2+N) , SC= 0(1)
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
        }
        //removing the slow'th element
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
} //DONE
*/

//OPTIMAL: [As we see here, that we need the node before the slow ] Thus: Modifying the Hare and Tortoise: skip one traversal of slow.
class Solution {
    public ListNode deleteMiddle(ListNode head) 
    {
        ListNode fast= head;
        ListNode slow= head;
        ListNode res= null;
       
       
        if(head==null || head.next== null)
        {
            return res;
        }

        fast= fast.next.next; //SKIPPED ONE TRAVERSAL OF SLOW 
        
        while(fast!= null && fast.next!= null)
        {
            slow= slow.next;// agya-> element before the slow
            fast= fast.next.next; 
        }

        //now just link exchanging
        slow.next= slow.next.next;
       
    
    return head;
}
}

