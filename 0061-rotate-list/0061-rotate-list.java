class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        // Find length
        int length = getLength(head, 1);
        
        // Optimize k
        k = k % length;
        if (k == 0) return head;
        
        // Find the node where we need to cut
        int cutAt = length - k;
        return rotateRecursive(head, cutAt);
    }
    
    private ListNode rotateRecursive(ListNode node, int steps) {
        // Base case: reached the node to cut
        if (steps == 1) {
            ListNode newHead = node.next;
            node.next = null;
            
            // Find the tail of the new list to connect original head
            ListNode tail = newHead;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
            return newHead;
        }
        
        return rotateRecursive(node.next, steps - 1);
    }
    
    private int getLength(ListNode node, int count) {
        if (node.next == null) return count;
        return getLength(node.next, count + 1);
    }
}