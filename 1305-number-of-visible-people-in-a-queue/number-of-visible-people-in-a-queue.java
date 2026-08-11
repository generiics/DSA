class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ngr = new int[n];
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (!st.isEmpty() && heights[st.peek()] < heights[i]) {
                st.pop();
                count++;
            }
            if (!st.isEmpty()) {
                ngr[i] = st.peek();
                count++;
            } else {
                ngr[i] = -1;
            }
            ans[i] = count;
            st.push(i);
        }
        return ans;
    }
}