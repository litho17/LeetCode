class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length()==0) return true;
        boolean[] dp = new boolean[s.length()];
        for (int i=0; i<s.length(); i++) {
            dp[i] = false;
        }
        Set<String> dict = new HashSet<String>(wordDict);
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=1; i+j<=s.length(); j++) {
                if (dict.contains(s.substring(i, i+j))) {
                    if (i+j==s.length() || dp[i+j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[0];
    }
}

// Runtime: 6 ms, faster than 31.79% of Java online submissions for Word Break.
// Memory Usage: 36.2 MB, less than 96.67% of Java online submissions for Word Break.

// Easter egg: If you let s be "", then you'll see "AddressSanitizer: SEGV on unknown address 0x000000000000 (pc 0x000000408d56 bp 0x7ffe07cb5f40 sp 0x7ffe07cb49e0 T0)"
