class MyHashMap {
    Integer[] map;

    public MyHashMap() {
        map = new Integer[1000001];
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key] == null ? -1 : map[key];
    }

    public void remove(int key) {
        map[key] = null;
    }
}