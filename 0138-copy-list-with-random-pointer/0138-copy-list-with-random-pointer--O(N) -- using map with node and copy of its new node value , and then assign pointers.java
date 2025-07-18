/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        HashMap<Node, Node> oldToNew = new HashMap<>();
        
        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }
        
        return oldToNew.get(head);
    }

    // public Node copyRandomList(Node head) {
        
    //     Node dummy = new Node(-1);
    //     Node temp = dummy;                               //temp -  -1,
    //     Node curr = head;

    //     while(curr != null){     
    //         Node next =   curr.next;                // c- 7 , 13
    //         Node clone = new Node(curr.val);      // nn-7  , 13
    //         curr.next = clone;                   //d -> 7 -> 13 ->
    //         clone.next = next;                 //nn.next -> 13 -> 11
    //         curr = next;                      // nn.random -> null   ,

    //     }

    //     return dummy.next;
    // }
}