class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<String> valStack = new Stack<>();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count = count * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(count);
                count = 0;

                valStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                int times = countStack.pop();
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < times; i++) {
                    temp.append(sb.toString());
                }

                sb = new StringBuilder();
                sb.append(valStack.pop());
                sb.append(temp);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
