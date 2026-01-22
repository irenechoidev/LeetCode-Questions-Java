class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int start = 0;
        int end = people.length - 1;
        while (start <= end) {
            if (people[start] + people[end] <= limit) {
                start += 1;
                end -= 1;
            } else {
                end -= 1;
            }
            res += 1;
        }
        return res;
    }
}
