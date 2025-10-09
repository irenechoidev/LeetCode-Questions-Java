class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);

            List<Integer> prevRow = result.get(i - 1);
            for (int j = 1; j < prevRow.size(); j++) {
                temp.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            temp.add(1);

            result.add(temp);
        }
        return result;
    }
}