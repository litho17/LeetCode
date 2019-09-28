class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new LinkedList<>();
        int len = nums.length;
        int i=0;
        while (i<=len-4) {
            int j=i+1;
            while (j<=len-3) {
                // System.out.println(nums[i]+",,,"+nums[j]);
                List<List<Integer>> res = twoSum(nums, j+1, len-1, target-nums[i]-nums[j]);
                for (List<Integer> l: res) {
                    List<Integer> tuple = new LinkedList<>();
                    tuple.add(nums[i]);
                    tuple.add(nums[j]);
                    tuple.addAll(l);
                    ret.add(tuple);
                }
                j++;
                // j has to be the left-most number in a sequence of same numbers
                while (j<=len-3 && nums[j-1]==nums[j]) {
                    j++;
                }
            }
            i++;
            // i has to be the left-most number in a sequence of same numbers
            while (i<=len-4 && nums[i-1]==nums[i]) {
                i++;
            }
        }
        return ret;
    }
    
    List<List<Integer>> twoSum(int[] nums, int start, int end, int tgt) {
        assert(start<end);
        List<List<Integer>> ret = new LinkedList<>();
        // System.out.println((nums[start]+nums[start+1]) + " " + (nums[end]+nums[end-1]) + " " + tgt);
        if (nums[start]+nums[start+1] > tgt || nums[end]+nums[end-1] < tgt) return ret;
        
        int left = start;
        int right = end;
        while (left<right) {
            // System.out.println(left+", "+right);
            if (nums[left] == nums[right]) {
                if (nums[left]+nums[right] == tgt) {
                    List<Integer> l = new LinkedList<>();
                    l.add(nums[left]);
                    l.add(nums[right]);
                    ret.add(l);
                }
                return ret;
            }

            // left must be the left-most element of a sequence of same numbers
            while (left-1>=start && left<=end && nums[left-1]==nums[left]) {
                left++;
            }
            // right must be the right-most element of a sequence of same numbers
            while (right+1<=end && right>=start && nums[right+1]==nums[right]) {
                right--;
            }
            if (left >= right) break;
            // assert (nums[left] < nums[right]);
            
            int sum = nums[left] + nums[right];
            if (sum == tgt) {
                List<Integer> l = new LinkedList<>();
                l.add(nums[left]);
                l.add(nums[right]);
                ret.add(l);
                if (nums[left] == nums[right]) return ret;
                left++;
            }
            else if (sum < tgt) {
                left++;
            }
            else {
                right--;
            }
        }
        return ret;
    }
}

// Runtime: 9 ms, faster than 84.62% of Java online submissions for 4Sum.
// Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for 4Sum.
