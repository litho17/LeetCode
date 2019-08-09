class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len==0) return 0;
        int gasSum = 0;
        int costSum = 0;
        for (int i=0; i<len; i++) {
            gasSum  += gas[i];
            costSum += cost[i];
        }
        if (gasSum<costSum) return -1;
        for (int i=0; i<len; i++) {
            int curGas = gas[i];    // # of gas at station j
            int j = i;              // current station
            int count = 1;          // # of visited stations
            while (count<len) {
                // Move to next station
                int remaining = curGas-cost[j];
                if (remaining<0) break;
                j = j==len-1 ? 0 : j+1;
                curGas = remaining+gas[j];
                count++;
            }
            if (count==len && curGas>=cost[i-1<0 ? len-1 : i-1]) return i;
        }
        return -1;
    }
}

// Runtime: 34 ms, faster than 24.13% of Java online submissions for Gas Station.
// Memory Usage: 38.5 MB, less than 27.45% of Java online submissions for Gas Station.

