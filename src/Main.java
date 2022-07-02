import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        printMessage("Введите размер списка: ");

        String input = scanner.nextLine();
        int arraySize = Integer.parseInt(input);

        printMessage("Введите верхнюю границу для значений: ");

        input = scanner.nextLine();
        int maxValue = Integer.parseInt(input);

        logger.log("Создаём и наполняем список");
        List<Integer> numbers = getNumbers(arraySize, maxValue);

        printMessage("Вот случайный список: " + numbers + "\n");

        logger.log("Просим пользователя ввести входные данные для фильтрации");

        printMessage("Введите порог для фильтра: ");

        input = scanner.nextLine();
        int filterMaxValue = Integer.parseInt(input);

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filterMaxValue);
        List<Integer> result = filter.filterOut(numbers);

        logger.log("Выводим результат на экран");
        printMessage("Отфильтрованный список: " + result + "\n");

        logger.log("Завершаем программу");
    }

    public static List<Integer> getNumbers(int arraySize, int maxValue) {
        List<Integer> numbers = new ArrayList<>(arraySize);
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            numbers.add(random.nextInt(maxValue));
        }
        return numbers;
    }

    public static void printMessage(String msg) {
        System.out.print(msg);
    }
}