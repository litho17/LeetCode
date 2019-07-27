/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.length()==0) return new NestedInteger();
        Stack<Object> stack = new Stack<>();
        int i = 0;
        while (i<s.length()) {
            char ch = s.charAt(i);
            if (ch=='[') {
                stack.push(ch);
                i++;
            } else if (ch==',') {
                i++;
            } else if (ch==']') {
                NestedInteger ni = new NestedInteger();
                while (!stack.isEmpty()) {
                    Object obj = stack.pop();
                    if (obj instanceof Character) {
                        Character c = (Character)obj;
                        if (c=='[') {
                            break;
                        } else assert(false);
                    } else if (obj instanceof NestedInteger) {
                        ni.add((NestedInteger)obj);
                    } else assert(false);
                }
                Collections.reverse(ni.getList());
                stack.push(ni);
                i++;
            } else {
                int start = i;
                char c = s.charAt(i);
                while ((c>='0'&&c<='9') || c=='-') {
                    i++;
                    if (i>=s.length()) break;
                    c = s.charAt(i);
                }
                Integer num = Integer.parseInt(s.substring(start, i));
                NestedInteger ni = new NestedInteger(num);
                stack.push(ni);
            }
        }
        /*for (Object obj: stack) {
            if (obj instanceof Character) System.out.println((Character)obj);
            else System.out.println((NestedInteger)obj);
        }*/
        NestedInteger ni = (NestedInteger)stack.pop();
        assert(stack.isEmpty());
        return ni;
    }
}

// Runtime: 9 ms, faster than 7.93% of Java online submissions for Mini Parser.
// Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Mini Parser.
