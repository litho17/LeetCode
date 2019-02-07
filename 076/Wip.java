class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        int[] setT = new int[128];
        int[] tmp = new int[128];
        char[] aS = s.toCharArray();
        char[] aT = t.toCharArray();
        for (char c: aT) {
            setT[c]++;
            tmp[c]++;
        }
        int[] dp = new int[aS.length][129]; // dp[i]: min len starting from index i in s, such that it covers all chars in t
        boolean start = false;
        for (int i = aS.length-1; i >= 0; i--) {
            if (start) {
                if (setT[aS[i]] == 0) { // if aS[i] is not in t
                    dp[i] = dp[i+1]+1;
                } else {
                    int lastIdx = dp[i+1]+i;
                    if (aS[lastIdx] != aS[i]) {
                        assert(setT[aS[lastIdx]] > 0);
                        dp[i] = dp[i+1]+1;
                    } else {
                        // Find [breakIdx, lastIdx-1] such that
                        // 1) there is no char in (breakIdx, lastIdx-1] that belongs to setT
                        // 2) breakIdx >= i
                        int breakIdx = lastIdx;
                        boolean encounter = false;
                        for (int j = lastIdx-1; j >= i; j--) {
                            if (setT[aS[j]] > 0) { // if aS[j] is in t
                                // if (encounter) { // Break only if we have already encountered aS[i]
                                    breakIdx = j;
                                    break; 
                                // } else {
                                    // if (aS[j] == aS[i]) encounter = true; // We have encountered aS[i]
                                // }
                            }
                        }
                        System.out.println(s.substring(i, breakIdx+1));
                        dp[i] = breakIdx-i+1;
                    }
                }
            } else {
                if (tmp[aS[i]] > 0) {
                    tmp[aS[i]]--;
                    boolean existNonZero = false;
                    for (int count: tmp) {
                        if (count > 0) {
                            existNonZero = true;
                            break;
                        }
                    }
                    if (!existNonZero) { // forall i, tmp[i] == 0
                        int lastIdx = aS.length-1;
                        for (int j = aS.length-1; j >= i; j--) { // Move lastIdx to the right most pos
                            if (setT[aS[j]] != 0) {
                                lastIdx = j;
                                break;
                            }
                        }
                        dp[i][128] = lastIdx-i+1;
                        start = true;
                    }
                }
            }
        }
        
        int min = aS.length;
        String ret = "";
        for (int i = 0; i < dp.length; i++) {
            // System.out.println(dp[i]);
            if (dp[i] != 0 && dp[i] <= min) {
                min = dp[i];
                ret = s.substring(i, i+dp[i]); // right: exclusive
            }
        }
        return ret;
    }
}
