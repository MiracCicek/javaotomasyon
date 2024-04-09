package org.example;

import java.util.HashSet;

public class MultipleDuplicateWords {

    public static String createTextFromMultipleDuplicateWords(String[] words) {
        StringBuilder result = new StringBuilder();
        HashSet<String> seenWords = new HashSet<>();


        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j]) && !seenWords.contains(words[i])) {
                    seenWords.add(words[i]);
                    result.append(words[i]).append(" ");
                    break;
                }
            }
        }

        StringBuilder newString = new StringBuilder();
        for (String word : result.toString().split(" ")) {
            for (char c : word.toCharArray()) {
                if (Character.isLetter(c)) {
                    newString.append(c);
                }
            }
        }

        return newString.toString();
    }

    public static void main(String[] args) {
        String[] words = {"Merhaba", "Dünya", "Java", "Merhaba", "Merhaba", "Java","Mraç", "Deneme"};

        String newText = createTextFromMultipleDuplicateWords(words);

        System.out.println("Metin: " + newText);
    }
}
