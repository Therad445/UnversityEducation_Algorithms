package Lab1;

import java.util.Arrays;
import java.util.Scanner;
public class ShellSort
{

    public static int[] shellSort(int[] array) {
        int h = 1;

        while (h <= array.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (int outer = h; outer < array.length; outer++) {
                int tmp = array[outer];
                int inner = outer;

                while (inner > h - 1 && array[inner - h] > tmp) {
                    array[inner] = array[inner - h];
                    inner -= h;
                }

                array[inner] = tmp;
            }

            h = (h - 1) / 3;
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int arr_size = 0;
        if (sc.hasNextInt()) {
            arr_size = sc.nextInt();
        }

        int[] arr = new int[arr_size];

        System.out.println(
                "Enter the elements of the array: ");
        for (int i = 0; i < arr_size; i++) {
            if (sc.hasNextInt()) {
                arr[i] = sc.nextInt();
            }
        }

        System.out.println(
                "The elements of the array are: ");
        for (int i = 0; i < arr_size; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
        // int[] arr = {53,423,234,423,234,23,423,42,234,2342,34};
        System.out.println();
        System.out.println("Result after applying Shell sort: ");
        System.out.println(Arrays.toString(shellSort(arr)));
    }
}
