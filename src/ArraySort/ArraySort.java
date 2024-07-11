package ArraySort;

import java.util.Random;
import java.util.Scanner;

public class ArraySort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int begin, end;
        int size = 7;

        System.out.print("Untergenze: ");
        begin = sc.nextInt();
        System.out.print("Obergrenze: ");
        end = sc.nextInt();

        int[] arr = new int[size];
        arr_unsort(arr, size, begin, end);
        arr_sort(arr, size);

        sc.close();
    }
    public static void arr_unsort(int[] arr, int size, int begin, int end) {
        Random rd = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rd.nextInt(begin, end);
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void arr_sort(int[] arr, int size) {
        int temp;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
