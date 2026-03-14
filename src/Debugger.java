public class Debugger {
    private static final boolean enable = true;
    private static long Time;
    private static void print(String stage, String message) {
        if (enable) {
            System.err.println("[Отладка - " + stage + "]: " + message);
        }
    }

    public static void logInputWait() {
        print("Ввод", "Ожидание данных пользователя");
        Time = System.nanoTime();
    }

    public static void logCheck(int value) {
        print("Проверка", "Значение rollsCount = " + value);
    }

    public static void logError() {
        print("Ошибка", "Количество меньше нормы");
    }

    public static void logException(Exception e) {
        if (enable) {
            System.err.println("[Отладка - Стек вызовов]:");
            e.printStackTrace();
        }
    }
    public static void logTime() {
        if (enable) {
            double v = (System.nanoTime() - Time) / 1_000_000.0;
            print("Готово", "Проверка пройдена успешно (" + v + " мс)");
        }
    }
}















