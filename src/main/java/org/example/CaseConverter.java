package org.example;

import java.util.Scanner;

public class CaseConverter {
    public static String convertCase(String sentence, String caseType) {
        String newSentence = sentence.replaceAll("[,.']","");

        String[] words = newSentence.split(" ");
        StringBuilder convertedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (caseType.equals("camelCase")) {
                convertedSentence.append(i == 0 ? word.toLowerCase() : capitalize(word));
            } else if (caseType.equals("snakecase")) {
                convertedSentence.append(word.toLowerCase());
                if (i != words.length - 1) {
                    convertedSentence.append("_");
                }
            } else if (caseType.equals("kebab-case")) {
                convertedSentence.append(word.toLowerCase());
                if (i != words.length - 1) {
                    convertedSentence.append("-");
                }
            } else if (caseType.equals("PascalCase")) {
                convertedSentence.append(capitalize(word));
            } else if (caseType.equals("UPPER_CASE_SNAKE_CASE")) {
                convertedSentence.append(word.toUpperCase());
                if (i != words.length - 1) {
                    convertedSentence.append("_");
                }
            } else {
                System.out.println("Invalid case: " + caseType);
                return null;
            }
        }

        return convertedSentence.toString();
    }

    private static String capitalize(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a sentence");
            String sentence = scanner.nextLine();
            System.out.println("Enter the desired case.Choose among (camelCase, snakecase, kebab-case, PascalCase and UPPER_CASE_SNAKE_CASE)");
            String desiredCase = scanner.next();

            String convertedSentence = convertCase(sentence, desiredCase);
            System.out.println(convertedSentence);
        }
    }
}
