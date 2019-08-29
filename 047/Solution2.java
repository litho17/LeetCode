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
                ary[i] = nums[idx];
                set[i] = true;
                int lstDup_ = nums[idx+1]==nums[idx] ? i : -1;
                helper(nums, idx+1, ary, set, res, lstDup_);
                set[i] = false;
            }
        }
    }
}

// Runtime: 6 ms, faster than 20.51% of Java online submissions for Permutations II.
// Memory Usage: 38.9 MB, less than 92.54% of Java online submissions for Permutations II.

// I thought this was going to be a huge improvement...
