/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node current = head; // Renamed 'cur' to 'current' for clarity
        Node tail = head;
        Stack<Node> stack = new Stack<>(); // Fixed stack declaration

        while (current != null) {
            if (current.child != null) {
                Node child = current.child;
                if (current.next != null) {
                    stack.push(current.next);
                    current.next.prev = null;
                }
                current.next = child;
                child.prev = current;
                current.child = null;
            }
            tail = current;
            current = current.next;
        }

        while (!stack.isEmpty()) {
            current = stack.pop();
            tail.next = current;
            current.prev = tail;

            while (current != null) {
                tail = current;
                current = current.next;
            }
        }

        return head;
    }
}