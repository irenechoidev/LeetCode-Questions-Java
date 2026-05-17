class Solution {
    public String sortSentence(String s) {

        String[] arr = s.split(" ");
        String[] res = new String[arr.length];

        for (String str : arr) {
            int idx = (int) (str.charAt(str.length() - 1) - '0') - 1;
            String curr = str.substring(0, str.length() - 1);
            res[idx] = curr;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(res[i]);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();

    }
}