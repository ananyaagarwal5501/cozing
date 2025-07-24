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

 //OPTIMAL APPROACH: TORTOISE AND HARE APPROACH[SLOW AND FAST PONITERS]
 class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow= head;
        ListNode fast= head;

        while(fast!= null && fast.next!= null)
        {
            slow= slow.next;
            fast= fast.next.next;
        }

        
    return slow;
    }
 }





/*
 //BRUTE FORCE: 2 BAAR TRAVERSAL, DONE
class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode temp= head;
        int count=0;

        while(temp!= null) //number of nodes aagye
        {
            count++;
            temp= temp.next;
        }

        int m= (count/2)+1;
        int c=0;
        temp= head;
        
            while(temp!=null)
            {
                m=m-1;
                if(m==0)
                {
                    break;
                }
                temp= temp.next;
            }
            return temp;
        }    
    }
    */
