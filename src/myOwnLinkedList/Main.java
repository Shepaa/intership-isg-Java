package myOwnLinkedList;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        ArrayList<String> arrayList = new ArrayList<>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            myLinkedList.addFirst("element " + i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList addFirst: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList.addFirst("element " + i);
        }

        endTime = System.nanoTime();
        System.out.println("ArrayList addFirst: " + (endTime - startTime) + " nanoseconds");

        System.out.println();

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            myLinkedList.addLast("element " + i);
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList addLast: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            arrayList.addLast("Element" + i);
        }
        endTime = System.nanoTime();
        System.out.println("ArrayList addLast: " + (endTime - startTime) + " nanoseconds");
    }
}
