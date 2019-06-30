class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length==0) return 0;
        int L1 = nums[0]; // 1st large number
        int L2 = -1;      // 2nd large number
        int L3 = -1;      // 3rd large number
        boolean E2 = false; // if 2nd large number exists
        boolean E3 = false; // if 3rd large number exists
        for (int n: nums) {
            if (E3) {
                if (E2) {
                    if (n>L3) {
                        if (n>L2) {
                            if (n>L1) {
                                L3 = L2;
                                L2 = L1;
                                L1 = n;
                            } else if (n<L1) { // Note that, we cannot use "else" here, because it is required that only **distinct** numbers can be considered as maxinum numbers. E.g. [1,2,2] should return 2 instead of 1.
                                L3 = L2;
                                L2 = n;
                            }
                        } else if (n<L2) {
                            L3 = n;
                        }
                    }
                } else {
                    assert(false);
                }
            } else { // E3 = false
                if (E2) {
                    if (n>L2) {
                        if (n>L1) {
                            E3 = true;
                            L3 = L2;
                            L2 = L1;
                            L1 = n;
                        } else if (n<L1) {
                            E3 = true;
                            L3 = L2;
                            L2 = n;
                        }
                    } else if (n<L2) {
                        E3 = true;
                        L3 = n;
                    }
                } else { // E2 = false
                    if (n>L1) {
                        E2 = true;
                        L2 = L1;
                        L1 = n;
                    } else if (n<L1) {
                        E2 = true;
                        L2 = n;
                    }
                }
            }
        }
        // System.out.println(L3+" "+L2+" "+L1);
        return E3 ? L3 : L1;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Third Maximum Number.
// Memory Usage: 38.6 MB, less than 87.13% of Java online submissions for Third Maximum Number.
