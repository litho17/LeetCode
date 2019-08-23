class Solution {
    public int wiggleMaxLength(int[] nums) {
        int len=nums.length;
        if (len<=1) return len;
        else if (len==2) return nums[0]!=nums[1] ? 2 : 1;
        int[][] dp = new int[len][2];
        for (int i=len-1; i>=0; i--) {
            int maxPos=1;
            int maxNeg=1;
            for (int j=i+1; j<len; j++) {
                if (nums[j]>nums[i]) {
                    if (dp[j][1]+1>maxPos) maxPos=dp[j][1]+1;
                } else if (nums[j]<nums[i]) {
                    if (dp[j][0]+1>maxNeg) maxNeg=dp[j][0]+1;
                }
            }
            dp[i][0]=maxPos; // Must include nums[i]: Length of the longest subsequence whose first difference is positive (if exists)
            dp[i][1]=maxNeg;
        }
        return dp[0][0]>dp[0][1] ? dp[0][0] : dp[0][1];
    }
}

// Runtime: 3 ms, faster than 24.58% of Java online submissions for Wiggle Subsequence.
// Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Wiggle Subsequence.

