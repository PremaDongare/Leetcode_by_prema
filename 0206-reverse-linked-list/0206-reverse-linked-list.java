import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        // Stack to store the values of the linked list
        Stack<Integer> valueStack = new Stack<>();
        
        // Traverse through the linked list and push values to the stack
        while (head != null) {
            valueStack.push(head.val);
            head = head.next;
        }

        // Initialize the new reversed list
        ListNode reversedList = new ListNode(Integer.MIN_VALUE);
        ListNode ptr = reversedList;

        // Pop the values from the stack and build the reversed linked list
        while (!valueStack.isEmpty()) {
            ptr.next = new ListNode(valueStack.pop());
            ptr = ptr.next;
        }
        
        // Return the reversed list
        return reversedList.next;
    }
}
