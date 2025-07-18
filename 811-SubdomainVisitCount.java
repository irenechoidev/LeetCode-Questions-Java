class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] arr = cpdomain.split(" ");

            int visits = Integer.valueOf(arr[0]);
            String parent = arr[1];

            map.put(parent, map.getOrDefault(parent, 0) + visits);

            for (int i = 0; i < parent.length(); i++) {
                if (parent.charAt(i) == '.') {
                    String child = parent.substring(i + 1);
                    map.put(child, map.getOrDefault(child, 0) + visits);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            res.add(entry.getValue() + " " + entry.getKey());
        }

        return res;
    }
}
