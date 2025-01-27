class Solution {
    public String toGoatLatin(String sentence) {

        Set<Character> set = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();

        // To track the word index (starting from 1, as per the problem statement)
        int index = 1;

        // Split the sentence into words using whitespace as a delimiter
        for (String word : sentence.split("\\s+")) {

            // Add a space before appending the word (skip for the first word)
            if (index > 1) {
                sb.append(" ");
            }

            // Get the first character of the word
            char firstChar = word.charAt(0);

            // If the word starts with a vowel, append the word and "ma"
            if (set.contains(firstChar)) {
                sb.append(word).append("ma");
            } else {
                // If the word starts with a consonant, move the first character to the end,
                // then append "ma"
                // Add the rest of the word except the first character
                sb.append(word.substring(1))
                        .append(firstChar)
                        .append("ma");
            }

            // Append 'a' index times
            for (int i = 0; i < index; i++) {
                sb.append("a");
            }

            // Increment the word index for the next iteration
            index += 1;
        }

        return sb.toString();
    }
}
