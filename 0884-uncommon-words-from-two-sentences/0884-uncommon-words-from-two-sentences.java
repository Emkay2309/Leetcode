class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;

        String [] arr = s.split(" ");

        Map<String,Integer> map = new HashMap<>();

        for(String str : arr) {
            map.put(str , map.getOrDefault(str,0) + 1 );
        }

        List<String> res = new ArrayList<>();

        for(Map.Entry<String , Integer> entry : map.entrySet() ) {
            if(entry.getValue() == 1) {
                res.add( entry.getKey() );
            }
        }

        int size = res.size();

        String [] ans = new String [size];
        int i=0;

        while(i < size) {
            ans[i] = res.get(i);
            i++;
        }

        return ans;



    }
}