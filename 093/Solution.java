class Solution {
    public List<String> restoreIpAddresses(String s) {
        char[] ary = s.toCharArray();
        List<String> res = new LinkedList<>();
        if (ary.length<4) return res;
        helper(ary, 1, new LinkedList<Integer>(), res);
        return res;
    }
    
    // n-th digit of dots.size()-th segment, where 1≤n≤3
    // dots.get(i): last index of (i+1)-th segment
    void helper(char[] ary, int n, List<Integer> dots, List<String> res) {
        assert (1<=n&&n<=3&&dots.size()<=3);
        int lstIdx = dots.size()==0 ? -1 : dots.get(dots.size()-1);
        int curIdx = lstIdx+n;
        if (dots.size()==3) {
            if (isValid(ary, lstIdx+1, ary.length-1)) {
                StringBuilder sb = new StringBuilder();
                dots.add(ary.length-1);
                int lstDot = -1;
                for (int i=0; i<dots.size(); i++) {
                    Integer dot = dots.get(i);
                    for (int j=lstDot+1; j<=dot; j++) {
                        sb.append(ary[j]);
                    }
                    lstDot = dot;
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length()-1);
                res.add(sb.toString());
                dots.remove(dots.size()-1);
            }
            return;
        }
        // Finish current segment
        int totalLen = lstIdx+1;
        // if (isValid(ary, lstIdx+1, curIdx) && (3-dots.size())*3+totalLen>=ary.length && 3-dots.size()+totalLen<=ary.length && dots.size()<=3) {
        if (isValid(ary, lstIdx+1, curIdx) && dots.size()<=3) {
            dots.add(curIdx);
            helper(ary, 1, dots, res);
            dots.remove(dots.size()-1);
        }
        // Not finish current segment
        if (n<3 && dots.size()<=3) {
            helper(ary, n+1, dots, res);
        }
    }
    
    boolean isValid(char[] ary, int start, int end) {
        int len = end-start+1;
        if (len>3 || len<1 || start<0 || end>=ary.length) return false;
        if (len==1) {
            return true;
        } else if (len==2) {
            if (ary[start]=='0') return false;
            else return true;
        } else {
            if (ary[start]>('0'+2)) return false;
            else if (ary[start]=='0') {
                return false;
            } else if (ary[start]=='1') {
                return true;
            } else {
                if (ary[start+1]>('0'+5)) return false;
                else {
                    if (ary[start+1]=='5'&&ary[start+2]>('0'+5)) return false;
                    else return true;
                }
            }
        }
    }
}

// Runtime: 2 ms, faster than 90.37% of Java online submissions for Restore IP Addresses.
// Memory Usage: 36.6 MB, less than 99.57% of Java online submissions for Restore IP Addresses.
