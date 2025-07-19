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
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node childHead = flatten(curr.child); // Recursively flatten child
                Node next = curr.next;

                // Attach child
                curr.next = childHead;
                childHead.prev = curr;
                curr.child = null; // Clear child pointer

                // Move to the end of the child list
                Node childTail = childHead;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }

                // Connect next to childTail
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
