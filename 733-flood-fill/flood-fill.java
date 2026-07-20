class Solution {
    int n, m;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];
        if (original == color) {
            return image;
        }

        n = image.length;
        m = image[0].length;

        dfs(sr, sc, image, original, color);

        return image;
    }

    private void dfs(int i, int j, int[][] image, int original, int color) {

        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }

        if (image[i][j] != original) {
            return;
        }

        image[i][j] = color;

        dfs(i + 1, j, image, original, color);
        dfs(i - 1, j, image, original, color);
        dfs(i, j + 1, image, original, color);
        dfs(i, j - 1, image, original, color);
    }
}