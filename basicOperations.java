import java.util.LinkedList;
import java.util.Scanner;

public class basicOperations {
    // Array operations
    static class ArrayOperations {
        private int[] array;
        private int size;
        private int capacity;

        public ArrayOperations(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.array = new int[capacity];
        }

        public void add(int value) {
            if (size < capacity) {
                array[size++] = value;
            } else {
                System.out.println("Array is full.");
            }
        }

        public void remove(int index) {
            if (index < 0 || index >= size) {
                System.out.println("Index out of bounds.");
                return;
            }
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }

        public int search(int value) {
            for (int i = 0; i < size; i++) {
                if (array[i] == value) {
                    return i;
                }
            }
            return -1; // Not found
        }

        public void display() {
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        }
    }

    // Linked List operations
    static class LinkedListOperations {
        private LinkedList<Integer> list;

        public LinkedListOperations() {
            this.list = new LinkedList<>();
        }

        public void add(int value) {
            list.add(value);
        }

        public void remove(int value) {
            if (list.contains(value)) {
                list.remove(Integer.valueOf(value));
            } else {
                System.out.println("Value not found in the list.");
            }
        }

        public int search(int value) {
            return list.indexOf(value);
        }

        public void display() {
            for (int value : list) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayOperations arrayOps = new ArrayOperations(5);
        LinkedListOperations linkedListOps = new LinkedListOperations();

        while (true) {
            System.out.println("Choose operation: 1. Array 2. Linked List 3. Exit");
            int choice = scanner.nextInt();

            if (choice == 3) {
                break;
            }

            System.out.println("Choose operation: 1. Add 2. Remove 3. Search 4. Display");
            int operation = scanner.nextInt();

            if (choice == 1) { // Array operations
                switch (operation) {
                    case 1:
                        System.out.print("Enter value to add: ");
                        int valueToAdd = scanner.nextInt();
                        arrayOps.add(valueToAdd);
                        break;
                    case 2:
                        System.out.print("Enter index to remove: ");
                        int indexToRemove = scanner.nextInt();
                        arrayOps.remove(indexToRemove);
                        break;
                    case 3:
                        System.out.print("Enter value to search: ");
                        int valueToSearch = scanner.nextInt();
                        int index = arrayOps.search(valueToSearch);
                        if (index != -1) {
                            System.out.println("Value found at index: " + index);
                        } else {
                            System.out.println("Value not found.");
                        }
                        break;
                    case 4:
                        arrayOps.display();
                        break;
                    default:
                        System.out.println("Invalid operation.");
                }
            } else if (choice == 2) { // Linked List operations
                switch (operation) {
                    case 1:
                        System.out.print("Enter value to add: ");
                        int valueToAddLL = scanner.nextInt();
                        linkedListOps.add(valueToAddLL);
                        break;
                    case 2:
                        System.out.print("Enter value to remove: ");
                        int valueToRemove = scanner.nextInt();
                        linkedListOps.remove(valueToRemove);
                        break;
                    case 3:
                        System.out.print("Enter value to search: ");
                        int valueToSearchLL = scanner.nextInt();
                        int foundIndex = linkedListOps.search(valueToSearchLL);
                        if (foundIndex != -1) {
                            System.out.println("Value found at index: " + foundIndex);
                        } else {
                            System.out.println("Value not found.");
                        }
                        break;
                    case 4:
                        linkedListOps.display();
                        break;
                    default:
                        System.out.println("Invalid operation.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}
