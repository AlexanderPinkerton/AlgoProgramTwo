package com.alexanderpinkerton;

import java.util.Stack;

/**
 * Created by Ace on 3/26/15.
 */
public class StringComparisonUtility {


    public float computeEditDistance(String x, String y){

        int columnCount = x.length()+1;
        int rowCount = y.length()+1;

        int[] rowOne = new int[columnCount];
        int[] rowTwo = new int[columnCount];

        //Populate the first row.
        for(int i=0;i<columnCount;i++){
            rowOne[i] = i;
        }


        for(int rowIndex = 1; rowIndex < rowCount; rowIndex++){

            //Insert the correct value for the first element on string y.
            //Swap via even and odd checks.
            if(rowIndex%2 == 0){
                rowTwo[0] = rowIndex;
            }else{
                rowOne[0] = rowIndex;
            }


            for(int columnIndex = 1; columnIndex < columnCount; columnIndex++){

                if(rowIndex%2 == 0){

                    if(x.charAt(columnIndex-1) == y.charAt(rowIndex-1)){
                        // If the two symbols are equal, we copy the diagonal top-left value to the new cell.
                        rowOne[columnIndex] = rowTwo[columnIndex - 1];
                    }else{
                    /*If the two symbols are not equal, we examine the top cell and the left cell. We choose
                    the cell with the smaller value, we add one to that value, and we copy the incremented
                    value to the new cell.*/
                        int top = rowTwo[columnIndex];
                        int left = rowOne[columnIndex-1];
                        rowOne[columnIndex] = (top > left) ? ++left : ++top;
                    }

                }else{

                    if(x.charAt(columnIndex-1) == y.charAt(rowIndex-1)){
                        // If the two symbols are equal, we copy the diagonal top-left value to the new cell.
                        rowTwo[columnIndex] = rowOne[columnIndex - 1];
                    }else{
                    /*If the two symbols are not equal, we examine the top cell and the left cell. We choose
                    the cell with the smaller value, we add one to that value, and we copy the incremented
                    value to the new cell.*/
                        int top = rowOne[columnIndex];
                        int left = rowTwo[columnIndex-1];
                        rowTwo[columnIndex] = (top > left) ? ++left : ++top;
                    }

                }


            }

        }

        for(int i=0;i<columnCount;i++){
            System.out.print(rowOne[i] + " ");
        }
        System.out.println();
        for(int i=0;i<columnCount;i++){
            System.out.print(rowTwo[i] + " ");
        }


        return 69;
    }







    public int[][] computeEditDistanceTable(String x, String y){

        //Initialize the table to the size based on the input.
        //Add one to create a blank corner.
        int columnCount = x.length()+1;
        int rowCount = y.length()+1;

        int[][] table = new int[rowCount][columnCount];



        //Initialize the table =============
        //Downwards
        for(int i=0; i<columnCount;i++){
            table[0][i] = i;
        }

        //Across
        for(int i=0; i<rowCount;i++){
            table[i][0] = i;
        }
        //Initialize the table =============



        //MAIN TABLE GENERATION
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
        System.out.print("  ");
        for(int i=0;i<rowCount;i++){
            System.out.print(x.charAt(i) + " ");
        }

        System.out.println();

        for(int i=0;i<rowCount;i++){
            for(int j=0;j<columnCount;j++){
                //if(j==0 && i<y.length() && i>0){System.out.print(y.charAt(i-1) + " ");}else if(i==0 && j==0){System.out.print("  ");}
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }

        //================DEBUG OUTPUT================


        return table;
    }




    public String findLCS(String x, String y){

        //TODO Use linear memory.

        int[][] table = computeEditDistanceTable(x,y);

        Stack<Character> substring = new Stack<Character>();

        for(int columnIndex = x.length(), rowIndex = y.length(); columnIndex > 0 && rowIndex > 0; columnIndex--,rowIndex--){

            int top = table[rowIndex-1][columnIndex];
            int left = table[rowIndex][columnIndex-1];

            //If the symbols are equal, push the symbol on to a stack and move to the diagonal top-left neighbor.
            if(x.charAt(columnIndex-1) == y.charAt(rowIndex-1)){
                substring.push(x.charAt(columnIndex-1));
                System.out.println("Diagonal Movement");
            }else if(top==left){
                rowIndex++;
                System.out.println("Left Movement");
            }else if(top>left){
                rowIndex++;
                System.out.println("Left Movement");
            }else{
                columnIndex++;
                System.out.println("Upward Movement");
            }

        }

        return substring.toString();
    }























}
