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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // 1️⃣ Count the length
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2️⃣ Make it circular
        tail.next = head;

        // 3️⃣ Find the new head (length - k % length steps from start)
        k = k % length;
        int stepsToNewHead = length - k;

        ListNode newTail = tail;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // 4️⃣ Break the circle
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
