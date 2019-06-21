class Solution {
    public int reachNumber(int target) {
        if (target==1 || target==-1) return 1;
        Map<Integer, Integer> map = new HashMap<>(); // (k, v): Number of steps v to reach location k
        map.put(1, 1);
        int i = 2;
        while (true) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int k = entry.getKey();
                int v = entry.getValue();
                if(k+i==target || k+i==-target || k-i==target || k-i==-target) return i;
                newMap.put(k+i, i);
                newMap.put(k-i, i);
            }
            map = newMap;
            i++;
            // System.out.println(map);
        }
    }
}

// Solution 1: Find i s.t. sum(1,i)≤target and sum(1,i+1)>target. Then use (i,i+1) or (i,i-1) to move right/left 1 step starting from location sum(1,i) or location sum(1,i+1), until finally reach the target location.
// Solution 2: Dynamic programming doesn't seem to work.
// Solution 3: Compute all possible locations till step i, until we reach the target location
