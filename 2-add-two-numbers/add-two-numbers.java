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
 //no brute or optimal, as we have to create a new list to store the final nodes
 //THUS, BY DUMMY NODE APPROACH
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode t1= l1;
        ListNode t2= l2;
        int carry =0;
        ListNode dummyNode= new ListNode(-1);
        ListNode current= dummyNode;//current is the temprory var for the dummynode

        while(t1!= null || t2!= null)
        {
            int sum= carry;

            if(t1!= null)
            {
                sum= sum+ t1.val;
            }
            if(t2!= null)
            {
                sum= sum+ t2.val;
            }

            //creating the new node after the sum done and carry is generated
            ListNode newNode= new ListNode(sum%10);
            carry= sum/10;

            current.next= newNode; // placing the new node after the dummy node
            current= current.next; // 



            //updation of t1 and t2
            if(t1!= null)
            {
                t1= t1.next;
            }
            if(t2!= null)
            {
                t2= t2.next;
            }
        }

        //checking for the last final carry value 
        //if carry hai, new node of the value carry
        if(carry!=0)
        {
            ListNode node= new ListNode(carry);
            current.next= node;//place this node at last

        }
        return dummyNode.next;




        }


    
        
}