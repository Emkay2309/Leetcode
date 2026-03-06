class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        if(m > n) return "";

        int minSize = Integer.MAX_VALUE;
        int left = 0 , right = 0 , start = 0 , count = t.length();

        Map<Character , Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            map.put( ch , map.getOrDefault(ch , 0)+1);
        }


        while( right < n) {
            char curr = s.charAt(right);

            if(map.containsKey(curr) && map.get(curr) > 0) {
                count--;
            }

            if(!map.containsKey(curr)) {
                map.put(curr , -1);
            }
            else {
                map.put( curr , map.get(curr)-1);
            }

            //shrink
            while(count == 0) {
                int win = right-left+1;
                if(win < minSize) {
                    minSize = win;
                    start = left;
                }

                char remove = s.charAt(left);
                map.put( remove , map.get(remove)+1);

                if(map.get(remove) > 0) {
                    count++;
                }

                left++;
            }

            right++;
        }
        return minSize == Integer.MAX_VALUE ? "" : s.substring(start, start + minSize);
    }
}