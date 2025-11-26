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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode>minheap= new PriorityQueue<>((a,b)-> a.val-b.val);
        for(ListNode node:lists){
            if(node!=null){
                minheap.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while(!minheap.isEmpty()){
            ListNode minnode = minheap.poll();

            current.next = minnode;
            current= current.next;

            if(minnode.next != null){
                minheap.add(minnode.next);
            }
        }
        return dummy.next;
    }
}