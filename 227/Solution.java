class Solution {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i)!=' ') sb.append(s.charAt(i));
        }
        String sp = sb.toString();
        if (sp.length()==0) return 0;
        return calculate(sp, 0, sp.length()-1);
    }
    
    // Pre-condition: Contain '+ or - or * or /'
    int calculate(String s, int start, int end) {
        assert (start>=0 && end<s.length() && start<=end);
        int res = 0;
        int i;
        char lstOp = '~';
        for (i=start; i<=end; i++) {
            if (s.charAt(i)=='+' || s.charAt(i)=='-') {
                res += helper(s, start, i-1);
                lstOp = s.charAt(i);
                break;
            }
        }
        if (lstOp=='~') return helper(s, start, end);
        else {
            int lstIdx = i+1;
            int j;
            for (j=i+1; j<=end; j++) {
                if (s.charAt(j)=='+'||s.charAt(j)=='-') {
                    res = lstOp=='+' ? res+helper(s, lstIdx, j-1) : res-helper(s, lstIdx, j-1);
                    lstIdx = j+1;
                    lstOp = s.charAt(j);
                }
            }
            res = lstOp=='+' ? res+helper(s, lstIdx, end) : res-helper(s, lstIdx, end);
            return res;
        }
    }
    
    // Pre-condition: Contain '*' or '/'
    int helper(String s, int start, int end) {
        assert (start>=0 && end<s.length() && start<=end);
        int res = 0;
        int i;
        char lstOp = '~';
        for (i=start; i<=end; i++) {
            if (s.charAt(i)=='*'||s.charAt(i)=='/') {
                res += getNum(s, start, i-1);
                lstOp = s.charAt(i);
                break;
            }
        }
        if (lstOp=='~') return getNum(s, start, end);
        else {
            int lstIdx = i+1;
            int j;
            for (j=i+1; j<=end; j++) {
                if (s.charAt(j)=='*'||s.charAt(j)=='/') {
                    res = lstOp=='*' ? res*getNum(s, lstIdx, j-1) : res/getNum(s, lstIdx, j-1);
                    lstIdx = j+1;
                    lstOp = s.charAt(j);
                }
            }
            res = lstOp=='*' ? res*getNum(s, lstIdx, end) : res/getNum(s, lstIdx, end);
            return res;
        }
    }
    
    int getNum(String s, int start, int end) {
        int res = 0;
        int tmp = 1;
        for (int i=end; i>=start; i--) {
            res += (s.charAt(i)-'0')*tmp;
            tmp *= 10;
        }
        return res;
    }
}

// Runtime: 15 ms, faster than 73.96% of Java online submissions for Basic Calculator II.
// Memory Usage: 37.7 MB, less than 88.49% of Java online submissions for Basic Calculator II.
