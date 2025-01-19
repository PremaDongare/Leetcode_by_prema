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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1){
            return head; //  base case : if k is 1 or the list is empty , no change .
        }
        // dummy node to simplify handling of the head node.
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // pointer to traverse and modify the list.
        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while(current != null){
            // check if there are enough node to form a group of sixe k.
            ListNode groupStart = current;
            int count = 0;
            while (count < k && current != null){
                current = current.next;
                count ++;
             }

            if (count == k) { // Reverse the group of k nodes.
                ListNode reversedGroup = reverse(groupStart, k);
                prevGroupEnd.next = reversedGroup; // Connect the previous group to the reversed one.
                prevGroupEnd = groupStart; // Move the end pointer to the end of the reversed group.
            } else {
                prevGroupEnd.next = groupStart; // Not enough nodes; connect as-is.
            }
        }

        return dummy.next; // Return the new head.
    }

    // Helper method to reverse k nodes in the linked list.
    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode current = head;

        while (k > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }

        return prev; // The new head of the reversed group.
    }
}
