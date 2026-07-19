class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(i, j, grid));
                }
            }
        }

        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return 0;

        if (grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;

        int left = dfs(i, j - 1, grid);
        int right = dfs(i, j + 1, grid);
        int up = dfs(i - 1, j, grid);
        int down = dfs(i + 1, j, grid);

        return 1 + left + right + up + down;
    }
}