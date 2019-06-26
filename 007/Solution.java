class Solution {
    public int reverse(int x) {
        int MIN = 0x80000000; // -2^31
        int MAX = 0x7FFFFFFF;
        if (x==MIN) return 0; // To make sure that -x is a non-negative number
        int num = x>=0 ? x : -x;
        assert(num>=0);
        int digits = 1;
        for (int tmp=num; tmp>9; tmp/=10) {
            digits++;
        }
        int res = 0; // res>=0
        for (int i=0; i<digits; i++) {
            int tens = num%10;
            for (int j=1; j<=digits-1-i; j++) {
                if (tens>(MAX/10)) return 0;
                else tens *= 10;
            }
            assert(tens>=0);
            int tmp = res+tens;
            boolean overflow = false;
            if (tmp < 0) {
                if (x<0 && tmp==MIN) ;
                else overflow = true;
            }
            if (overflow) return 0;
            else res = tmp;
            assert(res>=0);
            num = num/10;
        }
        if (x<0) {
            if (res==MIN) ;
            else res = -res;
        }
        return res;
    }
}

// Runtime: 18 ms, faster than 8.89% of Java online submissions for Reverse Integer.
// Memory Usage: 35.6 MB, less than 19.72% of Java online submissions for Reverse Integer.

// The idea is simply that, make sure each step of arithmetic operation will not overflow.
