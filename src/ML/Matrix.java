package ML;

import java.util.Random;

public class Matrix
{
    private int[][] matrix;
    private Random random = new Random();

    /**
     * Constructor calls the matrixReset method to create a matrix array.
     */
    public Matrix()
    {
        matrixReset();
    }

    /**
     * matrixReset Sets the matrix variable to a 3 x 3 matrix of pseudorandom integers from 1 to 3.
     */
    public void matrixReset()
    {
        matrix = new int[][]{{random.nextInt(3) + 1, random.nextInt(3) + 1, random.nextInt(3) + 1},
                {random.nextInt(3) + 1, random.nextInt(3) + 1, random.nextInt(3) + 1},
                {random.nextInt(3) + 1, random.nextInt(3) + 1, random.nextInt(3) + 1}};
    }

    /**
     * launch Checks if the index parameters are within the bounds of the matrix. If so, it calls the display, pop, and
     * shift methods to direct an entire player's turn to the end result of that turn.
     * @param i The index row.
     * @param j The index column.
     */
    public void launch(int i, int j)
    {
        if(i >= matrix.length || i < 0 || j >= matrix[0].length || j < 0)
        {
            System.out.println("Indexes are out of bounds.");
        }
        else
        {
            System.out.println("Initial matrix:");
            display();
            System.out.println("You launch the catapult at row " + i + " column " + j + "!\nPOP!");
            pop(i, j);
            display();
            System.out.println("SHIFT!");
            shift();
            display();
        }
    }

    /**
     * pop Sets the target index and its immediate neighbors to 0 if the neighbors match the integer value of target.
     * @param i The matrix row.
     * @param j The matrix column.
     */
    private void pop(int i, int j)
    {
        if(i + 1 < matrix.length && matrix[i + 1][j] == matrix[i][j])
        {
            matrix[i + 1][j] = 0;
        }
        if(i - 1 >= 0 && matrix[i - 1][j] == matrix[i][j])
        {
            matrix[i - 1][j] = 0;
        }
        if(j + 1 < matrix[i].length && matrix[i][j + 1] == matrix[i][j])
        {
            matrix[i][j + 1] = 0;
        }
        if(j - 1 >= 0 && matrix[i][j - 1] == matrix[i][j])
        {
            matrix[i][j - 1] = 0;
        }
        matrix[i][j] = 0;
    }

    /**
     * shift Swaps matrix values such that zeroes will shift above nonzero integers, if applicable.
     */
    private void shift()
    {
        for(int j = 0; j < matrix[0].length; j++)
        {
            if(matrix[2][j] == 0 && matrix[1][j] == 0 && matrix[0][j] != 0)
            {
                int swap = matrix[0][j];
                matrix[0][j] = 0;
                matrix[2][j] = swap;
            }
            if(matrix[2][j] == 0 && matrix[1][j] != 0)
            {
                int swap = matrix[1][j];
                matrix[1][j] = 0;
                matrix[2][j] = swap;
                swap = matrix[0][j];
                matrix[0][j] = 0;
                matrix[1][j] = swap;
            }
            if(matrix[1][j] == 0 && matrix[0][j] != 0 && matrix[2][j] != 0)
            {
                int swap = matrix[0][j];
                matrix[0][j] = 0;
                matrix[1][j] = swap;
            }
        }
    }

    /**
     * display Outputs a display of the current matrix.
     */
    private void display()
    {
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
