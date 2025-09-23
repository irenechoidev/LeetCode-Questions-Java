class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return -1;

        char[] genes = { 'A', 'C', 'G', 'T' };

        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }
        if (!set.contains(endGene))
            return -1;

        Queue<String> queue = new LinkedList<>();
        queue.add(startGene);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] curr = queue.poll().toCharArray();

                for (int j = 0; j < curr.length; j++) {
                    char temp = curr[j];
                    for (char c : genes) {
                        curr[j] = c;
                        String newGene = String.valueOf(curr);

                        if (newGene.equals(endGene))
                            return level + 1;
                        if (set.contains(newGene)) {
                            set.remove(newGene);
                            queue.add(newGene);
                        }
                    }
                    curr[j] = temp;
                }
            }
            level += 1;
        }
        return -1;
    }
}