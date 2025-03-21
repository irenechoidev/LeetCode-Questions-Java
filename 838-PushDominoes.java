class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forceArr = new int[n];
        int force = 0;

        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'L') {
                force = 0;
            } else if (dominoes.charAt(i) == 'R') {
                force = n;
            } else {
                force = Math.max(0, force - 1);
            }
            forceArr[i] += force;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = n;
            } else if (dominoes.charAt(i) == 'R') {
                force = 0;
            } else {
                force = Math.max(0, force - 1);
            }
            forceArr[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : forceArr) {
            if (f == 0) {
                sb.append('.');
            } else if (f > 0) {
                sb.append('R');
            } else {
                sb.append('L');
            }
        }
        return sb.toString();
    }
}
