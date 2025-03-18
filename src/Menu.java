import java.util.Scanner;

public class Menu {
    public static void Start(int state, boolean win) {

        Scanner scanner = new Scanner(System.in);
        String outputString = "";
        switch (state) {
            // Старт меню
            case 1:
                outputString = "Добро пожаловать в игру, вы хотите начать новую игру? \n" +
                        "yes - Да, exit - выход \n";
                break;
            // Продолжение игры
            case 2:
                outputString = win ?
                        "Поздравляем, вы победили, хотите начать новую игру? \n" +
                                "yes - да, exit - выход \n" :
                        "К сожалению, вы проиграли, хотите начать новую игру? \n" +
                                "yes - да, exit - выход \n";
                break;
        }
        System.out.print(outputString);

        boolean flag = true;
        while (flag) {
            String s1 = scanner.next().toLowerCase();
            switch (s1) {
                case "yes":
                    Game.StartGame();
                    flag = false;
                case "exit":
                    System.exit(0);
                default:
                    System.out.printf("Неопознанная команда, попробуйте еще раз \n");
            }
        }
    }
}
