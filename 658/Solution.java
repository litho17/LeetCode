class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int startPos = binSearch(0, arr.length-1, arr, x);
        int left = startPos-1; // The next idx to try
        int right = startPos+1; // The next idx to try
        int count = 1;
        while (count < k) { // TODO: The other termination condition
            int diff1 = left>=0 ? x-arr[left] : Integer.MAX_VALUE; // TODO: Check array access
            int diff2 = right<arr.length ? arr[right]-x : Integer.MAX_VALUE;
            if (diff1 == diff2) {
                count++;
                left--;
            }
            else if (diff1 < diff2) {
                count++;
                left--;
            }
            else {
                count++;
                right++;
            }
        }
        List<Integer> ret = new LinkedList<>();
        int L = left+1;
        int R = right-1;
        for (int i=L; i<=R; i++) {
            ret.add(arr[i]);
        }
        return ret;
    }
    
    // Find the index of the closest element in nums
    int binSearch(int start, int end, int[] nums, int x) {
        if (start>end) return -1;
        if (start==end) return start;
        if (nums[start]>=x) return start;
        if (nums[end]<=x) return end;
        int mid = (start+end)/2;
        if (nums[mid]==x) return mid;
        else if (nums[mid]<x) {
            int diff1 = x-nums[mid];
            int diff2 = nums[end]-x;
            if (diff1 == diff2) {
                if (mid>end-1) return mid;
                else return binSearch(mid, end-1, nums, x);
            }
            else if (diff1 < diff2) {
                if (mid>end-1) return mid;
                else return binSearch(mid, end-1, nums, x);
            }
            else {
                if (mid+1>end) return end;
                else return binSearch(mid+1, end, nums, x);
            }
        }
        else {
            int diff1 = x-nums[start];
            int diff2 = nums[mid]-x;
            if (diff1 == diff2) {
                if (start>mid-1) return start;
                else return binSearch(start, mid-1, nums, x);
            }
            else if (diff1 < diff2) {
                if (start>mid-1) return start;
                else return binSearch(start, mid-1, nums, x);
            }
            else {
                if (start+1>mid) return mid;
                else return binSearch(start+1, mid, nums, x);
            }
        }
    }
}

// Runtime: 4 ms, faster than 88.72% of Java online submissions for Find K Closest Elements.
// Memory Usage: 40 MB, less than 91.18% of Java online submissions for Find K Closest Elements.
