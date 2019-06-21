class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0) return "";
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (true) { // Consider i-th char of each string.
            if (i>=strs[0].length()) return sb.toString();
            char c1 = strs[0].charAt(i);
            for (String str: strs) {
                if (i>=str.length()) return sb.toString();
                char c2 = str.charAt(i);
                if (c1!=c2) return sb.toString();
            }
            sb.append(c1);
            i++;
        }
    }
}

// Runtime: 1 ms, faster than 77.49% of Java online submissions for Longest Common Prefix.
// Memory Usage: 36 MB, less than 99.81% of Java online submissions for Longest Common Prefix.

