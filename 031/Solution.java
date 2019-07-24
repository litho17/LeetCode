class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length==0) return;
        boolean success = helper(nums, 0);
        if (!success) reverse(nums, 0);
    }
    
    boolean helper(int[] nums, int start) {
        assert(start<nums.length);
        if (start==nums.length-1) return true;
        if (start==nums.length-2) {
            if (nums[start]<nums[start+1]) {
                swap(nums, start, start+1);
                return true;
            } else return false;
        }
        boolean success = helper(nums, start+1);
        if (success) return true;
        // Find the smallest number from start+1 s.t. it is greater than nums[start]
        int i;
        int idx = -1;
        int candidate = Integer.MAX_VALUE;
        for (i=start+1; i<nums.length; i++) {
            if (nums[i]>nums[start] && nums[i]<=candidate) {
                candidate = nums[i];
                idx = i;
            }
        }
        if (candidate==Integer.MAX_VALUE) return false;
        else {
            swap(nums, start, idx);
            helper(nums, start+1);
            // assert (success2);
            // System.out.println(nums[]);
            reverse(nums, start+1);
            return true;
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    void reverse(int[] nums, int start) {
        for (int i=0; i<(nums.length-start)/2; i++) {
            int tmp = nums[i+start];
            nums[i+start] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}

// Runtime: 1 ms, faster than 93.05% of Java online submissions for Next Permutation.
// Memory Usage: 41.3 MB, less than 37.36% of Java online submissions for Next Permutation.
