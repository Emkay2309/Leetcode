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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();

        while(head != null) {
            arr.add(head.val);
            head = head.next;
        }
        if(arr.size() == 1) return new TreeNode(arr.get(0));
        return createBST(0,arr.size()-1,arr);
    }

    public TreeNode createBST(int s , int e , ArrayList<Integer> arr) {
        if(s > e) return null;

        int mid = (s+e)/2;
        TreeNode root = new TreeNode(arr.get(mid));

        root.left = createBST(s,mid-1,arr);
        root.right = createBST(mid+1, e , arr);

        return root;
    }
}