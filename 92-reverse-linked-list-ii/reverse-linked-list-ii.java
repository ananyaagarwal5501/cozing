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
    public ListNode reverseBetween(ListNode head, int left, int right) 
    {
        ListNode temp= head;
       Stack<Integer> s = new Stack<>();
        int c=1;//started from c=1

        while(temp!= null)
        {

            if(c>=left && c<= right)
            {
                s.push(temp.val);
            }
             c++;//update after operation
            temp=temp.next;
           
        }

        temp= head;
        int p=1;
        while(temp!= null)
        {
            
            if(p>= left && p<=right)
            //if(c>= (c- right+1) && c<= (c-left+1))
            {
                temp.val= s.pop();
            }
            p++; //update after operation
            temp= temp.next;
        }

        return head;

    }
}