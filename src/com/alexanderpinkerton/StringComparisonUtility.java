package com.alexanderpinkerton;

import java.util.Stack;

/**
 * Created by Ace on 3/26/15.
 */
public class StringComparisonUtility {




    public StringComparisonUtility(){

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

        int[][] table = computeEditDistanceTable(x,y);

        Stack<Character> substring = new Stack<Character>();

        for(int columnIndex = x.length(), rowIndex = y.length(); columnIndex > 0 && rowIndex > 0; columnIndex--,rowIndex--){

            //System.out.println("columnIndex: " + columnIndex);
            //System.out.println("rowIndex: " + rowIndex);


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
