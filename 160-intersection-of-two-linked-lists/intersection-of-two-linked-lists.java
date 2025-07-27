/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//Brute:
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        ListNode tempA = headA;
        ListNode tempB = headB;
        int c=0;

        HashMap<ListNode, Integer> map= new HashMap<>();

        while(tempA!= null)
        {
            
            map.put(tempA, 1);
            tempA= tempA.next;
        }

        while(tempB!= null)
        {
            if(map.containsKey(tempB))
            {
                return tempB;
            }
            tempB= tempB.next;
        }
        return null;
    }
}



 /*
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
    {
        int intersectVal=0;
        int skipA=0;
        int skipB=0;

        ListNode tempA= headA;
        ListNode tempB= headB;
        int av=0;
        int bv=0;
        int c1=0;
        int c2=0;


        while(tempA!= null )
        {
            c1++;
            tempA= tempA.next;
        }

        while(tempB!= null )
        {
            c2++;
            tempB= tempB.next;
        }

        while(c1<=0)
        {
            
        }
           
            skipA++;
            av= tempA.val;
            bv= tempB.val;
            skipB++;

           
            tempB = tempB.next;


        
        
    }
}
//my approach- peeche se chalu karo, jab tak mil rha ho...uske last ka node return , baki left walon ko skipA and skipB me daldo.
//isme- pehle count both and c-- karke ulta chalao and see if match, last match ka node return baki minus karke skips me dalo.
*/