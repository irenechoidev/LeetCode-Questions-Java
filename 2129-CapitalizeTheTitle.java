class Solution {
    public String capitalizeTitle(String title) {
        String[] str = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {

            if (str[i].length() <= 2) {
                sb.append(str[i].toLowerCase());
            } else {
                sb.append(Character.toUpperCase(str[i].charAt(0)));
                sb.append(str[i].toLowerCase().substring(1));
            }

            if (i != str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}