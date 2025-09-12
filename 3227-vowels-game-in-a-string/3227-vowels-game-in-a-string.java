class Solution {
    public boolean doesAliceWin(String s) {
        return s.chars().anyMatch(c -> "aeiou".indexOf(c) >= 0);
    }
}

/*
   Approach →
    If the string has any vowels : Alice will win.
    Else Bob will win.

    Proof for this?
    Let's say for any given string there are 3 cases,

    1️⃣ Case 1 : Odd Number of Vowels Initially →
    Here firstly at Alice's turn, as there are an odd number of vowels in the string, he can simply delete the whole string, resulting in    Bob losing on the very next move.

    2️⃣ Case 2 : Even Number of Vowels Initially →
    For this case Alice can simply remove an odd number of vowels, as even - odd = odd always, so the vowels that will be left will be an odd number.
Now on Bob's turn he can remove an even number of vowels, but odd - even = odd as well, so after Bob removes an even number of vowels, Alice can just remove the entire string left on his next move.

    3️⃣ Case 3 : No Vowels Initally →
    As there are no vowels present in the string, Alice loses on his first move / the first move of the game.
*/