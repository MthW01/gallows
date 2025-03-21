import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class GameAPI {
    public static String[] lettersArray;

    public static void startGame() {
        String word = getWord();
        lettersArray = word.split("");
        String[] guessedLetters = new String[lettersArray.length];
        Arrays.fill(guessedLetters, 0, guessedLetters.length, "_");
        int gallowState = 0;

        while (true) {
            if (Arrays.equals(guessedLetters, lettersArray) && gallowState < AdditionalValues.MAXGALLOWSSTATE) {
                Menu.start(AdditionalValues.startNextGame, true);
                break;
            } else if (gallowState == AdditionalValues.MAXGALLOWSSTATE) {
                System.out.println(TextMessages.HangmanState.getString(gallowState));
                Menu.start(AdditionalValues.startNextGame, false);
                break;
            } else {
                String[] newGuessedArray = findLetterInWord(guessedLetters);
                if (Arrays.equals(newGuessedArray, guessedLetters)) {
                    gallowState++;
                    System.out.println(TextMessages.HangmanState.getString(gallowState));
                    System.out.println(TextMessages.noLetter);
                    System.out.println(Arrays.toString(guessedLetters));
                } else {
                    guessedLetters = newGuessedArray;
                    System.out.println(TextMessages.HangmanState.getString(gallowState));
                    System.out.println(TextMessages.correctLetter);
                    System.out.println(Arrays.toString(guessedLetters));
                }

            }
        }
    }

    public static String getWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(TextMessages.writeWord);
        String word = scanner.next().toLowerCase();
        while (word.length() < 2) {
            System.out.println(TextMessages.incorrectWord);
            word = scanner.next().toLowerCase();
        }
        return word;
    }

    public static String getLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(TextMessages.writeLetter);
        String letter = scanner.next().toLowerCase();
        while (letter.length() != 1 || isInteger(letter)) {
            System.out.println(TextMessages.incorrectLetter);
            letter = scanner.next().toLowerCase();
        }
        return letter;
    }

    public static String[] findLetterInWord(String[] guessedLetters) {
        String letter = getLetter();
        String[] newGuessed = guessedLetters.clone();
        HashSet<String> uniqueLetters = new HashSet<>(Arrays.asList(lettersArray));

        if (uniqueLetters.contains(letter)) {
            for (int i = 0; i < lettersArray.length; i++) {
                if (lettersArray[i].equals(letter)) {
                    newGuessed[i] = letter;
                }
            }
        }

        return newGuessed;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
