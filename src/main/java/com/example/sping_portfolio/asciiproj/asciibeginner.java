package com.example.sping_portfolio.asciiproj;

public class asciibeginner {
    /**
     *
     * @param x A 2D array to print
     * @param showCommas Whether or not to display the commas
     */
    public static void printArray(double[][] x, boolean showCommas) {
        // Loops through rows
        for (int n = 0; n < x.length; n++) {
            // For each row, I loop through all of the elements of
            // that row (all of the columns)
            for (int a = 0; a < x[n].length; a++) {
                System.out.print(x[n][a]);
                if (showCommas && a < x[n].length - 1) {
                    System.out.print(",");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        double[][] x = new double[20][15];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                x[i][j] = 1;
            }
        }

        for (int i = 15; i < 20; i++) {
            for (int j = 10; j < 15; j++) {
                x[i][j] = 2;
            }
        }

        int index = 0;
        while (index < x.length && index < x[index].length) {
            x[index][index] = 7;
            index++;
        }

        printArray(x, false);
    }

}
