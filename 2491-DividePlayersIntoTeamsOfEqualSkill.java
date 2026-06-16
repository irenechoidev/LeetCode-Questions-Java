class Solution {
    public long dividePlayers(int[] skill) {
        long res = 0;

        Arrays.sort(skill);

        int start = 0;
        int end = skill.length - 1;

        int prev = skill[start] + skill[end];
        while (start < end) {
            if (skill[start] + skill[end] == prev) {
                res += (skill[start] * skill[end]);
                start += 1;
                end -= 1;
            } else {
                return -1;
            }
        }
        return res;
    }
}