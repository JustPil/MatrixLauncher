package ML;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        instructions();
        Scanner scn = new Scanner(System.in);
        Matrix m = new Matrix();
        String choice = "";
        while(!choice.equalsIgnoreCase("x"))
        {
            System.out.print("\nOptions:\n1 - LAUNCH CATAPULT - Launch your catapult at an index by passing row " +
                    "and column\n2 - MATRIX RESET - Reset the matrix to randomly selected indices\n3 - INSTRUCTIONS" +
                    " Display the instructions\nX - TERMINATE\n\nEnter choice: ");
            choice = scn.nextLine();
            if(choice.equals("1"))
            {
                System.out.print("Enter a ROW (1 - 3): ");
                int row = scn.nextInt();
                scn.nextLine();
                System.out.print("Enter a COLUMN (1 - 3): ");
                int col = scn.nextInt();
                m.launch(--row, --col);
                scn.nextLine();
            }
            else if(choice.equals("2"))
            {
                m.matrixReset();
                System.out.println("The matrix has been reset.");
            }
            else if(choice.equals("3"))
            {
                instructions();
            }
            else if(choice.equalsIgnoreCase("X"))
            {
                break;
            }
            else
            {
                System.out.println("Invalid choice");
            }
        }
    }

    /**
     * instructions Instructions for the Matrix Launcher game.
     */
    public static void instructions()
    {
        System.out.println("Welcome to MATRIX LAUNCHER\nYou have a 3 x 3 MATRIX of random numbers 1 through 3.\nYou " +
                "will select a ROW and COLUMN to launch your CATAPULT at.\nWhen the target is hit, its neighbors " +
                "to the RIGHT, LEFT, TOP, and BOTTOM will be POPPED if they happen to match the target." +
                "\nThen the popped indices will FLOAT up and unpopped indices will SHIFT down.");
    }
}
