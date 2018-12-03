/**
 * @author joey pham
 * @date 10 September 2018
 * @description this program stores 10 integers into an array that the user inputted and 
  *             allows the user to interact with their array.
 */


import java.util.Scanner;

public class Lab2 { 
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int [] userArray = populateArray(); // ask user to fill the array with 10 integers
        printMenu();
        int menuChoice = getMenuChoice();
        while (menuChoice != 8) { // while the user hasn't quit yet
            if (menuChoice == 1) {
                System.out.print("\n" + "Your array: [");
                displayValues(userArray);
            } else if (menuChoice == 2) {
                displayReversed(userArray);
            } else if (menuChoice == 3) {
                System.out.print("\n" + "Sum of values in the array: " + computeSum(userArray) + "\n");
            } else if (menuChoice == 4) {
                System.out.print("\n" + "Maximum value of the array: " + maxValue(userArray) + "\n");
            } else if (menuChoice == 5) {
                int searchValue = getSearchValue(); // keep track of the value wanted to be searched
                int indexOfValue = findIndexOfValue(userArray, searchValue); // returns index of the value and assigns to a variable
                if (indexOfValue == -1) { // if the value prompted was not found in the array
                    System.out.println("\n" + "That value does not exist inside the arary.");
                } else { // gets here if value was found and an index was returned
                    System.out.println("\n" + "The first occurence of that value is at index " + indexOfValue + ".");
                }
            } else if (menuChoice == 6) {
                int indexInput = getIndexInput(); // asks for the index of the new value
                int valueInput = getValueInput(); // asks for the value
                userArray = replaceValue(userArray, indexInput, valueInput); // update array with new index and value
                System.out.print("Your new array is: [");
                displayValues(userArray);
            } else if (menuChoice == 7) {
                System.out.println("\n" + "Resetting Values");
                userArray = populateArray(); // resets array with user's new numbers
            }
            printMenu(); // comes here after desired function has been fulfilled and loops menu again
            menuChoice = getMenuChoice(); // gets menu choice before loop 
        }
        System.out.println("\n" + "Goodbye!"); // says cy@ if menuchoice = 8
        input.close();
    }

    /**Description: asks the user for the new index of the array in the range [1-10]
      *@return number of index translated from layman's to coding terms, [0-9]
      */
    public static int getIndexInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n" + "Enter the index of which you want to replace: ");
        while (0 < 1) { // keep looping until returns, which breaks the loop
            if (input.hasNextInt()) { // validates input is an integer
                int index = input.nextInt();
                if (index > 0 && index < 11) { // makes sure it's within 1-10, layman's terms
                    return (index - 1); // return in coding terms
                }
            }
            System.out.print("Please enter a valid index: "); // reaches here if it doesn't pass
            input.nextLine();
        }
    }

    /**Description: prompts the user for a numbe and passes it as long as it's an integer
      *@return target value that the user wants to replace with
      */
    public static int getValueInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your new value: ");
        while (0 < 1) { // keeps going until broken by return
            if (input.hasNextInt()) { // if is an integer
                return input.nextInt(); // returns
            }
            System.out.print("Please enter an integer: ");
            input.nextLine();
        }
    }

    /**Description: prompts for the user's menu choice and passes it out as long as it's [1-8]
      *@return user's menu choice 
      */
    public static int getMenuChoice() {
        System.out.print("Enter a number: ");
        Scanner input = new Scanner(System.in);
        while (0 < 1) { // keeps going until broken by return
            if (input.hasNextInt() == true) { // if input is an integer
                int menuChoice = input.nextInt();
                if (menuChoice > 0 && menuChoice < 9) { // checks if in menu range, 1-8
                    input.nextLine();
                    return menuChoice;
                }
            }
            // will only get here if userinput doesnt pass
            System.out.print("Please enter a valid number :");
            input.nextLine();
        }
    }

    /**Description: prompts the user for a value they would like to search for in the array
      *@return target value as long as it is an integer
      */
    public static int getSearchValue() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n" + "Enter the value you are looking for: ");
        while (0 < 1) { // forever loop until broken by the return
            if (input.hasNextInt()) { // if input is an integer
                return input.nextInt(); // return value
            }
            System.out.print("\n" + "Enter an integer: "); // prompts for a valid number
            input.nextLine();
        }
    }

    /**Description: prompts the user for 10 integers and stores it into an array
      *@return array of 10 valid integers the user inputted
      */
    public static int [] populateArray() { 
        Scanner input = new Scanner(System.in);
        int [] userArray = new int [10]; // create array of length 10
        System.out.println("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) { // prompts for 10 VALID integers
            boolean isValid = false;
            while (isValid == false) { // keep asking for valid integer 
                if (input.hasNextInt() == true) { // if input is an integer
                    userArray[i] = input.nextInt(); // add input to array
                    isValid = true; // so it goes to the next input
                    input.nextLine(); // clear
                } else {
                    System.out.println("Please enter an integer: ");
                    input.nextLine(); // clear
                }
            }
        }
        return userArray;
    }

    /**Description: displays array separated by commas
      *@param passes in array and its values
      */
    public static void displayValues (int [] userArray) {
        System.out.print(userArray[0]); // first value
        for (int i = 1; i < 10; i++) { // iterate
            System.out.print(", " + userArray[i]); // space out values with a comma and space
        }
        System.out.print("]" + "\n"); // close message
    }

    /**Description: displays array reversed separated by commas
      *@param passes in array and its values
      */
    public static void displayReversed (int [] userArray) {
        System.out.print("\n" + "Your reversed array: [" + userArray[9]); // display message and first value
        for (int i = 8; i > -1; i--) { // iterates
            System.out.print(", " + userArray[i]); // space out values with a comma and space
        }
        System.out.print("]" + "\n"); // close message
    }

    /**Description: finds the first index of the user's target value 
      *@param passes in the array and its values
      *            passes in user's target value
      *@return returns index of target value in layman's
      */
    public static int findIndexOfValue (int [] userArray, int searchValue){
        for (int i = 0; i < 10; i++) { // iterates
            if (searchValue == userArray[i]) { // if target value matches current array value
                return (i + 1); // returns index in layman's 
            }
        }
        return -1;
    }

    /**Description: replaces value of user's choice with user's value and returns the array
      *@param passes in the array and its values
      *            passes in user's chosen target index to replace at
      *            passes in user's chose target value to replace with
      *@return returns the array with the replaced value
      */
    public static int [] replaceValue (int [] userArray, int index, int value){
        userArray[index] = value; // replace value
        return userArray;
    }

    /**Description: iterates through the array to find the max value
      *@param passes in the array and its values 
      *@return returns the max value inside the array
      */
    public static int maxValue (int [] userArray) {
        int max = 0;
        for (int i = 0; i < 10; i++) { // iterate
            if (userArray[i] > max) { // if current array value is greater than the current max
                max = userArray[i]; // update
            }
        }
        return max;
    }

    /**Description: adds all the values of the array together
      *@param passes in the array and its values
      *@return sum of the array
      */
    public static int computeSum (int [] userArray) {
        int sum = 0;
        for (int i = 0; i < 10; i ++) { // iterates through each value
            sum = sum + userArray[i]; // add the current value to the sum
        }
        return sum;
    }

    /**Description: prints menu 
      */
    public static void printMenu() {
        System.out.println("\n" + "Menu");
        System.out.println("1. Display Values");
        System.out.println("2. Display Reveresed");
        System.out.println("3. Display Sum");
        System.out.println("4. Display Maximum");
        System.out.println("5. Search for a Value");
        System.out.println("6. Replace Value");
        System.out.println("7. Reset Values");
        System.out.println("8. Quit" + "\n");
    }
}