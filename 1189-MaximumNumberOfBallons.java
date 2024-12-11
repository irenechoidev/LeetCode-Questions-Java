class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr = new int[26];

        for (int i = 0; i < text.length(); i++) {
            arr[text.charAt(i) - 'a']++;
        }

        int bCount = arr['b' - 'a'];
        int aCount = arr['a' - 'a'];
        // If 'l' count is 1, dividing by 2 gives 0 in integer math (not 0.5).
        int lCount = arr['l' - 'a'] / 2;
        int oCount = arr['o' - 'a'] / 2;
        int nCount = arr['n' - 'a'];

        return Math.min(bCount, Math.min(aCount, Math.min(lCount, Math.min(oCount, nCount))));

    }
}
