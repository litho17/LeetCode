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
    Iterator<Integer> it;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<Integer>();
        traverse(nestedList);
        it = list.iterator();
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
    
    @Override
    public Integer next() {
        return it.next();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Runtime: 2 ms, faster than 100.00% of Java online submissions for Flatten Nested List Iterator.
// Memory Usage: 29.1 MB, less than 2.43% of Java online submissions for Flatten Nested List Iterator.
// This is faster only because I have used the itertor API from Java library (compared with Solution.java), which is actually not a satisfying solution
