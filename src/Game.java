import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Game {
    public static String[] lettersArray;

    public static void StartGame() {
        String word = GetWord();
        lettersArray = word.split("");
        String[] guessedLetters = new String[lettersArray.length];
        Arrays.fill(guessedLetters, 0, guessedLetters.length, "_");
        int counter = 0;

        while (true) {
            if (Arrays.equals(guessedLetters, lettersArray) && counter < 6) {
                Menu.Start(2, true);
                break;
            } else if (counter == 6) {
                try {
                    Drawer.DrawCondition(counter);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Menu.Start(2, false);
                break;
            } else {
                String[] newGuessedArray = FindLetterInWord(guessedLetters);
                // Не отгадали букву
                if (Arrays.equals(newGuessedArray, guessedLetters)) {
                    counter++;
                    try {
                        Drawer.DrawCondition(counter);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("Такой буквы нет \n");
                    System.out.println(Arrays.toString(guessedLetters));
                }
                // Отгадали букву
                else {
                    guessedLetters = newGuessedArray;
                    try {
                        Drawer.DrawCondition(counter);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.printf("Правильно! \n");
                    System.out.println(Arrays.toString(guessedLetters));
                }

            }
        }
    }

    public static String GetWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите загадываемое слово \n");
        String word = scanner.next().toLowerCase();
        while (word.length() < 2) {
            System.out.printf("Введено неккоректное слово. Введите слово длиннее, чем 2 буквы \n");
            word = scanner.next().toLowerCase();
        }
        return word;
    }

    public static String GetLetter() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Введите букву \n");
        String letter = scanner.next().toLowerCase();
        while (letter.length() != 1) {
            System.out.printf("Неверно введена буква \n");
            letter = scanner.next().toLowerCase();
        }
        return letter;
    }

    public static String[] FindLetterInWord(String[] guessedLetters) {
        String letter = GetLetter();
        String[] newGuessed = guessedLetters.clone();
        for (int i = 0; i < lettersArray.length; i++) {
            if (lettersArray[i].equals(letter)) {
                newGuessed[i] = letter;
            }
        }
        return newGuessed;
    }
}
