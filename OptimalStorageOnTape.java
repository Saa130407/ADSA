import java.util.Scanner;

public class OptimalStorageOnTape {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

      
        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        int[] length = new int[n];

      
        System.out.println("Enter the length of each file:");
        for (int i = 0; i < n; i++) {
            System.out.print("File " + (i + 1) + ": ");
            length[i] = sc.nextInt();
        }

      
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (length[i] > length[j]) {
                    int temp = length[i];
                    length[i] = length[j];
                    length[j] = temp;
                }
            }
        }

      
        int total = 0;
        int retrieval = 0;

        for (int i = 0; i < n; i++) {
            retrieval = retrieval + length[i];
            total = total + retrieval;
        }

   
        double average = (double) total / n;

     
        System.out.print("\nOptimal Order: ");
        for (int i = 0; i < n; i++) {
            System.out.print(length[i] + " ");
        }

        System.out.println("\nTotal Retrieval Time: " + total);
        System.out.println("Average Retrieval Time: " + average);

        sc.close();
    }
}