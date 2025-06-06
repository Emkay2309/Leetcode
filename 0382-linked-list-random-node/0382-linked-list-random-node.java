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
    List<Integer> list;
    static Random random = new Random();
    public Solution(ListNode head) {
        list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
    }
    
    public int getRandom() {
        int n = list.size();
        return list.get(random.nextInt(n));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */