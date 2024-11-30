class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();

        // boolean board 'seen' 을 만들어서 queen들을 다 넣어 놓는다
        boolean[][] seen = new boolean[8][8];
        for (int[] q : queens) {
            seen[q[0]][q[1]] = true;
        }

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 },
                { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

        // king 부터 시작해서 '한 방향씩' 8방향으로 가 보면서 queen이 있으면 result에 넣는다.
        for (int[] d : directions) {
            int row = king[0] + d[0];
            int col = king[1] + d[1];

            // seen 보드 안에서만
            while (row >= 0 && col >= 0 && row < 8 && col < 8) {
                // 만약 queen을 찾았으면 (seen[row][col]이 true면(seen[q[0]][q[1]] = true))
                if (seen[row][col]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(row);
                    temp.add(col);
                    result.add(temp);
                    break;
                }

                row += d[0];
                col += d[1];

            }
        }
        return result;
    }
}