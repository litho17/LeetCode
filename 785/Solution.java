class Solution {
	public boolean isBipartite(int[][] graph) {
		Node[] nodes = new Node[graph.length];
		for (int i=0; i<graph.length; i++) {
			nodes[i] = new Node(i);
		}
		for (int i=0; i<graph.length; i++) {
			Node p1 = Node.find(nodes[i]);
			if (graph[i].length==0) continue;
			Node p2 = Node.find(nodes[graph[i][0]]);
			if (p1 == p2) return false;
			for (int j=1; j<graph[i].length; j++) {
				Node p3 = Node.find(nodes[graph[i][j]]);
				if (p1 == p3) return false;
				else p3.parent = p2;
			}
		}
		return true;
	}
}

class Node {
	int val;
	Node parent;
	public Node(int val) {
		this.val = val;
		this.parent = this;
	}

	static Node find(Node n2) {
		Node p = n2;
		while (p.parent != p) {
			p = p.parent;
		}
		return p;
	}
}


// Runtime: 1 ms, faster than 65.55% of Java online submissions for Is Graph Bipartite?.
// Memory Usage: 44.4 MB, less than 63.42% of Java online submissions for Is Graph Bipartite?.

// My timeout solution was to maintain two disjoint sets while traversing all neighbors of each node. This solution was more expensive because
// 1. It may need to backtrack when there are more than 1 possible two new disjoint sets after visiting all neighbors of the current node. The root cause of the need of backtracking is that, this algorithm requires maintaining 2 disjoint sets while Union-Find allows arbitrary number of disjoint sets.
// 2. Set union is more expensive than the union operation in Union-Find
