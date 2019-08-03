class Solution {
    public int findSubstringInWraproundString(String p) {
        char[] ary = p.toCharArray();
        Map<Character, Integer> map = new HashMap<>(); // (ch, i): all sub-strings that start with ch and length is less than or equal to i has been found
        int start = 0;
        int i;
        for (i=0; i<ary.length; i++) {
            if (i==0 || ary[i]==ary[i-1]+1 || ary[i]=='a'&&ary[i-1]=='z') ;
            else {
                int len = i-start;
                if (len>=1) { // [start, i)
                    for (int j=start; j<i; j++) {
                        Integer count = map.get(ary[j]);
                        int tmpLen = i-j;
                        if (count==null) map.put(ary[j], tmpLen); // substring that starts with ch and length is len-j
                        else if (tmpLen>count) map.put(ary[j], tmpLen);
                    }
                }
                start = i;
            }
        }
        if (i-start>=1) {
            for (int j=start; j<i; j++) {
                Integer count = map.get(ary[j]);
                int tmpLen = i-j;
                if (count==null) map.put(ary[j], tmpLen); // substring that starts with ch and length is len-j
                else if (tmpLen>count) map.put(ary[j], tmpLen);
            }
        }
        int ret = 0;
        for (Integer c: map.values()) {
            ret += c;
        }
        return ret;
    }
}

// Runtime: 6 ms, faster than 85.91% of Java online submissions for Unique Substrings in Wraparound String.
// Memory Usage: 37.3 MB, less than 92.59% of Java online submissions for Unique Substrings in Wraparound String.
