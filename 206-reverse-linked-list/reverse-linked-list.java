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
 //brute: by stack memory lifo, done
class Solution {
    public ListNode reverseList(ListNode head)
     {
    ListNode temp= head;
    Stack<Integer> stack = new Stack<>();

    while(temp!= null)
    {
        stack.push(temp.val);
        temp= temp.next;
    }// stack filled
    
    temp= head;
    //fetching from stack and replacing the elements of the LL
    while(temp!= null)
    {
        temp.val= stack.pop();
        temp= temp.next;
    }
        return head;
    }
}*/

//optimal: reversal of link of node [cannot use an external data structure]
   class Solution {
    public ListNode reverseList(ListNode head)
     {
    ListNode temp= head;
    ListNode prev= null;
    

    while(temp!= null)
    {
       ListNode front= temp.next;
        temp.next= prev;

        prev= temp;
        temp= front;
    }

    return prev;
     }
   }

