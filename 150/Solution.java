class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+")||token.equals("-")||token.equals("*")||token.equals("/")) {
                int op1 = stack.pop();
                int op2 = stack.pop();
                // System.out.println(op1+" "+op2+" "+token);
                if (token.equals("+")) stack.push(op1+op2);
                else if (token.equals("-")) stack.push(op2-op1); // Note: should not do op1-op2, because subtraction is not commutative
                else if (token.equals("*")) stack.push(op1*op2);
                else if (token.equals("/")) stack.push(op2/op1); // Division is not commutative
                else assert(false);
            } else {
                int num = Integer.parseInt(token);
                stack.push(num);
            }
        }
        assert(stack.size()==1);
        return stack.pop();
    }
}

// Runtime: 6 ms, faster than 79.72% of Java online submissions for Evaluate Reverse Polish Notation.
// Memory Usage: 36.2 MB, less than 99.38% of Java online submissions for Evaluate Reverse Polish Notation.
