class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        // if (s.length()<10) return new LinkedList<String>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i+9<s.length(); i++) {
            String sub = s.substring(i,i+10);
            Integer c = map.get(sub);
            if (c==null) map.put(sub, 1);
            else map.put(sub, c+1);
        }
        List<String> ret = new LinkedList<>();
        for (String sub: map.keySet()) {
            if (map.get(sub)>1) ret.add(sub);
        }
        return ret;
    }
}

// Runtime: 25 ms, faster than 22.18% of Java online submissions for Repeated DNA Sequences.
// Memory Usage: 47.5 MB, less than 67.11% of Java online submissions for Repeated DNA Sequences.

