class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length<=1) return true;
        int[] dp = new int[nums.length]; // dp[i]: The furtherst idx that I can jump to starting from idx i
        dp[nums.length-1] = nums.length-1;
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i]==0) {
                dp[i] = i;
                continue;
            }
            // Otherwise, i+1 is reachable
            int max = dp[i+1];
            for (int j=i+2; j<nums.length&&j<=i+nums[i]; j++) {
                if (dp[j]>max) max = dp[j];
            }
            dp[i] = max;
        }
        return dp[0]==nums.length-1;
    }
}

// Runtime: 109 ms, faster than 32.01% of Java online submissions for Jump Game.
// Memory Usage: 40.6 MB, less than 55.15% of Java online submissions for Jump Game.
