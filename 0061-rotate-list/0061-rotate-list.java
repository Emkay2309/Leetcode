class Solution {

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) return head;
        
        int length = count(head);
        k = k % length;

        if (k == 0) return head;
        
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        // Make circle
        tail.next = head;

        // Find new tail
        int steps = length - k - 1;
        ListNode newTail = head;

        while (steps-- > 0) {
            newTail = newTail.next;
        }

        // New head
        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }

    public int count(ListNode head) {

        if (head == null) {
            return 0;
        }

        return 1 + count(head.next);
    }
}