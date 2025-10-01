class Solution {

    Set<String> visited = new HashSet<>();
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    public List<List<String>> accountsMerge(List<List<String>> accountList) {

        for (List<String> account : accountList) {
            int n = account.size();

            String accountFirstEmail = account.get(1);
            for (int j = 2; j < n; j++) {
                String accountEmail = account.get(j);

                map.putIfAbsent(accountFirstEmail, new ArrayList<String>());
                map.get(accountFirstEmail).add(accountEmail);

                map.putIfAbsent(accountEmail, new ArrayList<String>());
                map.get(accountEmail).add(accountFirstEmail);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (List<String> account : accountList) {
            String accountName = account.get(0);
            String accountFirstEmail = account.get(1);

            if (!visited.contains(accountFirstEmail)) {
                List<String> temp = new ArrayList<>();
                temp.add(accountName);

                dfs(temp, accountFirstEmail);
                Collections.sort(temp.subList(1, temp.size()));
                result.add(temp);
            }
        }

        return result;
    }

    private void dfs(List<String> accountEmails, String firstEmail) {
        visited.add(firstEmail);
        accountEmails.add(firstEmail);

        if (!map.containsKey(firstEmail)) {
            return;
        }

        List<String> adjacents = map.get(firstEmail);
        for (String adj : adjacents) {
            if (!visited.contains(adj)) {
                dfs(accountEmails, adj);
            }
        }
    }
}