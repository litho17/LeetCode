class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i=0; i<coins.length; i++) {
            if (coins[i]<=amount) dp[coins[i]] = 1;
        }
        helper(coins, dp, amount);
        return dp[amount];
    }
    
    // dp[i]==0: Uninitialized
    // dp[i]<0: Impossible
    // dp[i]>0: Possible; The min # of coins
    void helper(int[] coins, int[] dp, int amount) {
        if (amount<=0) return;
        if (dp[amount]==0) {
            int min = Integer.MAX_VALUE;
            for (int i=0; i<coins.length; i++) {
                int tgt = amount-coins[i];
                if (tgt<0) continue;
                helper(coins, dp, tgt);
                if (dp[tgt]<min&&dp[tgt]>0) min = dp[tgt];
            }
            if (min==Integer.MAX_VALUE) dp[amount] = -1;
            else dp[amount] = min+1;
            assert(dp[amount]!=0);
        }
    }
}

// Runtime: 20 ms, faster than 23.56% of Java online submissions for Coin Change.
// Memory Usage: 36.2 MB, less than 96.89% of Java online submissions for Coin Change.

