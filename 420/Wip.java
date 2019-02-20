class Solution {
    public int strongPasswordChecker(String s) {
        if (s.length() <= 2) return 6-s.length();
        
        int toIncDec = 0; // To satisfy Cond1, # of min chars to add/remove
        if (s.length() < 6) toIncDec = 6-s.length();
        else if (s.length() > 20) toIncDec = 20-s.length();
        
        boolean lower = false;
        boolean upper = false;
        boolean digit = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) lower = true;
            else if (Character.isUpperCase(ch)) upper = true;
            else if (Character.isDigit(ch)) digit = true;
        }
        int miss = 0; // To satisfy Cond2, # of min chars to modify/add
        if (!lower) miss++;
        if (!upper) miss++;
        if (!digit) miss++;
        
        int ret = 0;
        char lastChar = s.charAt(0); // lastChar in the valid password
        int count = 1; // # of occurence of lastChar so far
        List<Integer> list = new LinkedList<>();
        // System.out.println(miss + ", " + toIncDec);
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == lastChar) {
                count++;
            } else {
                lastChar = ch;
                if (count >= 3) list.add(count);
                count = 1;
            }
        }
        if (count >= 3) list.add(count);
        
        Collections.sort(list); // ??? Consider "aaaabbaaabbaaa123456A"
        if (toIncDec > 0) {
            // We can only have "aaa", "aaaa" or "aaaaa" => Add 1 char to each of them can make them valid
            ret += miss>toIncDec ? miss : toIncDec;
            miss = 0;
            toIncDec = 0;
        } else if (toIncDec <= 0) {
            for (Integer i: list) {
                if (toIncDec < 0) { // First greedily allocate remove to each sequence of chars
                    if (i > -toIncDec) {
                        ret += -toIncDec;
                        // System.out.println(ret+".");
                        int toReplace = (i+toIncDec)/3; // Then use replace to make the rest sequences valid
                        miss = toReplace>miss ? 0 : miss-toReplace;
                        ret += toReplace;
                        toIncDec = 0;
                        // System.out.println(ret+"..");
                    } else {
                        toIncDec += i;
                        ret += i;
                        // System.out.println(ret+"[");
                    }
                } else { // Then use replace to make the rest sequences valid
                    int toReplace = i/3;
                    miss = toReplace>miss ? 0 : miss-toReplace;
                    ret += toReplace;
                    // System.out.println(ret+"]");
                }
            }
        }
        // We have a password without "aaa", where the valid string is greedily patched in order to satisfy all conditions
        // Now Cond3 is satisfied
        // If Cond1 and/or Cond2 are not satisfied
        if (toIncDec > 0) {
            if (miss > 0) { // Add all missing chars according to Cond2
                ret += toIncDec>miss ? toIncDec : miss;
            } else { // Add random chars to reach a length of 6
                ret += toIncDec;
            }
        } else if (toIncDec < 0) {
            if (miss > 0) {
                ret += -toIncDec+miss;
            } else { // Remove all redundant chars. This won't break Cond2 because the result has more than 20 chars
                ret += -toIncDec;
            }
        } else {
            if (miss > 0) { // Add all missing chars according to Cond2
                ret += miss;
            } else {
                ; // We are good
            }
        }
        
        return ret;
    }
}
