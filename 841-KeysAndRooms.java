class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        // set에다가 그 방에 있었던 정표를 모아놓을 껍니다. 들어갔었다는 표시로.

        dfs(rooms, set, 0);
        // 방 0에서 시작합니다.

        return set.size() == rooms.size();
        // 그 정표 갯수가 방 갯수랑 같은지, 그러니까 다 들어가봤는지 체크합니다.
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> set, int current) {
        if (set.contains(current))
            return;
        // 그 방 정표가 이미 있으면 들어가 봤다는 거니까 끝냅니다.

        set.add(current);
        // 안 들어가본 방이면 들아가봅니다. 들어갔다고 정표를 가져오고(체크하고).

        List<Integer> keys = rooms.get(current);
        // 그 방에있는 열쇠를 다 꺼냅니다.

        for (int key : keys) {
            // 열쇠를 하나씩 들고
            dfs(rooms, set, key);
            // 그 열쇠로 그 방을 찾아들어가 봅니다.
        }
    }
}
