package sorts.Bubble;

import static sorts.Bubble.BubbleSort.bubbleSort;

public class Main {
    public static void main(String[] args) {
        int[] arr ={3,60,35,2,45,320,5};

        System.out.println("Array Before Bubble Sort");
        for (int k : arr) {
            System.out.print(k + " ");
        }
        System.out.println();

        bubbleSort(arr);

        System.out.println("Array After Bubble Sort");
        for (int j : arr) {
            System.out.print(j + " ");
        }

    }
}

