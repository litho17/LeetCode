class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            for (int j = i+1; j < nums.length; j++) {
                if (j>i+1 && nums[j]==nums[j-1]) continue;
                int sum = nums[i]+nums[j];
                int idx = binarySearch(nums, j+1, nums.length-1, -sum);
                if (idx != -1) ret.add(Arrays.asList(nums[i], nums[j], nums[idx]));
            }
        }
        return ret;
    }
    
    int binarySearch(int[] nums, int start, int end, int target) {
        if (start>end || target<nums[start] || target>nums[end]) return -1;
        int mid = (start+end)/2;
        if (target == nums[mid]) return mid;
        else if (target < nums[mid]) return binarySearch(nums, start, mid-1, target);
        else return binarySearch(nums, mid+1, end, target);
    }
}

// Runtime: 131 ms, faster than 24.86% of Java online submissions for 3Sum.
// Memory Usage: 42.4 MB, less than 5.15% of Java online submissions for 3Sum.
