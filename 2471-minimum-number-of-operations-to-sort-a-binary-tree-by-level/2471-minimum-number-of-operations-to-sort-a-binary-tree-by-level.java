class Solution {
    public int minimumOperations(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int operations = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            operations += minSwapsToSort(level);
        }

        return operations;
    }

    private int minSwapsToSort(List<Integer> vec) {
        int swaps = 0;
        List<Integer> sortedVec = new ArrayList<>(vec);
        Collections.sort(sortedVec);

        Map<Integer, Integer> mp = new HashMap<>(); // nums[i] -> i
        for (int i = 0; i < vec.size(); i++) {
            mp.put(vec.get(i), i);
        }

        for (int i = 0; i < vec.size(); i++) {
            if (vec.get(i).equals(sortedVec.get(i))) {
                continue; // no swap required
            }

            int currIdx = mp.get(sortedVec.get(i));
            mp.put(vec.get(i), currIdx);
            mp.put(vec.get(currIdx), i);
            Collections.swap(vec, currIdx, i);
            swaps++;
        }

        return swaps;
    }
}
