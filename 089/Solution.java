class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<>();
        if (n==0) {
            res.add(0);
            return res;
        }
        List<Integer> res_ = grayCode(n-1);
        res.addAll(res_);
        int pow = (int)Math.pow(2, n-1);
        for (int i=res_.size()-1; i>=0; i--) {
            Integer m = res_.get(i);
            res.add(m+pow);
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 45.19% of Java online submissions for Gray Code.
// Memory Usage: 34.4 MB, less than 8.00% of Java online submissions for Gray Code.
