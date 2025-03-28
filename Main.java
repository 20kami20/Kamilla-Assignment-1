import java.util.Scanner;

/**
 * Main class to handle user input and execute different tasks.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello user");
        System.out.println("Choose the task (1-8): ");
        int task = scanner.nextInt();
        System.out.println("Result: ");

        // Measure execution time
        long startTime = System.nanoTime();

        if (task == 1) { // Find the minimum element in an array
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
            System.out.println("Minimum: " + findMin(arr, n));
        } else if (task == 2) { // Calculate the average of an array
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
            System.out.println("Average: " + findAverage(arr, n));
        } else if (task == 3) {
            System.out.print("Enter a number: ");
            int n = scanner.nextInt();
            System.out.println(isPrime(n, 2) ? "Prime" : "Composite");
        } else if (task == 4) {
            System.out.print("Enter a number: ");
            int n = scanner.nextInt();
            System.out.println("Factorial: " + factorial(n));
        } else if (task == 5) {
            System.out.print("Enter the Fibonacci index: ");
            int n = scanner.nextInt();
            System.out.println("Fibonacci: " + fibonacci(n));
        } else if (task == 6) {
            System.out.print("Enter base and exponent: ");
            int a = scanner.nextInt();
            int n = scanner.nextInt();
            System.out.println("Power: " + power(a, n));
        } else if (task == 7) {
            System.out.print("Enter the number of elements: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
            System.out.println("Reversed array:");
            reversePrint(arr, n);
        } else if (task == 8) {
            System.out.print("Enter a string: ");
            String s = scanner.next();
            System.out.println(isDigitString(s, 0) ? "Yes" : "No");
        }
        long endTime = System.nanoTime();
        System.out.println("Execution Time: " + (endTime - startTime) / 1_000_000 + " milliseconds");

        scanner.close();
    }

    /**
     * Recursively finds the minimum element in the array.
     * Time Complexity: O(n)
     */
    public static int findMin(int[] arr, int n) {
        if (n == 1) return arr[0];
        return Math.min(arr[n - 1], findMin(arr, n - 1));
    }

    /**
     * Recursively calculates the average of the elements in the array.
     * Time Complexity: O(n)
     */
    public static double findAverage(int[] arr, int n) {
        if (n == 1) return arr[0];
        return (arr[n - 1] + (n - 1) * findAverage(arr, n - 1)) / n;
    }

    /**
     * Recursively checks if a number is prime.
     * Time Complexity: O(√n)
     */
    public static boolean isPrime(int n, int i) {
        if (n < 2) return false;
        if (i * i > n) return true;
        if (n % i == 0) return false;
        return isPrime(n, i + 1);
    }

    /**
     * Recursively calculates the factorial of a number.
     * Time Complexity: O(n)
     */
    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    /**
     * Recursively finds the nth Fibonacci number.
     * Time Complexity: O(2^n)
     */
    public static int fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Recursively calculates the power of a number.
     * Time Complexity: O(n)
     */
    public static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    /**
     * Recursively prints an array in reverse order.
     * Time Complexity: O(n)
     */
    public static void reversePrint(int[] arr, int n) {
        if (n == 0) return;
        System.out.print(arr[n - 1] + " ");
        reversePrint(arr, n - 1);
    }

    /**
     * Recursively checks if a string consists only of digits.
     * Time Complexity: O(n)
     */
    public static boolean isDigitString(String s, int index) {
        if (index == s.length()) return true;
        if (!Character.isDigit(s.charAt(index))) return false;
        return isDigitString(s, index + 1);
    }
}
