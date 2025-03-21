
import java.util.Scanner;

public class Menu {
    public static void start(int state, boolean win) {

        System.out.println(getStateOutputString(state, win));

        Scanner scanner = new Scanner(System.in);
        boolean isCorrectCommand = false;

        while (!isCorrectCommand) {
            String s1 = scanner.next().toLowerCase();
            switch (s1) {
                case "yes":
                    GameAPI.startGame();
                    isCorrectCommand = true;
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println(TextMessages.unknownCommand);
            }
        }
    }

    public static String getStateOutputString(int state, boolean win) {
        String outputString = "";
        switch (state) {
            case 1:
                outputString = TextMessages.startMenuGreeting + "\n" + TextMessages.chooseNextStepMenu;
                break;
            case 2:
                outputString = win ?
                        TextMessages.returnToMenuWithWin + "\n" + TextMessages.chooseNextStepMenu :
                        TextMessages.returnToMenuWithLose + "\n" + TextMessages.chooseNextStepMenu;
                break;
        }
        return outputString;
    }
}
