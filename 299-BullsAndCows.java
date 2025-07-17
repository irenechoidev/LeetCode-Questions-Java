class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;

        int[] digits = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bulls += 1;
            } else {
                digits[s] += 1;
            }
        }

        for (int i = 0; i < guess.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s != g && digits[g] > 0) {
                cows += 1;
                digits[g] -= 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append('A').append(cows).append('B');

        return sb.toString();

    }
}