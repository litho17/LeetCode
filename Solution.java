class Solution {
	public int getMoneyAmount(int n) {
		int dp[][] = new int[n+1][n+1];
		helper(dp, 1, n);
		return dp[1][n];
	}

	void helper(int dp[][], int start, int end) {
		if (start == end || dp[start][end] != 0) {
			return;
		}
		int min = Integer.MAX_VALUE;
		for (int j=start; j<=end; j++) {
			int tmp1 = 0;
			int tmp2 = 0;
			if (j-1>start) {
				if (dp[start][j-1] == 0) {
					helper(dp, start, j-1);
				}
				tmp1 = dp[start][j-1];
			}
			if (j+1<end) {
				if (dp[j+1][end] == 0) {
					helper(dp, j+1, end);
				}
				tmp2 = dp[j+1][end];
			}
			int res = j + (tmp1>=tmp2 ? tmp1 : tmp2);
			if (res < min) {
				min = res;
			}
		}
		dp[start][end] = min;
	}
}

// Runtime: 9 ms, faster than 13.02% of Java online submissions for Guess Number Higher or Lower II.
// Memory Usage: 33.3 MB, less than 16.67% of Java online submissions for Guess Number Higher or Lower II.
