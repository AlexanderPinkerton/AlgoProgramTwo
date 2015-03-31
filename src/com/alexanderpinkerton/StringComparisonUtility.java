package com.alexanderpinkerton;

import java.util.Collections;
import java.util.Stack;

/**
 *
 * Created by Alexander Pinkerton on 3/26/15.
 *
 **/

public class StringComparisonUtility {

    private boolean debug = false;

    public float computeEditDistance(String x, String y){
        /*
        This function will calculate the normalized edit distance between two strings via
        dynamic programming and linear memory allocation. Only two rows of the table are needed to
        obtain the final result.
     */
        int columnCount = x.length()+1;
        int rowCount = y.length()+1;

        int[] backwardRow = new int[columnCount];
        int[] forwardRow = new int[columnCount];
        int[] temp;

        //Populate the first row.
        for(int i=0;i<columnCount;i++){
            backwardRow[i] = i;
        }

        //Start at the forward row since the backward row is given.
        for(int rowIndex = 1; rowIndex < rowCount; rowIndex++){
            //Insert the correct value for the first element on string y.
            forwardRow[0] = rowIndex;

            //Start at the second column since the first column is given by the previous statement.
            for(int columnIndex = 1; columnIndex < columnCount; columnIndex++){
                    if(x.charAt(columnIndex-1) == y.charAt(rowIndex-1)){
                     // If the two symbols are equal, we copy the diagonal top-left value to the new cell.
                        forwardRow[columnIndex] = backwardRow[columnIndex - 1];
                    }else{
                    //If the two symbols are not equal, we examine the top cell and the left cell. We choose
                    //the cell with the smaller value, we add one to that value, and we copy the incremented
                    //value to the new cell.
                        int top = backwardRow[columnIndex];
                        int left = forwardRow[columnIndex-1];
                        forwardRow[columnIndex] = (top > left) ? ++left : ++top;
                    }
            }
            //=================DEBUG OUTPUT===================
            if(debug) {
                if (rowIndex == 1) {
                    for (int i = 0; i < columnCount; i++) {
                        System.out.print(backwardRow[i] + " ");
                    }
                    System.out.println("-----------B-------------");
                }
                for (int i = 0; i < columnCount; i++) {
                    System.out.print(forwardRow[i] + " ");
                }
                System.out.println("-----------F------------");
            }
            //=================DEBUG OUTPUT===================

            //Swap the two rows for Linear Memory.
            temp = backwardRow;
            backwardRow = forwardRow;
            forwardRow = temp;
        }

        //(S1+S2-NED)/(S1+S2) = Normalized Edit Distance
        float normalizedEditDistance = (x.length()+y.length()-forwardRow[columnCount-1]) / (float)(x.length() + y.length());

        return normalizedEditDistance;
    }




    public int[][] computeEditDistanceTable(String x, String y){
        /*
            This function will calculate and build the entire table to be used for
            the Least Common Substring backtrace. This does not use linear memory as
            the entire table is stored.
         */

        //Initialize the table to the size based on the input.
        //Add one to create a blank corner.
        int columnCount = x.length()+1;
        int rowCount = y.length()+1;

        int[][] table = new int[rowCount][columnCount];


        //============= Initialize the table =============
        //Downwards
        for(int i=0; i<columnCount;i++){
            table[0][i] = i;
        }

        //Across
        for(int i=0; i<rowCount;i++){
            table[i][0] = i;
        }
        //================================================

        //Loop through every cell to assign a value. Skip the first rows since they are complete.
        for(int rowIndex = 1; rowIndex < rowCount; rowIndex++){

            for(int columnIndex = 1; columnIndex < columnCount; columnIndex++){

                if(x.charAt(columnIndex-1) == y.charAt(rowIndex-1)){
                    // If the two symbols are equal, we copy the diagonal top-left value to the new cell.
                    table[rowIndex][columnIndex] = table[rowIndex - 1][columnIndex - 1];
                }else{
                    /*If the two symbols are not equal, we examine the top cell and the left cell. We choose
                    the cell with the smaller value, we add one to that value, and we copy the incremented
                    value to the new cell.*/
                    int top = table[rowIndex-1][columnIndex];
                    int left = table[rowIndex][columnIndex-1];

                    table[rowIndex][columnIndex] = (top > left) ? ++left : ++top;
                }
            }
        }
        //================DEBUG OUTPUT================
        if(debug) {
            System.out.print("  ");
            for (int i = 0; i < rowCount; i++) {
                System.out.print(x.charAt(i) + " ");
            }
            System.out.println();
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < columnCount; j++) {
                    //if(j==0 && i<y.length() && i>0){System.out.print(y.charAt(i-1) + " ");}else if(i==0 && j==0){System.out.print("  ");}
                    System.out.print(table[i][j] + " ");
                }
                System.out.println();
            }
        }
        //=============================================
        return table;
    }




    public String findLCS(String x, String y){
        /*
            This function will use a complete edit distance table to obtain the
            Longest Common Substring. Starting from the bottom right cell of the table,
            the algorithm will move backwards through the data to find the LCS.
         */

        int[][] table = computeEditDistanceTable(x,y);

        Stack<Character> substring = new Stack<Character>();

        //Starting from the bottom-right cell, backtrace diagonally backwards until the end of the table is reached.
        //The control flow statements will modify the values and reroute the backtrace loop to find the LCS.
        for(int columnIndex = x.length(), rowIndex = y.length(); columnIndex > 0 && rowIndex > 0; columnIndex--,rowIndex--){

            int top = table[rowIndex-1][columnIndex];
            int left = table[rowIndex][columnIndex-1];

            //If the symbols are equal, push the symbol on to a stack and move to the diagonal top-left neighbor.
            if(x.charAt(columnIndex-1) == y.charAt(rowIndex-1)){
                substring.push(x.charAt(columnIndex-1));
                //System.out.println("Diagonal Movement");
            }else if(top==left){
                rowIndex++;
                //System.out.println("Left Movement");
            }else if(top>left){
                rowIndex++;
                //System.out.println("Left Movement");
            }else{
                columnIndex++;
                //System.out.println("Upward Movement");
            }
        }

        Collections.reverse(substring);

        StringBuilder b = new StringBuilder();
        for (char value : substring) {
            b.append(value);
        }

        return b.toString();
    }




    public void setDebug(boolean debug){
        this.debug = debug;
    }


}
