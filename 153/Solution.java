class Solution {
    public int findMin(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    int helper(int[] nums, int start, int end) {
        if (start>end || start<0 || end>=nums.length) {
            assert(false);
            return -1;
        }
        if (start==end) return nums[start];
        if (start+1==end) return nums[start]<nums[end] ? nums[start] : nums[end];
        
        int mid = (start+end)/2;
        if (nums[mid]<nums[start]) return helper(nums, start+1, mid);
        else if (nums[mid]>nums[start]) {
            if (nums[mid]>nums[end]) return helper(nums, mid+1, end);
            else if (nums[mid]<nums[end]) return nums[start]; // helper(nums, start, mid-1);
            else assert(false);
        }
        assert(false);
        return -1;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
// Memory Usage: 38.8 MB, less than 73.86% of Java online submissions for Find Minimum in Rotated Sorted Array.
