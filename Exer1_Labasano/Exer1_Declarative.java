import java.util.List;
import java.util.stream.Collectors;

public class DeclarativeExample {

    public static List<Integer> findEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                      .filter(n -> n % 2 == 0)
                      .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = findEvenNumbers(numbers);
        System.out.println("Even numbers (Declarative): " + evenNumbers);
    }
}
