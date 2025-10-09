class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String formatted = formatString(email);
            set.add(formatted);
        }
        return set.size();
    }

    private String formatString(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split("@");
        String localName = arr[0];
        String domainName = arr[1];
        for (char c : localName.toCharArray()) {
            if (c == '.')
                continue;
            if (c == '+')
                break;
            sb.append(c);
        }
        sb.append('@');
        sb.append(domainName);
        return sb.toString();
    }
}