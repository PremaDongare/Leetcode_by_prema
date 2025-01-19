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
        if(head == null || head.next == null || k==0){
            return head;
        }
        // now calculate the length of the list 
        ListNode current = head ;
        int length = 1; // at least one node exist
        while(current.next != null){
            current = current.next;
            length++;
        }
          // Step 2: Connect the last node to the head to form a circular list
        current.next = head;
        // Step 3: Find the new head and break the circle
        int newHeadPosition = length - k % length; // Position of new head
        ListNode newTail = current; // Start from the end of the list

        for (int i = 0; i < newHeadPosition; i++) {
            newTail = newTail.next;
        }
      // The node after the newTail is the new head
        head = newTail.next;
        newTail.next = null; // Break the circular link

        return head;
    }
}