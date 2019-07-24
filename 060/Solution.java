class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];
        for (int i=0; i<n; i++) {
            used[i] = false;
        }
        helper(n, k, used, sb);
        return sb.toString();
    }

    void helper(int n, int k, boolean[] used, StringBuilder sb) {
        if (n==1) {
            assert(k==1);
            int count=0;
            for (int i=0; i<used.length; i++) {
                if (used[i]==false) {
                    sb.append(Integer.toString(i+1));
                    count++;
                }
            }
            //assert(count==1);
            return;
        }
        int sum = 0;
        int stop = 1;
        while (k > sum) {
            sum += factorial(n-1);
            stop++;
        }
        stop--;
        sum -= factorial(n-1);
        int rem = k-sum;
        int count = 0;
        for (int i=0; i<used.length; i++) { // Find the stop-th unused
            if (used[i]==false) count++;
            if (count==stop) {
                used[i] = true;
                sb.append(Integer.toString(i+1));
                helper(n-1, rem, used, sb);
                break;
            }
        }
    }

    int factorial(int n) {
        if (n==0||n==1) return 1;
        int ret = 1;
        while (n>1) {
            ret *= n;
            n--;
        }
        return ret;
    }
}

// Runtime: 1 ms, faster than 99.42% of Java online submissions for Permutation Sequence.
// Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Permutation Sequence.
