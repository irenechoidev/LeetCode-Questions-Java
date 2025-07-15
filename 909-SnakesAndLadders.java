class Solution {
    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        set.add(1);

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == m * n)
                    return res;

                for (int j = 1; j <= 6; j++) {
                    int next = Math.min(curr + j, m * n);
                    int[] nextCoord = getCoord(board, next);

                    if (board[nextCoord[0]][nextCoord[1]] != -1) {
                        next = board[nextCoord[0]][nextCoord[1]];
                    }

                    if (!set.contains(next)) {
                        set.add(next);
                        queue.add(next);
                    }

                }
            }
            res += 1;
        }
        return -1;
    }

    private int[] getCoord(int[][] board, int square) {
        int m = board.length;
        int n = board[0].length;

        int i = (square - 1) / m;
        int j = (square - 1) % n;

        if (i % 2 == 1) {
            j = n - j - 1;
        }
        i = m - i - 1;
        return new int[] { i, j };
    }
}
