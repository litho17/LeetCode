class Solution {
    class Term {
        int coeff;
        int constant;
        public Term(int coeff, int constant) {
            this.coeff = coeff;
            this.constant = constant;
        }
    }
    
    public String solveEquation(String equation) {
        String[] exprs = equation.split("=");
        assert (exprs.length==2);
        Term t1 = helper(exprs[0]);
        Term t2 = helper(exprs[1]);
        int coeff = t1.coeff-t2.coeff;
        int constant = t2.constant-t1.constant;
        if (coeff==0) {
            if (constant==0) return "Infinite solutions";
            else return "No solution";
        } else {
            return "x="+Integer.toString(constant/coeff);
        }
    }
    
    Term helper(String expr) {
        int coeff = 0;
        int constant = 0;
        String[] addItems = expr.split("\\+");
        assert (addItems.length>=1);
        for (String addItem: addItems) {
            // System.out.println(addItem);
            String[] items = addItem.split("-");
            assert (items.length>=1);
            for (int i=0; i<items.length; i++) {
                String item = items[i];
                // System.out.println(item);
                if (item.endsWith("x")) {
                    String a = item.substring(0, item.length()-1);
                    int b = a.length()==0 ? 1 : Integer.parseInt(a);
                    coeff = i==0 ? coeff+b : coeff-b;
                } else {
                    if (item.length()>0) {
                        int b = Integer.parseInt(item);
                        constant = i==0 ? constant+b : constant-b;
                    }
                }
            }
        }
        return new Term(coeff, constant);
    }
}

// Runtime: 2 ms, faster than 62.42% of Java online submissions for Solve the Equation.
// Memory Usage: 34.3 MB, less than 100.00% of Java online submissions for Solve the Equation.

