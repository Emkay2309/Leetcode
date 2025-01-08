class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        return (int) IntStream.range(0, words.length)
            .flatMap(i -> IntStream.range(i + 1, words.length)
                .filter(j -> isPrefixAndSuffix(words[i], words[j]))
            )
            .count();
    }

    private boolean isPrefixAndSuffix(String str1, String str2) {
        return str2.startsWith(str1) && str2.endsWith(str1);
    }
}