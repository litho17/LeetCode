class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new LinkedList<>();
        if (nums.length==0) return ret;
        if (nums.length==1) {
            ret.add(nums[0]+"");
            return ret;
        }
        int startNum = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]+1) {
                ;
            } else {
                assert (nums[i]>nums[i-1]+1);
                if (nums[i-1]==startNum) ret.add(startNum+"");
                else ret.add(startNum+"->"+nums[i-1]);
                startNum = nums[i];
            }
        }
        // We add a string to ret only when discovering an element that is not continous
        // The last element is not yet included in ret
        if (nums[nums.length-1]==nums[nums.length-2]+1) ret.add(startNum+"->"+nums[nums.length-1]);
        else ret.add(nums[nums.length-1]+"");
        return ret;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Summary Ranges.
// Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Summary Ranges.

