class Solution {
    public String fractionAddition(String expression) {
        int  num = 0;
        int  den = 1;

        int n = expression.length();
        int i = 0;

        while(i < n) {
            char ch = expression.charAt(i);

            boolean neg = (ch == '-');
            int currNum = 0;
            int currDen = 0;

            if(ch == '-' || ch == '+') {
                i++;
            }

            //create numertor
            while( i<n && Character.isDigit(expression.charAt(i)) )   {
                int val = expression.charAt(i)-'0';
                currNum = (currNum*10) + val;
                i++;
            }
            i++;

            if(neg) {
                currNum *= -1;
            }


            // Build the current denominator
            while(i < n && Character.isDigit(expression.charAt(i))) {
                int val = expression.charAt(i) - '0';
                currDen = (currDen * 10) + val;
                i++;
            }

            //perforn add sub
            num = num * currDen + currNum * den;
            den = den * currDen; 
        }

        // Simplify the fraction using the greatest common divisor (GCD)
        int gcd = gcd(Math.abs(num), den);

        num /= gcd;
        den /= gcd;

        return Integer.toString(num) + "/" + Integer.toString(den);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}