class Solution {
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        if (len<=2) return false;
        int[] dp = new int[len]; // If initialized: the largest number starting from index i s.t. there exists another number that is greater than it and has an index larger than it
        boolean[] init = new boolean[len];
        if (nums[len-2]<nums[len-1]) {
            dp[len-2] = nums[len-2];
            init[len-2] = true;
        }
        for (int i=len-3; i>=0; i--) {
            boolean maxInit = false;
            int max = -1;
            for (int j=i+1; j<len; j++) {
                if (init[j]) {
                    if (nums[i]<dp[j]) return true;
                    if (!maxInit) {
                        maxInit = true;
                        max = dp[j];
                    } else if (dp[j]>max) max = dp[j];
                }
            }
            // If there exists a number whose index is larger than i and is larger than nums[i]
            boolean existsLarger = false;
            for (int j=i+1; j<len; j++) {
                if (nums[j]>nums[i]) {
                    existsLarger = true;
                    break;
                }
            }
            if (existsLarger) {
                if (maxInit) {
                    dp[i] = nums[i]>=max ? nums[i] : max;
                } else {
                    dp[i] = nums[i];
                }
                init[i] = true;
            } else {
                if (maxInit) {
                    dp[i] = max;
                    init[i] = true;
                }
            }
        }
        /*for (int i=0; i<len; i++) {
            System.out.println(init[i]+" "+dp[i]);
        }*/
        return false;
    }
}

// Runtime: 110 ms, faster than 5.01% of Java online submissions for Increasing Triplet Subsequence.
// Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Increasing Triplet Subsequence.

