import java.util.ArrayList; // import array for menu
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // initialize the array list used for the menu
        ArrayList<String> menuArrayList = new ArrayList<>();
        // initialize the scanner for user input
        Scanner in = new Scanner(System.in);
        // initialize variable for quitting/continuing
        boolean exitProgram = false;
        // loop continuously until user quits
        while(!exitProgram) {
            displayMenu(); // display the menu
            // ask user for input of menu selection
            String choice = SafeInput.getRegExString(in, "Please enter your menu selection (A, D, P, Q): ","[AaDdPpQq]");
            // switch case structure based on user input to select menu option, will run desired method
            switch (choice.toUpperCase()) {
                case "A":
                  //  addItem();
                    break;
                case "D":
                 //   deleteItem();
                    break;
                case "P":
                //    printList();
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

    private static boolean confirmExit() {
        Scanner exit = new Scanner(System.in); // new scanner for user input of Y or N
        // returns the user input of True (Yes) or False (No)
        return SafeInput.getYNConfirm(exit,"Are you sure you want to quit? (Y/N): ");
    }
}