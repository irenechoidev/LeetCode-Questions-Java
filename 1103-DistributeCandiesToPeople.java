class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int idx = 0;
        int distribution = 1;

        while (candies > 0) {

            if (candies - distribution > 0) {
                res[idx] += distribution;
            } else {
                res[idx] += candies;
            }
            idx += 1;

            if (idx >= num_people) {
                idx = 0;
            }

            candies -= distribution;
            distribution += 1;
        }
        return res;
    }
}
