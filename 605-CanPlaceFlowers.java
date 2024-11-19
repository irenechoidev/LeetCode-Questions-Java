class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 처음부터 심을 곳을 찾아 나선다 (iterate)
        for (int i = 0; i < flowerbed.length; i++) {

            // 못 심는 곳을 그냥 지난다
            // 1 왼쪽이 심어져 있으면 지나고 (boundary check)
            if (i > 0 && flowerbed[i - 1] == 1)
                continue;
            // 오른쪽이 심어져 있으면 지나고 (boundary check)
            if (i < flowerbed.length - 1 && flowerbed[i + 1] == 1)
                continue;
            // 그 자리에 이미 심어져 있으면 지나고
            if (flowerbed[i] == 1)
                continue;

            // 빈 자리에 꽃을 심는다;
            flowerbed[i] = 1;

            // 심어야 하는 꽃 갯수에서 심었으니까 하나씩 뺀다
            n -= 1;
        }

        // 다 심었거나 더 심을 자리가 남았는지 본다. 다 심었다면 true 니까
        return n <= 0;
    }
}