class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (nums.length==0 || k%len==0) return;
        helper(nums,k%len);
    }
    
    void helper(int[] nums, int k) {
        assert (k>=0);
        if (k==0) return;
        int tmp = nums[nums.length-1];
        for (int i=nums.length-1; i>=1; i--) {
            nums[i]=nums[i-1];
        }
        nums[0] = tmp;
        helper(nums, k-1);
    }
}

// Runtime: 90 ms, faster than 12.26% of Java online submissions for Rotate Array.
// Memory Usage: 37.8 MB, less than 96.09% of Java online submissions for Rotate Array.
