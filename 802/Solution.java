class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] colors = new int[graph.length];
        boolean[] exclude = new boolean[graph.length];
        while (true) {
            int idxOfWhite = -1;
            for (int i=0; i<graph.length; i++) {
                if (colors[i] == 0) {
                    idxOfWhite = i;
                    break;
                }
            }
            if (idxOfWhite != -1) {
                helper(colors, graph, idxOfWhite, exclude);
            }
            else {
                break;
            }
        }
        List<Integer> ret = new LinkedList<>();
        for (int i=0; i<graph.length; i++) {
            if (!exclude[i]) ret.add(i);
        }
        return ret;
    }
    
    // 0: white
    // 1: grey
    // 2: black
    void helper(int[] colors, int[][] graph, int node, boolean[] exclude) {
        colors[node] = 1;
        for (int neighbor: graph[node]) {
            if (colors[neighbor] == 0) {
                helper(colors, graph, neighbor, exclude);
            }
            if (colors[neighbor] == 1 || exclude[neighbor]) {
                // Find all grey nodes
                for (int i=0; i<colors.length; i++) {
                    if (colors[i]==1) exclude[i] = true;
                }
            }
        }
        colors[node] = 2;
    }
}

// Runtime: 507 ms, faster than 5.01% of Java online submissions for Find Eventual Safe States.
// Memory Usage: 64 MB, less than 100.00% of Java online submissions for Find Eventual Safe States.
