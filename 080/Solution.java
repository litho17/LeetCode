class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int len = 1;                // Goal/Invariant: ∀len.nums[0...len-1] is a good array
        int lastNum = nums[0];      // a number that may need to be removed
        int count = 1;              // # of lastNum in nums[0...len-1]
        int totalLen = nums.length; // nums[len...totalLen) may be a bad array
        while (len<totalLen) {
            if (nums[len] == lastNum) {
                if (count<2) {
                    count++;
                    len++;
                } else { // Find the next different number (if exists) and Remove elements in between
                    int j = len;
                    while (j<totalLen && nums[j]==lastNum) j++;
                    if (j==totalLen) {
                        return len;
                    } else {
                        for (int k=len; j+(k-len)<totalLen; k++) {
                            nums[k]=nums[j+(k-len)];
                        }
                        count = 1;
                        lastNum = nums[len];
                        totalLen -= j-len;
                        len++;
                    }
                }
            } else {
                count = 1;
                lastNum = nums[len];
                len++;
            }
        }
        return len;
    }
}

// Runtime: 3 ms, faster than 11.56% of Java online submissions for Remove Duplicates from Sorted Array II.
// Memory Usage: 37.3 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted Array II.
