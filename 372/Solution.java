class Solution {
    public int superPow(int a, int[] b) {
        assert(b.length>0);
        if (a==1) return 1;
        int[] res = new int[1337]; // There are at most 1337 possibilities for the result of n%1337
        a=a%1337;
        int i=2;
        int tmp=(a*a)%1337;
        res[0]=1;
        res[1]=a;
        res[2]=tmp;
        boolean foundRepeat=false;
        int start=-1;
        int end=-1;
        while (!foundRepeat) {
            tmp=(tmp*a)%1337;
            i++;
            res[i]=tmp;
            // Invariant: tmp=(a^i)%1337
            for (int j=0; j<i; j++) {
                if (res[j]==tmp) {
                    foundRepeat=true;
                    start=j;
                    end=i-1;
                    break;
                }
            }
        }
        assert (end>start);
        int repeat=end-start+1;
        // Compute b%repeat
        int pow=b[b.length-1];
        int mod=1;
        for (int j=1; j<b.length; j++) {
            mod=(mod*10)%repeat; // (10^j)%repeat
            pow=(pow+mod*b[b.length-1-j])%repeat;
        }
        /*System.out.println(i+" "+pow);
        System.out.println(start+" "+end);
        for (int j=0; j<1337; j++) {
            if (res[j]==387) System.out.println(j);
        }*/
        return res[pow];
    }
}

// Runtime: 2 ms, faster than 89.97% of Java online submissions for Super Pow.
// Memory Usage: 38.2 MB, less than 66.67% of Java online submissions for Super Pow.

