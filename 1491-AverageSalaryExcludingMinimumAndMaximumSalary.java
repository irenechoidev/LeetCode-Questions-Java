class Solution {
    public double average(int[] salary) {
        int n = salary.length;
        double max = salary[0];
        double min = salary[0];
        double sum = salary[0];
        for (int i = 1; i < salary.length; i++) {
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            sum += salary[i];

        }
        return (sum - max - min) / (n - 2);
    }
}