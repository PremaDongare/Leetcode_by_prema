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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // lets create a dummy node 
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // make markars 
        ListNode leftpre = dummy;
        ListNode currNode = head;

        for(int i=0; i<left-1;i++){
            leftpre = leftpre.next;
            currNode = currNode.next;
        }
        // make a marker to the node where we started reversing
        ListNode subListHead = currNode;

        ListNode preNode = null;
        for(int i=0 ; i<= right-left; i++){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        // join the pices 
        leftpre.next = preNode;
        subListHead.next = currNode;
        
        return dummy.next;

}
}