class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num<=1) return false;
        int sum = 1;
        int i=2;
        while(true) {
            if (i*i>num) break;
            if (num%i == 0) {
                if (i*i==num) sum += i;
                else sum += i+num/i;
            }
            // if (sum>num) return false;
            i++;
        }
        return sum==num;
    }
}

// Runtime: 1 ms, faster than 97.46% of Java online submissions for Perfect Number.
// Memory Usage: 33.4 MB, less than 42.28% of Java online submissions for Perfect Number.
