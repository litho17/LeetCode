class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] s = preorder.split(",");
        return helper(s);
    }
    
    boolean helper(String[] s) {
        boolean[][] dp = new boolean[s.length][s.length]; // dp[i][j]: [i,j] is a valid preorder
        for (int i=s.length-1; i>=0; i--) {
            for (int j=i; j<s.length; j++) {
                if (j==i) dp[i][j] = s[i].equals("#");
                else {
                    if (s[i].equals("#")) dp[i][j] = false;
                    else {
                        boolean isValid = false;
                        for (int k=i+1; k+1<=j; k++) {
                            if (dp[i+1][k]&&dp[k+1][j]) {
                                isValid = true;
                                break;
                            }
                        }
                        dp[i][j] = isValid;
                    }
                }
            }
        }
        return dp[0][s.length-1];
    }
}

// Runtime: 955 ms, faster than 5.57% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
// Memory Usage: 45.3 MB, less than 12.50% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
