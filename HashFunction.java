import java.util.Scanner;

public class HashFunction {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tableSize, key, hashIndex;

        System.out.println(" Hash Function ");

        System.out.print("Enter Table Size: ");
        tableSize = sc.nextInt();

        System.out.print("Enter Key: ");
        key = sc.nextInt();

        hashIndex = key % tableSize;

        System.out.println("\nResult");
        System.out.println("Key = " + key);
        System.out.println("Table Size = " + tableSize);
        System.out.println("Hash Index = " + hashIndex);

        sc.close();
    }
}