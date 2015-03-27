package com.alexanderpinkerton;

/**
 * Created by Ace on 3/26/15.
 */
public class NormalizedStringUtility {




    public NormalizedStringUtility(){

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


}
