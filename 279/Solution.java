class Solution {
    public int numSquares(int n) {
        int r = (int)Math.sqrt(n);
        int[][] dp = new int[n+1][r+1];
        helper(n, r, dp);
        int min = n;
        for (int i=1; i<=r; i++) {
            if (dp[n][i]!=0 && dp[n][i]<min) min = dp[n][i];
        }
        return min;
    }
    
    // The largest square number we can use to decompose n is m^2
    void helper(int n, int m, int[][] dp) {
        // System.out.println(n+" "+m);
        int oldM=m;
        while (m*m>n) m--;
        assert (m>=1);
        if (n==0) return;
        if (dp[n][m]!=0) {
            for (int i=m; i<=oldM; i++) {
                dp[n][i] = dp[n][m];
            }
        }
        int min = n;
        for (int i=2; i<=m; i++) {
            int k = n/(i*i);
            int rem = n%(i*i);
            if (rem>0) {
                helper(rem, i-1, dp);
                // System.out.println(k+" "+rem+" "+(i-1)+" "+dp[rem][i-1]);
                if (dp[rem][i-1]!=0 && k+dp[rem][i-1]<min) min = k+dp[rem][i-1];
            } else {
                if (k<min) min = k;
            }
        }
        for (int i=m; i<=oldM; i++) {
            dp[n][i] = min;
            // System.out.println(n+" "+i+" "+min);
        }
    }
}

// Runtime: 607 ms, faster than 5.00% of Java online submissions for Perfect Squares.
// Memory Usage: 48.7 MB, less than 12.50% of Java online submissions for Perfect Squares.
