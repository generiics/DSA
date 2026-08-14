
class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] left = findPreviousSmaller(nums);
        int[] right = findNextSmaller(nums);
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int l = left[i] + 1;
            int r = right[i] - 1;
            long sum = prefix[r + 1] - prefix[l];
            long product = sum * nums[i];
            ans = Math.max(ans, product);
        }
        return (int) (ans % 1000000007);
    }

    private int[] findPreviousSmaller(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() &&
                   nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = st.peek();
            }
            st.push(i);
        }
        return left;
    }

    private int[] findNextSmaller(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() &&
                   nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = st.peek();
            }
            st.push(i);
        }
        return right;
    }
}