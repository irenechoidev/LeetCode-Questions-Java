class TimeMap {
    private Map<String, List<Data>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(new Data(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String result = "";

        if (map.containsKey(key)) {

            List<Data> data = map.get(key);

            int start = 0;
            int end = data.size() - 1;

            while (start <= end) {
                int mid = start + (end - start) / 2;
                int time = data.get(mid).timestamp;
                if (time == timestamp) {
                    return data.get(mid).value;
                } else if (time < timestamp) {
                    result = data.get(mid).value;
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return result;
    }

    class Data {
        String value;
        int timestamp;

        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
