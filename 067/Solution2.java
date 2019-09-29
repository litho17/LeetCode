class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        
        String minStr = a.length()<=b.length() ? a : b;
        String maxStr = a.length()<=b.length() ? b : a;
        int maxLen = maxStr.length();
        int minLen = minStr.length();
        int carry = 0;
        for (int i=maxLen-1; i>=0; i--) {
            int idx = i-maxLen+minLen;
            char ch1 = idx>=0 ? minStr.charAt(idx) : '0';
            char ch2 = maxStr.charAt(i);
            int sum = (ch1-'0')+(ch2-'0')+carry;
            int digit = sum%2;
            carry = sum/2;
            sb.append((char)(digit+'0'));
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}

// Runtime: 2 ms, faster than 70.10% of Java online submissions for Add Binary.
// Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Add Binary.
