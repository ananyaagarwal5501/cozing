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
    public ListNode sortList(ListNode head) 
    {
        ListNode temp= head;
        int c=0;
        if(head == null || head.next == null)
        {
            return head;
        }

        ArrayList<Integer> arr =  new ArrayList<>();

        while(temp!= null)
        {
            c++;
            arr.add(temp.val);
            temp= temp.next;

        }

        Collections.sort(arr);

        ListNode nhead = new ListNode(arr.get(0));
        ListNode mover= nhead;

        for(int i=1; i<c; i++)
        {
            ListNode ntemp= new ListNode(arr.get(i));
            mover.next= ntemp;
            mover= ntemp;
        }

        return nhead;
    }
}