class Solution {
    public int[] findEvenNumbers(int[] digits) {

        HashSet<Integer> set = new HashSet<>();
        int n = digits.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {

                    if (i == j || j == k || i == k) continue;
                    int a = digits[i];
                    int b = digits[j];
                    int c = digits[k];
                    if (a == 0) continue;      
                    if (c % 2 != 0) continue;   

                    int num = a * 100 + b * 10 + c;

                    set.add(num);
                }
            }
        }

        int[] ans = new int[set.size()];
        int idx = 0;
        for (int num : set) {
            ans[idx++] = num;
        }
        Arrays.sort(ans); 

        return ans;
    }
}