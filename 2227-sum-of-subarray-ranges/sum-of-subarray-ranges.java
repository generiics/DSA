class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;

        int[] ngl = findNgl(nums);
        int[] ngr = findNgr(nums);

        int[] nsl = findNsl(nums);
        int[] nsr = findNsr(nums);

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long leftMax = i - ngl[i];
            long rightMax = ngr[i] - i;
            long maxContribution =(long) nums[i] * leftMax * rightMax;
            long leftMin = i - nsl[i];
            long rightMin = nsr[i] - i;
            long minContribution =(long) nums[i] * leftMin * rightMin;
            ans += maxContribution - minContribution;
        }
        return ans;
    }

    private int[] findNgl(int[] nums) {
        int n = nums.length;
        int[] ngl = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ngl[i] = -1;
            } else {
                ngl[i] = st.peek();
            }
            st.push(i);
        }
        return ngl;
    }

    private int[] findNgr(int[] nums) {
        int n = nums.length;
        int[] ngr = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ngr[i] = n;
            } else {
                ngr[i] = st.peek();
            }
            st.push(i);
        }
        return ngr;
    }

    private int[] findNsl(int[] nums) {
        int n = nums.length;
        int[] nsl = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }
        return nsl;
    }
    
    private int[] findNsr(int[] nums) {
        int n = nums.length;
        int[] nsr = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        return nsr;
    }
}