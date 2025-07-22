class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);

        Queue<Integer> idxQueue = new LinkedList<>();
        for (int i = 0; i < deck.length; i++) {
            idxQueue.add(i);
        }

        int[] res = new int[deck.length];
        for (int card : deck) {
            int idx = idxQueue.remove();
            res[idx] = card;

            if (!idxQueue.isEmpty()) {
                idxQueue.add(idxQueue.remove());
            }
        }
        return res;
    }
}
