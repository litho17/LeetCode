class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length==0) return res;
        Arrays.sort(nums);
        helper(nums, 0, new int[nums.length], new boolean[nums.length], res, -1);
        return res;
    }
    
    // lstDup: Index of the last set element in ary that is the same as nums[idx], if exists. Otherwise it is -1.
    void helper(int[] nums, int idx, int[] ary, boolean[] set, List<List<Integer>> res, int lstDup) {
        if (idx==nums.length-1) {
            List<Integer> list = new LinkedList<>();
            for (int i=0; i<nums.length; i++) {
                if (set[i]==false) {
                    if (i>lstDup) list.add(nums[nums.length-1]);
                    else return;
                }
                else list.add(ary[i]);
            }
            res.add(list);
            return;
        }
        
        for (int i=0; i<nums.length; i++) {
            if (i>lstDup && set[i]==false) {
                int[] ary_ = new int[nums.length];
                boolean[] set_ = new boolean[nums.length];
                System.arraycopy(ary, 0, ary_, 0, nums.length);
                System.arraycopy(set, 0, set_, 0, nums.length);
                ary_[i] = nums[idx];
                set_[i] = true;
                int lstDup_ = nums[idx+1]==nums[idx] ? i : -1;
                helper(nums, idx+1, ary_, set_, res, lstDup_);
            }
        }
    }
}

// Runtime: 6 ms, faster than 20.51% of Java online submissions for Permutations II.
// Memory Usage: 39.2 MB, less than 76.12% of Java online submissions for Permutations II.
