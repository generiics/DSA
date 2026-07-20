class Solution {

    int n, m;
    boolean[][] vis;
    public int countIslands(int[][] grid, int k) {

        n = grid.length;
        m = grid[0].length;
        vis = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 && !vis[i][j]) {

                    long sum = dfs(i, j, grid);

                    if (sum % k == 0)
                        count++;
                }
            }
        }

        return count;
    }
    private long dfs(int i, int j, int[][] grid) {

        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;

        if (grid[i][j] == 0 || vis[i][j])
            return 0;
        vis[i][j] = true;
        long sum = grid[i][j];
        sum += dfs(i + 1, j, grid);
        sum += dfs(i - 1, j, grid);
        sum += dfs(i, j + 1, grid);
        sum += dfs(i, j - 1, grid);
        return sum;
    }
}