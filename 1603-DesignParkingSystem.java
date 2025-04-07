class ParkingSystem {
    Map<Integer, Integer> map = new HashMap<>();
    int bigCarType = 1;
    int mediumCarType = 2;
    int smallCarType = 3;

    public ParkingSystem(int big, int medium, int small) {
        map.put(bigCarType, big);
        map.put(mediumCarType, medium);
        map.put(smallCarType, small);

    }

    public boolean addCar(int carType) {
        int capacity = map.get(carType);
        if (capacity <= 0) {
            return false;
        }
        map.put(carType, map.get(carType) - 1);
        return true;
    }
}
