import java.util.Scanner;

public class ArrayUmtausch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int laenge, temp;

        System.out.print("Wieviele Zahlen geben Sie ein?: ");
        laenge = scanner.nextInt();
        System.out.println();

        int[] arr = new int[laenge];

        for (int i = 0; i < laenge; i++) {

            System.out.print("Geben Sie " + (i + 1) + ". Zahl ein: ");
            arr[i] = scanner.nextInt();
        }
        System.out.println("\nDie Zahlen sind: ");

        for (int i = 0; i < laenge; i++) {

            System.out.print(arr[i] + " ");
        }

        for (int i = 0; i < laenge / 2; i++) {
            temp = arr[i];
            arr[i] = arr[laenge - 1 - i];
            arr[laenge - 1 - i] = temp;
        }
        System.out.println("\n");
        System.out.println("Nach dem Umdrehen: ");

        for (int i = 0; i < laenge; i++) {

            System.out.print(arr[i] + " ");
        }
        scanner.close();

    }

}
