import java.util.ArrayList; // import array for menu
import java.util.Scanner;

public class Main {

    // initialize the array list used for the menu
    static ArrayList<String> menuArrayList = new ArrayList<>();
    // initialize the scanner for user input
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        // initialize variable for quitting/continuing
        boolean exitProgram = false;
        // loop continuously until user quits
        while(!exitProgram) {
            displayMenu(); // display the menu
            // ask user for input of menu selection
            String choice = SafeInput.getRegExString(in, "Please enter your menu selection (A, D, P, Q): ","[AaDdPpQq]");
            // switch case structure based on user input to select menu option, will run desired method
            switch (choice.toUpperCase()) {
                case "A": // if user enters A or a, it will allow user to add to list or array
                    addItem();
                    break;
                case "D":
                 //   deleteItem();
                    break;
                case "P": // if user enters P or p, it will print out list/array
                    printList();
                    break;
                case "Q": // if user enters Q or q, it will ask to confirm their exit
                    exitProgram = confirmExit();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print out the list");
        System.out.println("Q - Quit/Exit the program");
    }

    // method to add item to list/array
    private static void addItem() {
        String item = SafeInput.getNonZeroLenString(in, "Enter an item to add");
        menuArrayList.add(item);
        System.out.println("Item added: " + item);
    }


    // method to print out list
    private static void printList() {
        System.out.println("Current list/array:");
        displayNumberedItems();
    }

    // method to confirm user wanting to exit program
    private static boolean confirmExit() {
        // returns the user input of True (Yes) or False (No)
        return SafeInput.getYNConfirm(in,"Are you sure you want to quit? (Y/N): ");
    }

    private static void displayNumberedItems() {
        // iterates through array and numbers the elements and prints out a numbered list of elements
        for (int i = 0; i < menuArrayList.size(); i++) {
            System.out.println((i + 1) + ". " + menuArrayList.get(i));
        }
    }
}