class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        
        // Find length
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        k = k % length;
        if (k == 0) return head;
        
        // Make it circular
        tail.next = head;
        
        // Find new tail: (length - k) steps from head
        int stepsToNewTail = length - k;
        ListNode newTail = findNewTail(head, stepsToNewTail);
        
        ListNode newHead = newTail.next;
        newTail.next = null;
        
        return newHead;
    }
    
    private ListNode findNewTail(ListNode node, int steps) {
        if (steps == 1) return node;
        return findNewTail(node.next, steps - 1);
    }
}