class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 1; i <= num.length(); i++) {
            String num1 = num.substring(0, i); // [0, i-1]
            if (num1.length() > 1 && num1.charAt(0) == '0') continue;
            for (int j = i+1; j < num.length(); j++) {
                String num2 = num.substring(i, j); // [i, j-1]
                if (num2.length() > 1 && num2.charAt(0) == '0') continue;
                if (isAdditive(num1, num2, num.substring(j))) return true;
            }
        }
        return false;
    }
    
    boolean isAdditive(String s1, String s2, String s) {
        String result = add(s1, s2);
        // System.out.println(s1 + " " + s2 + " " + s + " " + result + " " + s.startsWith(result));
        if (s.startsWith(result)) {
            String newS = s.substring(result.length());
            if (newS.length() == 0) return true;
            else return isAdditive(s2, result, newS);
        } else return false;
    }
    
    String add(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < len1 || i < len2; i++) {
            int idx1 = len1-1-i;
            int idx2 = len2-1-i;
            char c1 = idx1>=0 ? s1.charAt(idx1) : '0';
            char c2 = idx2>=0 ? s2.charAt(idx2) : '0';
            int res = c1-'0'+c2-'0'+carry;
            if (res > 9) carry = 1;
            else carry = 0;
            sb.append((char)(res%10+'0'));
        }
        if (carry == 1) sb.append('1');
        return sb.reverse().toString();
    }
}

// Runtime: 1 ms, faster than 94.81% of Java online submissions for Additive Number.
// Memory Usage: 34.3 MB, less than 70.07% of Java online submissions for Additive Number.

