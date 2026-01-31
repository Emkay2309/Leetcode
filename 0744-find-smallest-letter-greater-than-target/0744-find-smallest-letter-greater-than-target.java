import java.util.stream.IntStream;

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        return (char) IntStream.range(0, letters.length)
                .map(i -> letters[i])  
                .filter(c -> c > target)
                .findFirst()
                .orElse((int) letters[0]); 
    }
}
