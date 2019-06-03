class Solution {
    public String multiply(String num1, String num2) {
        String res = "0";
        for (int i = num2.length()-1; i >= 0; i--) {
            for (int j = num1.length()-1; j >= 0; j--) {
                char c1 = num1.charAt(j);
                char c2 = num2.charAt(i);
                int tmp = (c1-'0')*(c2-'0'); // tmp∈[0,81]
                StringBuilder sb = new StringBuilder();
                if (tmp < 10) sb.append((char)('0'+tmp));
                else {
                    sb.append((char)('0'+tmp/10));
                    sb.append((char)('0'+tmp%10));
                }
                if (tmp != 0) { // Not append zeroes after 0
                    int zeroes = num1.length()-1-j+num2.length()-1-i;
                    for (int k = 0; k < zeroes; k++) sb.append('0');
                }
                //System.out.println(res + " " + sb.toString());
                res = add(res, sb.toString());
                //System.out.println(res);
            }
        }
        return res;
    }
    
    String add(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int i = 0;
        while (true) {
            int idx1 = s1.length()-1-i;
            int idx2 = s2.length()-1-i;
            if (idx1 >= 0) {
                char c1 = s1.charAt(idx1);
                int tmp = c1-'0'+carry;
                if (idx2 >= 0) {
                    char c2 = s2.charAt(idx2);
                    tmp += c2-'0';
                }
                res.append((char)(tmp%10+'0'));
                if (tmp >= 10) carry = tmp/10;
                else carry = 0;
            } else {
                if (idx2 >= 0) {
                    char c2 = s2.charAt(idx2);
                    int tmp = c2-'0'+carry;
                    res.append((char)(tmp%10+'0'));
                    if (tmp >= 10) carry = tmp/10;
                    else carry = 0;
                } else {
                    if (carry > 0) res.append((char)(carry+'0'));
                    break;
                }
            }
            i++;
        }
        return res.reverse().toString();
    }
}

// Runtime: 249 ms, faster than 5.02% of Java online submissions for Multiply Strings.
// Memory Usage: 36.5 MB, less than 99.94% of Java online submissions for Multiply Strings.
