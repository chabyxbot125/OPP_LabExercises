import java.util.List;
import java.util.stream.Collectors;

public class FunctionalExample {

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static List<Integer> findEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(FunctionalExample::isEven) // Method reference
                      .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = findEvenNumbers(numbers);
        System.out.println("Even numbers (Functional): " + evenNumbers);
    }
}
