class Solution {
    public boolean validUtf8(int[] data) {
        for (int i=0; i<data.length; i++) {
            data[i] = data[i]&0xff;
        }
        return helper(data, 0);
    }
    
    boolean helper(int[] data, int start) {
        if (start==data.length) return true;
        int d = data[start];
        if (d<0x80) {
            return helper(data, start+1);
        } else if (d>=0xc0 && d<0xe0) {
            if (start+1>=data.length) return false;
            int d1 = data[start+1];
            if (d1>=0x80 && d1<0xc0) return helper(data, start+2);
            else return false;
        } else if (d>=0xe0 && d<0xf0) {
            if (start+2>=data.length) return false;
            int d1 = data[start+1];
            int d2 = data[start+2];
            if (d1>=0x80 && d1<0xc0 && d2>=0x80 && d2<0xc0) return helper(data, start+3);
            else return false;
        } else if (d>=0xf0 && d<0xf8) {
            if (start+3>=data.length) return false;
            int d1 = data[start+1];
            int d2 = data[start+2];
            int d3 = data[start+3];
            if (d1>=0x80 && d1<0xc0 && d2>=0x80 && d2<0xc0 && d3>=0x80 && d3<0xc0) return helper(data, start+4);
            else return false;
        } else return false;
    }
}

// Runtime: 1 ms, faster than 99.73% of Java online submissions for UTF-8 Validation.
// Memory Usage: 39.1 MB, less than 54.55% of Java online submissions for UTF-8 Validation.
