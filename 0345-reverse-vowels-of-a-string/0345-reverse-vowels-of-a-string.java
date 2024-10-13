import java.util.*;
class Solution {
    public String reverseVowels(String s) {
        int n = s.length();

        int i = 0;
        int j = n-1;

        char[] chars = s.toCharArray();

        while(i < j) {
            char ch1 = chars[i];
            char ch2 = chars[j];

            if(!isVowel(ch1)) i++;
            else if(!isVowel(ch2)) j--;
            else {
                char temp = ch1;
                chars[i] = ch2;
                chars[j] = temp;
                i++;
                j--;
            }
        }
        return new String(chars);
    }

    public boolean isVowel(char ch) {
        if(ch=='a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
            ch=='A' || ch== 'E' || ch == 'I' || ch == 'O' || ch == 'U'
        ) {
            return true;
        }
        return false;
    }
}