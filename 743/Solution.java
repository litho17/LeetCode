class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int MAX = 6001;
        int[] dist = new int[N+1];
        for (int i=1; i<=N; i++) {
            if (i == K) dist[i] = 0;
            else dist[i] = MAX;
        }
        for (int i=1; i<N; i++) {
            for (int[] time: times) {
                int u = time[0];
                int v = time[1];
                int d = time[2];
                if (dist[v] > dist[u] + d) dist[v] = dist[u] + d;
            }
        }
        int max = 0;
        for (int i=1; i<=N; i++) {
            // System.out.println(i+" "+dist[i]);
            if (dist[i]>max) max = dist[i];
        }
        return max==MAX ? -1 : max;
    }
}

// Bellman Ford algorithm: Wikipedia has a really good explanation
// Reference: https://en.wikipedia.org/wiki/Bellman%E2%80%93Ford_algorithm
