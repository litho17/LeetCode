public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res=0;
        int h=1<<31;
        for (int i=0; i<32; i++) {
            boolean isZero = (h&n)==0; // If the highest bit is 0
            n = n<<1; // Get ready for the next iteration
            if (!isZero) {
                res = res | (1<<i); // Add 1<<i to res
            }
        }
        return res;
    }
}

// Runtime: 1 ms, faster than 99.98% of Java online submissions for Reverse Bits.
// Memory Usage: 30.1 MB, less than 5.01% of Java online submissions for Reverse Bits.
