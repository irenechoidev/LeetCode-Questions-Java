class Solution {
    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        int result = 0;

        // 모든 숫자를 set 에 넣을 껀데 그러면서 조건을 중간에 check를 한다
        for (int i : nums) {

            // (sorting을 했다면
            // constraints 에서 k>=0 이면
            // i-k 는 항상 pair 에서 smaller number라서
            // if condition 하나. 그러니까-
            // if ( set.contains(num - k) && !seen.contains(num)) {
            // seen.add(num);
            // } 만 해 주면 됨)

            // 만약 set 에 i-k 이 있으면 (i-k, i) pair
            // pair 중 작은쪽에 있는 숫자(i-k)가 seen 에 있는지 보고 없으면 seen에 넣는다
            if (set.contains(i - k) && !seen.contains(i - k)) {
                seen.add(i - k);
                result += 1;
            }

            // 만약 set 에 i+k 가 있으면 (i, i+k) pair
            // pair 중 작은쪽에 있는 숫자(i)가 seen 에 있는지 보고 없으면 seen에 넣는다
            if (set.contains(i + k) && !seen.contains(i)) {
                seen.add(i);
                result += 1;
            }

            set.add(i);
        }

        return result;
    }
}
