class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int targetPtr = 0;

        for (int i = 1; i <= n && targetPtr < target.length; i++) {
            res.add("Push");

            if (target[targetPtr] == i) {
                targetPtr += 1;
            } else {
                res.add("Pop");
            }
        }
        return res;
    }
}