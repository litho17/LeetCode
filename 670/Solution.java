class Solution {
    public int maximumSwap(int num) {
        if (num==0) return 0;
        StringBuilder sb = new StringBuilder();
        int tmp = num;
        while (tmp>0) {
            int d = tmp%10;
            sb.append((char)(d+'0'));
            tmp = tmp/10;
        }
        char[] digits = sb.reverse().toString().toCharArray();
        for (int i=0; i<digits.length; i++) {
            char max = digits[i];
            int idx = i;
            for (int j=i+1; j<digits.length; j++) {
                if (digits[j]>=max) {
                    max=digits[j];
                    idx=j;
                }
            }
            if (max != digits[i]) {
                digits[idx] = digits[i];
                digits[i] = max;
                int ten = 1;
                int res = 0;
                for (int j=digits.length-1; j>=0; j--) {
                    res += (digits[j]-'0')*ten;
                    ten *= 10;
                }
                return res;
            }
        }
        return num;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Swap.
// Memory Usage: 32.9 MB, less than 25.00% of Java online submissions for Maximum Swap.

