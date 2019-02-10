class Solution {
    class Result {
        char res;
        char carry;
        
        public Result(char res, char carry) {
            this.res = res;
            this.carry = carry;
        }
    }
    
    public String addBinary(String a, String b) {
        assert (a!="" && b!="");
        char[] c1 = a.length()<b.length() ? a.toCharArray() : b.toCharArray();
        char[] c2 = a.length()<b.length() ? b.toCharArray() : a.toCharArray();
        
        char[] ret = new char[c2.length+1];
        int pos = c2.length;
        char carry = '0';
        for (int i=c1.length-1; i>=0; i--) { // c1 is shorter
            int c2Idx = i+c2.length-c1.length;
            Result r = add(c1[i], c2[c2Idx], carry);
            carry = r.carry;
            ret[pos] = r.res;
            pos--;
        }
        
        for (int i=c2.length-c1.length-1; i>=0; i--) {
            Result r = add('0', c2[i], carry);
            carry = r.carry;
            ret[pos] = r.res;
            pos--;
        }
        
        assert(pos == 0);
        if (carry == '0') {
            ret[pos] = '0';
            return String.valueOf(ret).substring(1);
        } else {
            ret[pos] = '1';
            return String.valueOf(ret);
        }
    }
    
    Result add(char a, char b, char carry) {
        if (carry == '0') {
            if (a == '0') {
                if (b == '0') {
                    return new Result('0', '0');
                } else {
                    assert (b == '1');
                    return new Result('1', '0');
                }
            } else {
                assert (a == '1');
                if (b == '0') {
                    return new Result('1', '0');
                } else {
                    assert (b == '1');
                    return new Result('0', '1');
                }
            }
        } else {
            assert (carry == '1');
            if (a == '0') {
                if (b == '0') {
                    return new Result('1', '0');
                } else {
                    assert (b == '1');
                    return new Result('0', '1');
                }
            } else {
                assert (a == '1');
                if (b == '0') {
                    return new Result('0', '1');
                } else {
                    assert (b == '1');
                    return new Result('1', '1');
                }
            }
        }
    }
}

// Runtime: 2 ms, faster than 96.22% of Java online submissions for Add Binary.
// Memory Usage: 26.1 MB, less than 23.60% of Java online submissions for Add Binary.
