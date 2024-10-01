import java.util.Scanner;

/**
 * Клас, що представляє число Люка.
 */
class LucasNumber {
    private int index;
    private long value;

    /**
     * Конструктор класу LucasNumber.
     *
     * @param index Індекс числа Люка.
     * @param value Значення числа Люка.
     */
    public LucasNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    /**
     * Метод для отримання індексу числа Люка.
     *
     * @return Індекс числа Люка.
     */
    public int getIndex() {
        return index;
    }

    /**
     * Метод для отримання значення числа Люка.
     *
     * @return Значення числа Люка.
     */
    public long getValue() {
        return value;
    }

    /**
     * Метод для перевірки, чи є число квадратом.
     */
    public boolean isPerfectSquare() {
        float sqrt = (float) Math.sqrt(value);
        return sqrt * sqrt == value;
    }
}

/**
 * Головний клас програми для обчислення та перевірки чисел Люка.
 */
public class Main {

    /**
     * Метод для обчислення числа Люка за індексом.
     *
     * @param n Індекс числа Люка.
     * @return Значення числа Люка для індексу n.
     */
    public static long getLucasNumber(int n) {
        if (n == 0) return 2;
        if (n == 1) return 1;
        long prev1 = 2, prev2 = 1, current = 0;
        for (int i = 2; i <= n; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return current;
    }

    /**
     * Метод для запуску програми.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = -1;

        while (N < 0) {
            System.out.print("Введіть кількість перших чисел Люка (N >= 0): ");
            if (scanner.hasNextInt()) {
                N = scanner.nextInt();
                if (N < 0) {
                    System.out.println("Помилка: Число повинно бути більше або рівне 0. Спробуйте знову.");
                }
            } else {
                System.out.println("Помилка: Введено некоректне значення. Спробуйте знову.");
                scanner.next();
            }
        }

        /**
         * Створення масиву для зберігання чисел Люка.
         */
        LucasNumber[] lucasNumbers = new LucasNumber[N];

        /**
         * Обчислення чисел Люка і збереження їх у масиві.
         */
        for (int i = 0; i < N; i++) {
            long value = getLucasNumber(i);
            lucasNumbers[i] = new LucasNumber(i, value);
        }

        /**
         * Виведення результатів.
         */
        System.out.println("Перші " + N + " чисел Люка та перевірка на квадрат:");
        for (LucasNumber lucasNumber : lucasNumbers) {
            System.out.print("L(" + lucasNumber.getIndex() + ") = " + lucasNumber.getValue());
            if (lucasNumber.isPerfectSquare()) {
                System.out.println(" - це квадрат.");
            } else {
                System.out.println(" - не є квадратом.");
            }
        }

        long sum = 0;

        for (LucasNumber lucasNumber : lucasNumbers) {
            System.out.print("L(" + lucasNumber.getIndex() + ") = " + lucasNumber.getValue());

            sum += lucasNumber.getValue();

        }

        System.out.println("Сума перших " + N + " чисел Люка: " + sum);

        scanner.close();


    }
}


