class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int r = 0;
        for (int house: houses) {
            int left = 0;  // Index of the closest left heater
            int right = 0; // Index of the closest right heater
            boolean leftExists = false; // If true, left's value is the closest index 
            boolean rightExists = false;
            for (int i=0; i<heaters.length; i++) {
                if (leftExists && rightExists) break;
                if (heaters[i]<house) {
                    if (i==heaters.length-1 || heaters[i+1]>house) {
                        leftExists = true;
                        left = heaters[i];
                    }
                } else if (heaters[i]==house) {
                    leftExists = true;
                    rightExists = true;
                    left = house;
                    right = house;
                    break;
                } else {
                    if (i==0 || heaters[i-1]<house) {
                        rightExists = true;
                        right = heaters[i];
                    }
                }
            }
            int min;
            if (leftExists) {
                if (rightExists) {
                    min = house-left<right-house ? house-left : right-house;
                } else {
                    min = house-left;
                }
            } else {
                if (rightExists) {
                    min = right-house;
                } else {
                    assert(false);
                    min = 0;
                }
            }
            r = r>=min ? r : min;
        }
        return r;
    }
}

// Runtime: 740 ms, faster than 5.40% of Java online submissions for Heaters.
// Memory Usage: 40.2 MB, less than 95.08% of Java online submissions for Heaters.

// Optimization: I could use binary-search to look for the left/right cloeset heater to a given house (instead of traversing the whole array), since the heater array is already sorted.
