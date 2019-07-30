class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length==0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = obstacleGrid[m-1][n-1]==0 ? 1 : 0;
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (obstacleGrid[i][j]==1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j+1<n) {
                    if (i+1<m) {
                        dp[i][j] = dp[i+1][j]+dp[i][j+1];
                    } else {
                        dp[i][j] = dp[i][j+1];
                    }
                } else {
                    if (i+1<m) {
                        dp[i][j] = dp[i+1][j];
                    } else {
                        ;
                    }
                }
            }
        }
        return dp[0][0];
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
// Memory Usage: 40.5 MB, less than 23.28% of Java online submissions for Unique Paths II.
