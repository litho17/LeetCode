class Solution {
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length==0) return true;
        return helper1(nums, 0, nums.length-1, 0, 0);
    }
    
    // This is player 1's turn: Return if there exists a winning strategy for player 1
    boolean helper1(int[] nums, int start, int end, int score1, int score2) {
        assert(start>=0 && start<=end && end<=nums.length-1);
        if (start==end) {
            if (score1+nums[start]>=score2) return true;
            else return false;
        }
        boolean res1 = helper2(nums, start+1, end, score1+nums[start], score2);
        if (res1) return true;
        boolean res2 = helper2(nums, start, end-1, score1+nums[end], score2);
        return res2;
    }
    
    // This is player 2's turn: Return if there exists a winning strategy for player 1
    boolean helper2(int[] nums, int start, int end, int score1, int score2) {
        assert(start>=0 && start<=end && end<=nums.length-1);
        if (start==end) {
            if (score2+nums[start]>score1) return false;
            else return true;
        }
        boolean res1 = helper1(nums, start+1, end, score1, score2+nums[start]);
        boolean res2 = helper1(nums, start, end-1, score1, score2+nums[end]);
        return res1 && res2;
    }
}

// Runtime: 32 ms, faster than 15.91% of Java online submissions for Predict the Winner.
// Memory Usage: 34.7 MB, less than 100.00% of Java online submissions for Predict the Winner.

