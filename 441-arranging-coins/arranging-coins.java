class Solution {
    public int arrangeCoins(int n) {
        int row = 1;
        int count = 0;
        int step = 1;

        while (n >= step) {
            n -= step;
            count++;
            row++;
            step++;
        }

        return count;
    }
}