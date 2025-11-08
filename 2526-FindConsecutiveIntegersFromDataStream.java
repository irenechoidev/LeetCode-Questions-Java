class DataStream {
    int val;
    int streakCount;
    int k;

    public DataStream(int value, int k) {
        this.val = value;
        this.streakCount = 0;
        this.k = k;
    }

    public boolean consec(int num) {

        if (num == val) {
            streakCount += 1;
        } else {
            streakCount = 0;
        }

        return streakCount >= k;
    }
}