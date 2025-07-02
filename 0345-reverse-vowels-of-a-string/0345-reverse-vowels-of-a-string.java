class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int i=0;
        int j=n-1;

        char [] arr = s.toCharArray();

        while(i <= j) {
            char start = arr[i];
            char end = arr[j];

            if(!vowel(start)) {
                i++;
            }
            else if(!vowel(end)) {
                j--;
            }
            else {
                //swap
                arr[i] = end;
                arr[j] = start;
                i++;
                j--;
            }
        }

        return new String(arr);
    }

    public boolean vowel(Character ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
            || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'
        ) {
            return true;
        }
        return false;
    }
}