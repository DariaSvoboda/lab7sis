import java.util.Scanner;

public class Main {
    public static class NotEnoughRollsException extends Exception {
        public NotEnoughRollsException(String message) {
            super(message);
        }
    }

    public static class SushiValidator {
        private static final int MIN_ROLLS = 20;

        public static void checkRollsForParty(int rollsCount) throws NotEnoughRollsException {
            Debugger.logCheck(rollsCount);

            if (rollsCount < MIN_ROLLS) {
                Debugger.logError();
                throw new NotEnoughRollsException(
                        "Всего " + rollsCount + " роллов? Подружкам и тебе нужно минимум " + MIN_ROLLS + "!"
                );
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Сколько роллов вы заказали для тусни с подружками? ");
        Debugger.logInputWait();

        int rolls = scanner.nextInt();

        try {
            SushiValidator.checkRollsForParty(rolls);
            Debugger.logTime();
            System.out.println("Ну щас наедитесь вкусно, молодец!");
            System.out.println("Приятного аппетита! Включите сериальчик и можно начинать.");
        } catch (NotEnoughRollsException e) {
            System.out.println("Ты чего?!");
            System.out.println(e.getMessage());
            Debugger.logException(e);
        }
    }
}