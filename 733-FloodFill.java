class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        dfs(image, sr, sc, color, image[sr][sc], directions);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int oldColor, int[][] directions) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != oldColor)
            return;

        image[sr][sc] = color;
        for (int[] d : directions) {
            dfs(image, sr + d[0], sc + d[1], color, oldColor, directions);
        }
    }
}
