import java.util.ArrayList;
import java.util.List;

public class ImperativeExample {

    public static List<Integer> findEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) % 2 == 0) {
                evenNumbers.add(numbers.get(i));
            }
        }
        return evenNumbers;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = findEvenNumbers(numbers);
        System.out.println("Even numbers (Imperative): " + evenNumbers);
    }
}
