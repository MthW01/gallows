public class TextMessages {
    public static final String unknownCommand = "Неопознанная команда, попробуйте еще раз";
    public static final String chooseNextStepMenu = "\"yes\" - да, \"exit\" - выход";
    public static final String startMenuGreeting = "Добро пожаловать в игру, вы хотите начать новую игру? \n";
    public static final String returnToMenuWithWin = "Поздравляем, вы победили, хотите начать новую игру?";
    public static final String returnToMenuWithLose = "К сожалению, вы проиграли, хотите начать новую игру?";
    public static final String noLetter = "Такой буквы нет";
    public static final String correctLetter = "Правильно!";
    public static final String writeLetter = "Введите букву";
    public static final String incorrectLetter = "Неверно введена буква";
    public static final String writeWord = "Введите загадываемое слово";
    public static final String incorrectWord = "Введено неккоректное слово. Введите слово длиннее, чем 2 буквы";


    public enum HangmanState {
        ZERO("""
                        +---+
                            |
                            |
                            |
                            |
                            |
                        =====
                        """, 0),
        FIRST("""
                  +---+
                  |   |
                  O   |
                      |
                      |
                      |
                =========""", 1),

        SECOND("""
                  +---+
                  |   |
                  O   |
                  |   |
                      |
                      |
                =========""", 2),
        THIRD("""
                  +---+
                  |   |
                  O   |
                 /|   |
                      |
                      |
                =========""", 3),
        FOURTH("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                      |
                      |
                =========""", 4),
        FIFTH("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                   \\  |
                      |
                =========""", 5),
        SIXTH("""
                  +---+
                  |   |
                  O   |
                 /|\\  |
                 / \\  |
                      |
                =========""", 6);

        private String picture;
        private int index;

        HangmanState(String picture, int index) {
            this.picture = picture;
            this.index = index;
        }

        public static String getString(int index) {
            return HangmanState.values()[index].picture;
        }
    }
}
