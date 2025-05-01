public int maxDepth(String s) {
       
    int depth = 0;
    int result = 0;

    for (int c: s.toCharArray()) {
        if (c == '(') {
            depth += 1;
            result = Math.max(result, depth);
        } else if (c == ')') {
            depth -= 1;
        } 
    }

    return result;
}
}
