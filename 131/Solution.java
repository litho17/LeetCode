class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new LinkedList<>();
        if (s.length()==0) return ret;
        for (int len=1; len<=s.length(); len++) {
            boolean isPalindrome = true;
            int end = len-1;
            for (int i=0; i<len; i++) {
                if (s.charAt(i)!=s.charAt(len-i-1)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                String nxtStr = s.substring(end+1);
                if (nxtStr.length()==0) {
                    List<String> newList = new LinkedList<>();
                    newList.add(s.substring(0, end+1));
                    ret.add(newList);
                } else {
                    List<List<String>> res = partition(nxtStr);
                    for (List<String> list: res) {
                        List<String> newList = new LinkedList<>();
                        newList.add(s.substring(0, end+1));
                        newList.addAll(list);
                        ret.add(newList);
                    }
                }
            }
        }
        return ret;
    }
}

// Runtime: 10 ms, faster than 5.71% of Java online submissions for Palindrome Partitioning.
// Memory Usage: 46.2 MB, less than 6.82% of Java online submissions for Palindrome Partitioning.
