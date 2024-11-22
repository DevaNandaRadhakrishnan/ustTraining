import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Operations opAdd = new Addition();
        System.out.println(opAdd.operate(5, 3));

        Operations opMultiply = new Multiplication();
        System.out.println(opMultiply.operate(5, 3));

        System.out.println("===============================");

        //Anonymous class
        Operations opAdd2 = new Operations() {
            @Override
            public int operate(int a, int b) {
                return a+b;
            }
        };
        System.out.println(opAdd2.operate(5, 3));

        Operations opMultiply2 = new Operations() {
            @Override
            public int operate(int a, int b) {
                return a*b;
            }
        };
        System.out.println(opMultiply2.operate(5, 3));

        System.out.println("===============================");

        Operations opAdd3 = (a, b) -> a + b;
        System.out.println(opAdd3.operate(5, 3));

        Operations opMultiply3 = (a, b) -> a * b;
        System.out.println(opMultiply3.operate(5, 3));

        System.out.println("===============================");

        BiFunction<Integer, Integer, Integer> opAdd4 = (n1, n2) -> n1 + n2;
        System.out.println(opAdd4.apply(5, 3));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        int n = 6;
        System.out.println(isEven.test(n));

        BiFunction<Double, Double, Double> powerN = (n1, n2) -> Math.pow(n1, n2);
        System.out.println(powerN.apply(2.0, 3.0));

        Predicate<String> isPalindrome = str -> str.equals(new StringBuilder(str).reverse().toString());
        System.out.println(isPalindrome.test("malayalam"));
    }
}