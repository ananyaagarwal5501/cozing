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
    public ListNode oddEvenList(ListNode head) 
    {
        ListNode odd= head;
        

        if(head== null || head.next== null)
        {
            return head;
        }

        ListNode even= head.next;
        ListNode evenHead= head.next;
        while(even!= null && even.next!= null)
        {
            odd.next= odd.next.next;
            even.next= even.next.next;

            odd= odd.next;
            even= even.next;
        }

        odd.next= evenHead;
    
    return head;
 }
 }






        /*ya toh, even walon ko stack meh then odd walon ko then lifo
        class Solution {
    public ListNode oddEvenList(ListNode head) 
    {
        Stack<Integer> s = new Stack<>();
         ListNode temp= head;
         ListNode result= null;
         int c=0;

         while(temp!= null)
         {
            s.push(temp.val);
            temp=temp.next.next; //odd gye andar
         }

         temp= head.next;//at index 2
         while(temp!= null && temp.next!= null)
         {
           
                s.push(temp.val);     
            temp= temp.next.next;

         }

         
         

         while(!s.isEmpty())
         {
            result.val= s.pop();
         }

         return result;
    }
        }
        */