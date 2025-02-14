class Solution {
    public List<Integer> getRow(int rowIndex) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for (int i = 1; i <= rowIndex; i++) {

            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            List<Integer> prevRow = result.get(i - 1);
            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }

            currentRow.add(1);
            result.add(currentRow);
        }
        return result.get(result.size() - 1);

    }
}