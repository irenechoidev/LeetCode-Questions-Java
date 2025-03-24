class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");

        for (String dir : split) {
            if (dir.length() == 0)
                continue;
            else if (dir.equals("."))
                continue;

            else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {
                stack.push(dir);
            }
        }

        StringBuilder sb = new StringBuilder();
        Stack<String> tempStack = new Stack<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        while (!tempStack.isEmpty()) {
            sb.append("/" + tempStack.pop());
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
