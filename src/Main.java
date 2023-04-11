import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Character> result = myFunc(new String[]{"мама", "трактор", "тато", "їж їжак желе", "анна", "куку"});

        if (result != null)
            result.forEach(System.out::println);

    }

    public static Set<Character> myFunc(String[] words) {

        // create variables to store and count result
        int wordCount = 0;
        String[] evens = new String[2];

        //from the given list of strings finds the first two in which each letter occurs an even number of times using Iterator and while loop
        Iterator<String> iterator = Arrays.stream(words).iterator();
        while (iterator.hasNext()) {

            //assigned next string to variable and convert it to array of characters
            String word = iterator.next();
            char[] chars = word.toCharArray();

            //create a map to store characters and how many times it appears in given string
            HashMap<Character, Integer> charMap = new HashMap<>();

            //populate map
            for (char c : chars) {
                if (charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c) + 1);
                } else {
                    charMap.put(c, 1);
                }
            }

            //Check if all the characters appears even numbers of time
            boolean isAllCharEven = true;
            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    isAllCharEven = false;
                    break;
                }
            }

            //if all char appear even number of times add it to result array and increase result counter
            if (isAllCharEven) {
                evens[wordCount] = word;
                wordCount++;
            }

            //if there present two strings in result array - stop looking for others
            if (wordCount == 2)
                break;
        }

        //check if was found enough of results - if yes - add all characters to set (remove duplication), if no - print message about it
        if (wordCount != 2) {
            System.out.println("there no enough strings with even number of each letter");
            return null;
        } else {
            Set<Character> characterSet = new HashSet<>();
            for (String even : evens) {
                for (char c : even.toCharArray()) {
                    characterSet.add(c);
                }
            }
            return characterSet;

        }
    }
}
