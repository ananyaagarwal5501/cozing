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
import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap based on node values
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Add the head of each list into the heap
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }

        // Dummy node to simplify handling the head
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Step 2: Extract min and push next
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();  // get smallest node
            tail.next = smallest;
            tail = tail.next;

            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }
}
