package sort.recursive;

public class Fibonacci {

    public int getFibonacci(int input) {
        if (input <= 1) {
            return input;
        } else {
            return getFibonacci(input - 1) + getFibonacci(input - 2);
        }
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.getFibonacci(10));
    }
}
