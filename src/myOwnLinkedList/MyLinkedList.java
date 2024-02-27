package myOwnLinkedList;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(T data) {
        Node<T> temp = new Node<>(data);

        if (isEmpty()) {
            this.tail = temp;
        } else {
            this.head.prev = temp;
        }

        temp.next = this.head;
        this.head = temp;
        this.size++;
    }

    public void addByIndex(int index, T data) {
        Node<T> current = this.head;
        int i = 0;
        while (current != null & i != index) {
            current = current.next;
            i++;
        }

        Node<T> temp = new Node<>(data);
        current.prev.next = temp;
        temp.prev = current.prev;
        current.prev = temp;
        temp.next = current;
        this.size++;
    }

    public void addLast(T data) {
        Node<T> temp = new Node<>(data);

        if (isEmpty()) {
            this.head = temp;
        } else {
            this.tail.next = temp;
        }
        temp.prev = this.tail;
        this.tail = temp;
        this.size++;
    }

    public void removeFirst() {
        if (this.head.next == null) {
            this.tail = null;
        } else {
            this.head.next.prev = null;
        }
        head = head.next;
        this.size--;
    }

    public void removeLast() {
        if (head.next == null) {
            head = null;
        } else {
            tail.prev.next = null;
        }

        tail = tail.prev;
        this.size--;
    }

    public void removeAt(T key) {
        Node<T> current = head;

        while (current != null && !current.data.equals(key)) {
            current = current.next;
        }

        if (current == null) {
            return;
        }

        if (current == head) {
            removeFirst();
        } else if (current == tail) {
            removeLast();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        this.size--;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int getSize() {
        return size;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

}
