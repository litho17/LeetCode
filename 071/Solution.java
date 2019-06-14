class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack();
        assert(path.charAt(0)=='/');
        StringBuilder filename = new StringBuilder();
        for (int i=1; i<=path.length(); i++) {
            char c = i<path.length() ? path.charAt(i) : '/';
            if (c == '/') { // State: Ready for a new directory name
                // Do this when (1) there will be more '/' in the input (2) the input does not end with '/'
                String fn = filename.toString();
                if (fn.equals(".")) {
                    ;
                } else if (fn.equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                } else {
                    if (fn.length()>0) stack.push(fn);
                }
                filename = new StringBuilder();
            } else { // State: Ready for more characters (except '/') to be appended in order to construct a file name
                filename.append(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            String s = stack.pop();
            for (int i=s.length()-1; i>=0; i--)
                sb.append(s.charAt(i));
            sb.append('/');
        }
        if (sb.length() == 0) sb.append('/'); // If stack is empty, it means we are at the root directory
        return sb.reverse().toString();
    }
}

// Runtime: 4 ms, faster than 91.79% of Java online submissions for Simplify Path.
// Memory Usage: 38.8 MB, less than 44.91% of Java online submissions for Simplify Path.
