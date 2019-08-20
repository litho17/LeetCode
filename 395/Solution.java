class Solution {
    public int longestSubstring(String s, int k) {
        int[] count;
        int max=0;
        for (int i=0; i<s.length(); i++) {
            count = new int[26];
            for (int j=i; j<s.length(); j++) {
                count[s.charAt(j)-'a']++;
                boolean fail=false;
                for (int c: count) {
                    if (c!=0&&c<k) {
                        fail=true;
                        break;
                    }
                }
                if (!fail&&j-i+1>max) max=j-i+1;
            }
        }
        return max;
    }
}

// Runtime: 114 ms, faster than 5.67% of Java online submissions for Longest Substring with At Least K Repeating Characters.
// Memory Usage: 35.4 MB, less than 100.00% of Java online submissions for Longest Substring with At Least K Repeating Characters.

