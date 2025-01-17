/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // start slow and fast pointer 
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(slowPtr != null && fastPtr != null && fastPtr.next != null){

            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            //if they meet then we found the loop
            if(slowPtr == fastPtr){
                return true;
            }
        } 
        return false;
        
    }
}