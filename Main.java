import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfEntries = sc.nextInt();
        MyArrayList mal1 = new MyArrayList();
        int[] numbers = new int[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++) {
            numbers[i] = i;
        }

        int[] organizedVector = organize(numbers, numbers.length);

        for (int i = 0; i < organizedVector.length; i++) {
            System.out.println(organizedVector[i]);
        }

        sc.close();

    }

    static int[] organize(int[] numbers, int size) {
        int evenCount = 0;
        int oddCount = 0;

        // Count even and odd numbers
        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Create arrays with correct sizes
        int[] evenNumbers = new int[evenCount];
        int[] oddNumbers = new int[oddCount];

        // Separate even and odd numbers
        evenCount = 0;
        oddCount = 0;
        for (int i = 0; i < size; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers[evenCount++] = numbers[i];
            } else {
                oddNumbers[oddCount++] = numbers[i];
            }
        }

        // Sort even numbers in ascending order
        Arrays.sort(evenNumbers);

        // Sort odd numbers in ascending order
        Arrays.sort(oddNumbers);

        // Combine even and odd numbers
        int[] organizedVector = new int[size];
        System.arraycopy(evenNumbers, 0, organizedVector, 0, evenCount);
        System.arraycopy(oddNumbers, 0, organizedVector, evenCount, oddCount);

        return organizedVector;
    }

    class MyArrayList {
        private int[] numbers;
        private int size;

        public MyArrayList() {
            numbers = new int[10];
            size = 0;
        }

        public int add(int number) {
            int value = number;

            if (isValidNumber(number)) {
                if (size == numbers.length) {
                    int[] newArray = new int[numbers.length * 2];
                    System.arraycopy(numbers, 0, newArray, 0, size);
                    numbers = newArray;
                }
                numbers[size] = number;
                size++;
                return number;
            }
            return 0;
        }

        private boolean isValidNumber(int number) {
            return number >= 0;
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }

    }

}
