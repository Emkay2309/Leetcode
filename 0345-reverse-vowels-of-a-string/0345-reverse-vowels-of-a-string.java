class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        char [] arr = s.toCharArray();
        int start = 0 , end = n-1;
        String check = "aeiouAEIOU";

        Predicate<Character> vowels = ch -> check.indexOf(ch) != -1;

        while(start < end) {
            char left = arr[start];
            char right = arr[end];

            if(!vowels.test(left)) {
                start++;
            }
            else if(!vowels.test(right)) {
                end--;
            }
            else {
                arr[start] = right;
                arr[end] = left;
                start++;
                end--;
            }
        }
        return new String(arr);
    }
}