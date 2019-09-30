class Solution {
	class Result {
		Set<String> val; // Each String here must not be empty and must not contain leading/trailing spaces
		public Result() {
			this.val = new HashSet<String>();
		}
		Set<String> cartesianProduct(Result other) {
			Set<String> ret = new HashSet<>();
			// if (val.isEmpty() || other.val.isEmpty()) return ret;
			for (String s1: val) {
				for (String s2: other.val) {
					ret.add(s1+" "+s2);
				}
			}
			return ret;
		}
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		int len = s.length();
		List<String> ret = new LinkedList<String>();
		if (len==0) return ret;

		Map<String, Result> dp = new HashMap<>();
		Set<String> dict = new HashSet<>();
		dict.addAll(wordDict);
		helper(s, dict, dp);
		ret.addAll(dp.get(s).val);
		return ret;
	}

	void helper(String s, Set<String> wordDict, Map<String, Result> dp) {
		if (dp.get(s) != null) return;

		Result res = new Result();
		if (wordDict.contains(s)) {
			res.val.add(s);
		}

		for (int j=0; j+1<=s.length()-1; j++) {
			String s1 = s.substring(0, j+1);
			String s2 = s.substring(j+1, s.length());
			helper(s1, wordDict, dp);
			helper(s2, wordDict, dp);
			Result res1 = dp.get(s1);
			Result res2 = dp.get(s2);
			res.val.addAll(res1.cartesianProduct(res2));
		}
		dp.put(s, res);
	}
}
