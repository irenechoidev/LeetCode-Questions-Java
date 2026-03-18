class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] strs = text.split(" ");
        for (int i = 2; i < strs.length; i++) {
            if (strs[i - 2].equals(first) && strs[i - 1].equals(second)) {
                list.add(strs[i]);
            }
        }
        return listToArr(list);
    }

    private String[] listToArr(List<String> list) {
        String[] res = new String[list.size()];
        int idx = 0;
        for (String s : list) {
            res[idx] = s;
            idx += 1;
        }
        return res;
    }
}