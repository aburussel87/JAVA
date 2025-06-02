import java.util.Scanner;

public class TestMarks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 2D array to store marks of 10 students for 5 tests
        int[][] marks = new int[2][5];
        String[] names = new String[2];
        // Input marks for each student
        for (int i = 0; i < 2; i++) {

            System.out.println("Enter name of student " + (i + 1) + ":");
            names[i] = scanner.nextLine();
            System.out.println("Enter marks for " + names[i] + ":");
            for (int j = 0; j < 5; j++) {
                System.out.print("Test " + (j + 1) + ": ");
                marks[i][j] = scanner.nextInt(); // Read marks for each test
            }
            scanner.nextLine(); // consumes new line if necessary
        }

        // Output the marks
        System.out.println("\nStudent Marks:");

        for (int i = 0; i < 2; i++) {
            System.out.print(names[i]+ ": ");
            for (int j = 0; j < 5; j++) {
                System.out.print(marks[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing all test marks for the student
        }

        scanner.close(); // Close the scanner
    }
}
