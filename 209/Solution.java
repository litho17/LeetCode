class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length==0) return 0;
        // Traverse all subarrays s.t. sum<s and add one more element will make its sum≥s
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i]; // sum: [left, i]
            if (sum<s) {
            } else {
                // sum[left, i]≥s
                while (left<=i&&sum>=s) {
                    int len = i-left+1;
                    if (len<min) min = len;
                    sum -= nums[left];
                    left++;
                }
                assert(left<=i||sum<s); // left>i => sum<s
            }
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}

// Runtime: 1 ms, faster than 99.95% of Java online submissions for Minimum Size Subarray Sum.
// Memory Usage: 36.9 MB, less than 99.35% of Java online submissions for Minimum Size Subarray Sum.
