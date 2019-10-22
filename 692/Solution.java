class Solution {
    class Pair {
        int count;
        String word;
        public Pair(int count, String word) {
            this.count = count;
            this.word = word;
        }
    }
    class PairComparator implements Comparator<Pair> {
        public int compare (Pair p1, Pair p2) {
            if (p1.count < p2.count) {
                return 1;
            }
            else if (p1.count > p2.count) {
                return -1;
            }
            else {
                int len1 = p1.word.length();
                int len2 = p2.word.length();
                int minLen = len1<=len2 ? len1 : len2;
                for (int i=0; i<minLen; i++) {
                    if (p1.word.charAt(i) < p2.word.charAt(i)) {
                        return -1;
                    }
                    else if (p1.word.charAt(i) > p2.word.charAt(i)) {
                        return 1;
                    }
                }
                if (len1 == len2) {
                    return 0;
                }
                else {
                    if (minLen == len1) return -1; // TODO: Unspecified
                    else return 1;
                }
            }
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            }
            else {
                map.put(word, count+1);
            }
        }
        PriorityQueue<Pair> p = new PriorityQueue<>(k, new PairComparator());
        for (String word: map.keySet()) {
            Integer count = map.get(word);
            p.add(new Pair(count, word));
        }
        List<String> ret = new LinkedList<>();
        for (int i=0; i<k; i++) {
            Pair pair = p.poll();
            ret.add(pair.word);
        }
        return ret;
    }
}

// Runtime: 6 ms, faster than 96.08% of Java online submissions for Top K Frequent Words.
// Memory Usage: 39.1 MB, less than 67.86% of Java online submissions for Top K Frequent Words.
