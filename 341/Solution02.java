/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<Integer> list;
    int idx;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<Integer>();
        traverse(nestedList);
        idx = 0;
        // Collections.reverse(list);
    }
    
    void traverse(List<NestedInteger> nestedList) {
        for (NestedInteger ni: nestedList) {
            if (ni.isInteger()) {
                list.add(ni.getInteger());
            } else {
                traverse(ni.getList());
            }
        }
    }
    
    void traverse(List<NestedInteger> nestedList) {
        Stack<List<NestedInteger>> stack = new Stack<>();
        stack.push(nestedList);
        while (!stack.isEmpty()) {
            List<NestedInteger> nl = stack.pop();
            if (nl.size() == 1) {
                NestedInteger ni = nl.get(0);
                if (ni.isInteger()) {
                    list.add(ni.getInteger()); // When there is only one level of nestedness, do not push to stack(To ensure termination)
                    continue;
                }
            }
            for (NestedInteger ni: nl) {
                if (ni.isInteger()) {
                    List<NestedInteger> l = new LinkedList<NestedInteger>();
                    l.add(ni);
                    stack.push(l); // Add one level of nestedness
                } else {
                    stack.push(ni.getList()); // Peel off one level of nestedness
                }
            }
        }
    }

    @Override
    public Integer next() {
        return list.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx<=list.size()-1;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Your runtime beats 1.07 % of java submissions.
// This is a while-loop version of the recursion in Solution.java. I thought this would be faster, but it turned out that this was not the case.
