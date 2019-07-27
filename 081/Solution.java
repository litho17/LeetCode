class Solution {
    public boolean search(int[] nums, int target) {
        return abnormalBinSearch(nums, 0, nums.length-1, target);
    }
    
    boolean normalBinSearch(int[] nums, int start, int end, int tgt) {
        if(start<0||end>=nums.length||start>end) return false;
        if (start==end) return tgt==nums[start];
        int mid = (start+end)/2;
        if (nums[start]==tgt) return true;
        else if (nums[start]>tgt) return false;
        else {
            if (nums[end]==tgt) return true;
            else if (nums[end]<tgt) return false;
            else {
                if (nums[mid]==tgt) return true;
                else if (nums[mid]<tgt) return normalBinSearch(nums, mid+1, end, tgt); // we must make progress here
                else return normalBinSearch(nums, start, mid-1, tgt); // we must make progress here
            }
        }
    }
    
    boolean abnormalBinSearch(int[] nums, int start, int end, int tgt) {
        if(start<0||end>=nums.length||start>end) return false;
        int mid = (start+end)/2;
        if (tgt==nums[start]||tgt==nums[end]||tgt==nums[mid]) return true;
        if (tgt>nums[start]) {
            if (nums[mid]>tgt) return normalBinSearch(nums, start+1, mid-1, tgt);
            else return abnormalBinSearch(nums, start+1, mid-1, tgt) || abnormalBinSearch(nums, mid+1, end, tgt);
        } else {
            if (nums[mid]>tgt) return abnormalBinSearch(nums, mid+1, end, tgt) || abnormalBinSearch(nums, start+1, mid-1, tgt);
            else return normalBinSearch(nums, mid+1, end, tgt);
        }
    }
}

// Runtime: 1 ms, faster than 45.88% of Java online submissions for Search in Rotated Sorted Array II.
// Memory Usage: 38.4 MB, less than 94.34% of Java online submissions for Search in Rotated Sorted Array II.
