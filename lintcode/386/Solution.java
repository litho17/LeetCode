public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s.length()==0 || k==0) return 0;
        int[] count = new int[128];
        int left = 0;
        int right = 0;
        int max = 1; // max length of the valid substring
        count[s.charAt(0)]++; // count # of chars in [left,right]
        while(true) {
            // Invariant: 0<=left<=right<s.length()
            boolean isValid = true;
            int C = 0;
            for (int i=0; i<128; i++) {
                if (count[i] != 0) C++;
                if (C>k) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                int len = right-left+1;
                if (len>max) max = len;
                right++; // TODO: Check array access
                if (right >= s.length()) break;
                char ch = (char)s.charAt(right);
                count[ch]++;
            }
            else {
                assert(left < right);
                if (left == right) {
                    assert (false);
                    // right++;
                    // left = right;
                }
                else {
                    char ch = (char)s.charAt(left);
                    count[ch]--;
                    left++;
                }
            }
        }
        return max;
    }
}

// Beat 57%
