class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0)
            return new int[0];

        int[] res = arr.clone();
        Map<Integer, Integer> map = new HashMap<>();

        Arrays.sort(arr);
        map.put(arr[0], 1);

        int rank = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                map.put(arr[i], rank);
            } else {
                map.put(arr[i], ++rank);
            }
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(res[i]);
        }

        return res;
    }
}
