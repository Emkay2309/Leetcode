class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;

        for (String node : preorder.split(",")) {
            slots--; // every node uses one slot
            if (slots < 0) return false;

            if (!node.equals("#")) {
                slots += 2; // non-null creates two slots
            }
        }

        return slots == 0;
    }
}