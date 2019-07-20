class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length==1) {
            if (flowerbed[0]==0) return n<=1;
            else return n<=0;
        }
        int count = 0;
        for (int i=0; i<flowerbed.length; i++) {
            if (flowerbed[i]==1) {
                ;
            } else { // Mutate input array
                assert (0!=flowerbed.length-1);
                if (i==0) {
                    if (i+1>=flowerbed.length) flowerbed[i]=1;
                    else if (flowerbed[i+1]==0) flowerbed[i]=1;
                } else if (i==flowerbed.length-1) {
                    if (i-1<0) flowerbed[i]=1;
                    else if (flowerbed[i-1]==0) flowerbed[i]=1;
                } else {
                    if (flowerbed[i-1]==0 && flowerbed[i+1]==0) flowerbed[i]=1;
                }
                if (flowerbed[i]==1) count++;
            }
        }
        return n<=count;
    }
}

// Runtime: 2 ms, faster than 13.56% of Java online submissions for Can Place Flowers.
// Memory Usage: 38.3 MB, less than 99.67% of Java online submissions for Can Place Flowers.
