class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();

        for (String op : ops) {
            if (op.equals("C")) {
                st.pop();
            } 
            else if (op.equals("D")) {
                st.push(2 * st.peek());
            } 
            else if (op.equals("+")) {
                int top = st.pop();
                int sum = top + st.peek();
                st.push(top);      // put removed element back
                st.push(sum);
            } 
            else {
                st.push(Integer.parseInt(op));
            }
        }

        int sum = 0;
        while (!st.isEmpty()) {
            sum += st.pop();
        }

        return sum;
    }
}