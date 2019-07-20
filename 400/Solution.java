class Solution {
    public int findNthDigit(int n) {
        assert(n>0);
        if (n<10) return n;
        long sum = 0;
        long lstA = -1;
        long d=0;
        while (sum<n) {
            long a = (long)Math.pow(10,d-1)*9*d;
            sum += a;
            lstA = a;
            d++;
            // System.out.println(d+" "+sum);
        }
        d--;
        sum-=lstA;
        long remaining = n-sum;
        long start = (int)Math.pow(10,d-1);
        long count = remaining/d;
        long nthdigit = remaining%d;
        long end = count+start;
        // System.out.println(count+" "+nthdigit+" "+start+" "+end+" "+d);
        if (count==0) {
            if (nthdigit==0) { // remaining==0
                return 9;
            } else { // n-th digit of 10...0
                if (nthdigit==1) return 1;
                else return 0;
            }
        } else {
            if (nthdigit%d==0) { // last digit of end-1
                return (int)(end-1)%10;
            } else { // nth-digit of end
                long shift = d-nthdigit;
                return (int)(end/(int)Math.pow(10,shift))%10;
            }
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Nth Digit.
// Memory Usage: 33.2 MB, less than 5.17% of Java online submissions for Nth Digit.
