class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int lastj = 0; // Index in nums1 where nums2[i] should start searching for the next j
        for (int i = 0; i < n; i++) {
            // Find nums1[j] such that: nums2[i]≥nums1[j] and nums2[i]<nums1[j+1]
            int j = lastj;
            int sorted = m+i; // # of elements in nums1 that have been merged
            while (j < sorted) {
                if (nums2[i] < nums1[j]) break;
                else j++;
            }
            if (j == sorted) { // Move all remaining elements from nums2 into nums1
                int newPos = sorted; // Index in nums1 where nums2[i] should be put into
                while (i < n) {
                    nums1[newPos] = nums2[i];
                    newPos++;
                    i++;
                }
                return;
            } else {
                int newPos = j; // Index in nums1 where nums2[i] should be put into
                int left = j; // Left-most index in nums1 where numbers in nums1 should be shifted
                int right = sorted-1; // Right-most index in nums1 where numbers in nums1 should be shifted
                int k = right;
                while (k >= left) {
                    nums1[k+1] = nums1[k];
                    k--;
                }
                nums1[newPos] = nums2[i];
                lastj = j;
            }
        }
    }
}

// Runtime: 1 ms, faster than 44.05% of Java online submissions for Merge Sorted Array.
// Memory Usage: 35.3 MB, less than 99.93% of Java online submissions for Merge Sorted Array.
