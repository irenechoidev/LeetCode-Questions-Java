class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            dfs(result, i, n);
        }

        return result;
    }

    private void dfs(List<Integer> result, int num, int bound) {
        if (num > bound)
            return;

        result.add(num);

        for (int i = 0; i < 10; i++) {
            dfs(result, num * 10 + i, bound);
        }
    }
}
