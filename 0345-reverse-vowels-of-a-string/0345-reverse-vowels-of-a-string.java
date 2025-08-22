import java.util.function.Predicate;

class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        char[] arr = s.toCharArray();
        String check = "aeiouAEIOU";
        
        Predicate<Character> isVowel = ch -> check.indexOf(ch) != -1;

        while (i < j) {
            char start = arr[i];
            char end = arr[j];

            if (!isVowel.test(start)) {
                i++;
            } else if (!isVowel.test(end)) {
                j--;
            } else {
                arr[i] = end;
                arr[j] = start;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
