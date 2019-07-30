class Solution {
    public int[] searchRange(int[] nums, int target) {
        int idx = binSearch(nums, target, 0, nums.length-1);
        int[] res = new int[2];
        if (idx==-1) {
            res[0] = -1;
            res[1] = -1;
        } else {
            int i;
            for (i=idx; i>=0; i--) {
                if (nums[i]!=target) break;
            }
            res[0] = i+1;
            for (i=idx; i<nums.length; i++) {
                if (nums[i]!=target) break;
            }
            res[1] = i-1;
        }
        return res;
    }
    
    int binSearch(int[] nums, int tgt, int start, int end) {
        if (start<0 || end>=nums.length || start>end) return -1;
        if (nums[start]==tgt) return start;
        if (nums[end]==tgt) return end;
        int mid = (start+end)/2;
        if (nums[mid]==tgt) return mid;
        else if (nums[mid]<tgt) {
            return binSearch(nums, tgt, mid+1, end);
        } else {
            return binSearch(nums, tgt, start, mid-1);
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
// Memory Usage: 39.7 MB, less than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
