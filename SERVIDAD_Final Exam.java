import java.util.Arrays;
import java.util.Stack;

public class CreatureSorter {

    public static void main(String[] args) {
        // Input data
        String[] creatures = {"Dragon", "Griffin", "Unicorn", "Phoenix", "Centaur"};
        int[] powerLevels = {95, 88, 78, 92, 85};

        // Bubble Sort (Descending)
        bubbleSortDescending(powerLevels, creatures);

        // Selection Sort (Ascending)
        selectionSortAscending(powerLevels, creatures);

        // Stack Implementation
        stackImplementation(creatures, powerLevels);
    }

    // Bubble Sort (Descending)
    static void bubbleSortDescending(int[] arr, String[] creatures) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    // Swap power levels
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    // Swap creatures
                    String tempCreature = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = tempCreature;
                }
            }
        }
        System.out.println("* Bubble Sort: Descending Order by Power Level *");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(creatures[i] + " - " + arr[i]);
        }
        System.out.println();
    }


    // Selection Sort (Ascending)
    static void selectionSortAscending(int[] arr, String[] creatures) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap power levels
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            // Swap creatures
            String tempCreature = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = tempCreature;
        }
        System.out.println("* Selection Sort: Ascending Order by Power Level *");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(creatures[i] + " - " + arr[i]);
        }
        System.out.println();
    }

    // Stack Implementation
    static void stackImplementation(String[] creatures, int[] powerLevels) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> powerStack = new Stack<>();

        // Push onto stack (using bubble sort order for this example)
        bubbleSortDescending(powerLevels, creatures);

        for (int i = 0; i < creatures.length; i++) {
            stack.push(creatures[i]);
            powerStack.push(powerLevels[i]);
        }

        System.out.println("* Stack Implementation: Popping Creatures *");
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop() + " - " + powerStack.pop());
        }
    }
}
