class Solution {

    private List<Integer> solveRec(String exp) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '-' || ch == '+' || ch == '*') {
                List<Integer> left = solveRec(exp.substring(0, i));
                List<Integer> right = solveRec(exp.substring(i + 1));
                for (int l : left) {
                    for (int r : right) {
                        if (ch == '+') {
                            list.add(l + r);
                        } else if (ch == '-') {
                            list.add(l - r);
                        } else if (ch == '*') {
                            list.add(l * r);
                        }
                    }
                }
            }
        }

        if (list.size() == 0) {
            list.add(Integer.valueOf(exp));
        }
        return list;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        return solveRec(expression);
    }
}