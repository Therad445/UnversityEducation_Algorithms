package Lab2;

import java.util.Scanner;

class BinarySearchTree {
    public static int binarySearchRecursively(int[] array, int key) {
        return binarySearchRecursively(array, 0, array.length, key);
    }

    public static int binarySearchRecursively(
            int[] array, int fromIndex, int toIndex, int key) {
        if (toIndex <= fromIndex) return -1;

        int mid = (fromIndex + toIndex) >>> 1;
        int midVal = array[mid];

        if (key == midVal) {
            return mid;
        } else if (key < midVal) {
            return binarySearchRecursively(array, fromIndex, mid, key);
        } else {
            return binarySearchRecursively(array, mid + 1, toIndex, key);
        }
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
        System.out.println("Enter the desired element: ");
        int key = sc.nextInt();
        System.out.println("Result after applying Binary Search Tree: ");
        System.out.println(binarySearchRecursively(arr, key));
    }
}
