class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (List<String> ticket : tickets) {
            String dept = ticket.get(0);
            String arrival = ticket.get(1);
            map.putIfAbsent(dept, new PriorityQueue<>());
            map.putIfAbsent(arrival, new PriorityQueue<>());
            map.get(dept).add(arrival);
        }

        List<String> result = new ArrayList<>();
        dfs(result, map, "JFK");
        // JFK공항에서 시작합니다

        return result;
    }

    private void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String node) {
        PriorityQueue<String> adjacents = map.get(node);
        // PriorityQueue에 담으면 lexical 순서대로 뽑을 수 있으니까
        // PriorityQueue heap은 default가 min heap

        while (!adjacents.isEmpty()) {
            // 그러니까 그 공항에서 갈 수 있는 모든 공항을 체크합니다

            dfs(result, map, adjacents.poll());
            // 하나씩, 하나씩 깊이 들어가면서(여기서 여기가고, 여기서 여기가고, 여기서 여기가고 끝까지

        }

        result.add(0, node);
        // 끝에 꺼를 꺼내 놓고, 그 다음꺼는 그 앞에 놓고, 그 다음꺼는 그 앞에 꺼내 놓는 식으로 해서 처음 출발하는 공항까지 꺼내 놓습니다.

    }
}
