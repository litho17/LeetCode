class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        int[] sums = new int[k];
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        if (sum%k != 0) return false;
        return helper(nums, sums, nums.length-1, sum/k);
    }
    
	// Attempt to put nums[idx] into the all bins whose sum can be added to nums[idx] and remains no larger than target.
	// I think it is possible that this function will visit a "permutation" of previously visited program state.
	// If this is the case, then this algorithm can be further optimized.
    boolean helper(int[] nums, int[] sums, int idx, int target) {
        if (idx==-1) {
            for (int i=0; i<sums.length; i++) {
                // Check if the sum is equal to target and if the subset is non-empty
                if (sums[i] != target || sums[i] == 0) return false;
            }
            return true;
        }
        for (int i=0; i<sums.length; i++) {
            if (sums[i]+nums[idx] <= target) {
                int oldSum = sums[i];
                sums[i] = sums[i]+nums[idx];
                boolean res = helper(nums, sums, idx-1, target);
                sums[i] = oldSum;
                if (res) return true;
            }
        }
        return false;
    }
}

// Runtime: 15 ms, faster than 36.43% of Java online submissions for Partition to K Equal Sum Subsets.
// Memory Usage: 34.6 MB, less than 81.40% of Java online submissions for Partition to K Equal Sum Subsets.
