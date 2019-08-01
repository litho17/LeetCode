class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<=1) return s.length();
        char[] ary = s.toCharArray();
        Set<Character> visited = new HashSet<>();
        int max=0;
        int j;
        for (j=0; j<ary.length; j++) {
            if (!visited.contains(ary[j])) visited.add(ary[j]);
            else break;
        }
        if (j>max) max=j;
        for (int i=1; i<ary.length; i++) {
            visited.remove(ary[i-1]);
            // visited: All non-repetative chars starting from i to visited.size()+i-1
            int k;
            for (k=visited.size()+i; k<ary.length; k++) {
                if (!visited.contains(ary[k])) visited.add(ary[k]);
                else break;
            }
            if (k-i>max) max=k-i;
        }
        return max;
    }
}

// Runtime: 10 ms, faster than 40.09% of Java online submissions for Longest Substring Without Repeating Characters.
// Memory Usage: 36.7 MB, less than 99.89% of Java online submissions for Longest Substring Without Repeating Characters.
