class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }
        return new ArrayList<>(map.values());
    }
}