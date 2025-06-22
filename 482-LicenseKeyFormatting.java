class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        // Remove all dashes && Convert letters to uppercase
        String str = reFormatStr(s);

        // Iterate over the reformatted string backwards,
        // adding a dash after every k characters.
        int count = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
            count += 1;
            if (count == k && i > 0) {
                sb.append('-');
                count = 0;
            }
        }
        return sb.reverse().toString();
    }

    // Remove all dashes && Convert letters to uppercase
    private String reFormatStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toUpperCase(c));
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
