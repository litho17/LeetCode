class Solution {
    class Node {
        List<Node> children;
        int inDegree;
        public Node() {
            this.children = new LinkedList<>();
            this.inDegree = 0;
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Node> nodes = new LinkedList<>();
        int[] colors = new int[numCourses]; // 0: white; 1: grey; 2: black
        for (int i=0; i<numCourses; i++) {
            nodes.add(new Node());
        }
        for (int[] pre: prerequisites) {
            Node from = nodes.get(pre[1]);
            Node to = nodes.get(pre[0]);
            from.children.add(to);
            to.inDegree++;
        }
        List<Integer> ret = new LinkedList<>();
        for (int i=0; i<numCourses; i++) {
            if (nodes.get(i).inDegree == 0) {
                boolean res = helper(i, nodes, colors, ret);
                if (res) return new int[0];
            }
        }
        for (int color: colors) {
			// If there exists a white node, then it is not a root node and it cannot be reached from any root nodes. Hence, it is in a cycle.
            if (color == 0) return new int[0];
        }
        assert (ret.size() == numCourses);
        int[] _ret = new int[numCourses];
        for (int i=0; i<numCourses; i++) {
            _ret[i] = ret.get(numCourses-1-i);
        }
        return _ret;
    }

    // Return true iff. there exists a cycle
    boolean helper(int idx, List<Node> nodes, int[] colors, List<Integer> ret) {
        if (colors[idx] == 2) return false;
        else if (colors[idx] == 1) return true;
        else {
            colors[idx] = 1;
            Node node = nodes.get(idx);
            for (int i=0; i<node.children.size(); i++) {
                boolean res = helper(nodes.indexOf(node.children.get(i)), nodes, colors, ret);
                if (res) return true;
            }
            colors[idx] = 2;
			// When finishing visiting a node, keep record of its id in the ret array, who is a reverse topological order of all nodes
            ret.add(idx);
            return false;
        }
    }
}

// Runtime: 67 ms, faster than 5.26% of Java online submissions for Course Schedule II.
// Memory Usage: 53.6 MB, less than 6.10% of Java online submissions for Course Schedule II.
