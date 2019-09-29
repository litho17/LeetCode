class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch>='0' && ch<='9') sb.append(ch);
            else if (ch>='a' && ch<='z') sb.append(ch);
            else if (ch>='A' && ch<='Z') sb.append((char)(ch+'a'-'A'));
        }
        String p = sb.toString();
        int len = p.length();
        if (len==0) return true;
        for (int i=0; i<=len/2; i++) {
            if (p.charAt(i)!=p.charAt(len-1-i)) return false;
        }
        return true;
    }
}

// Runtime: 3 ms, faster than 95.97% of Java online submissions for Valid Palindrome.
// Memory Usage: 37.7 MB, less than 96.43% of Java online submissions for Valid Palindrome.
