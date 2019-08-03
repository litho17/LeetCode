class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len==0) return 0;
        if (len==1) return nums[0];
        if (len==2) return nums[0]>=nums[1] ? nums[0] : nums[1];
        // [i][0]: Max starting from i when must not rob nums[len-1]
        // [i][1]: Max starting from i when must rob nums[len-1]
        int[][] dp = new int[len][2];
        dp[len-1][0] = 0;
        dp[len-1][1] = nums[len-1];
        dp[len-2][0] = nums[len-2];
        dp[len-2][1] = nums[len-1];
        for (int i=len-3; i>=1; i--) {
            int a1 = nums[i]+dp[i+2][0]; // Rob i: Must not rob last
            int a2 = nums[i]+dp[i+2][1]; // Rob i: Must rob last
            int a3 = dp[i+1][0]; // Not rob i: Must not rob last
            int a4 = dp[i+1][1]; // Not rob i: Must rob last
            dp[i][0] = a1>=a3 ? a1 : a3;
            // Not rob i
            dp[i][1] = a2>=a4 ? a2 : a4;
        }
        int a1 = nums[0]+dp[2][0]; // Rob i: Must not rob last
        int a3 = dp[1][0]; // Not rob i: Must not rob last
        int a4 = dp[1][1]; // Not rob i: Must rob last
        if (a1>=a3) {
            if (a3>=a4) {
                return a1;
            } else {
                return a1>=a4 ? a1 : a4;
            }
        } else {
            if (a3>=a4) {
                return a3;
            } else {
                return a4;
            }
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber II.
// Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for House Robber II.
