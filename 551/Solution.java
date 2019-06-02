class Solution {
    public boolean checkRecord(String s) {
        int countA = 0;
        char last1 = '~';
        char last2 = '~';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'L') {
                if (last1 == 'L' && last2 == 'L') return false;
            } else {
                if (c == 'A') {
                    countA++;
                    if (countA > 1) return false;
                }
            }
            last1 = last2;
            last2 = c;
        }
        return true;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Student Attendance Record I.
// Memory Usage: 33.5 MB, less than 100.00% of Java online submissions for Student Attendance Record I.
