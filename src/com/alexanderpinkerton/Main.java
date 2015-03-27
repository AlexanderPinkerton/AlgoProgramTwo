package com.alexanderpinkerton;

public class Main {

    public static void main(String[] args) {
	// write your code here

        NormalizedStringUtility utility = new NormalizedStringUtility();

        //utility.computeEditDistanceTable("ncaatournament","northcarolina");

        utility.computeEditDistanceTable("agtacgtcat","gtatcgtat");





    }

/*
    //MAIN TABLE GENERATION
    for(int rowIndex = 1; rowIndex < x.length(); rowIndex++){

        for(int columnIndex = 1; columnIndex < y.length(); columnIndex++){
            //Skip the first cell as it is always 0
            //if(acrossIndex == 0 && downIndex == 0){continue;}

            if(x.charAt(rowIndex) == y.charAt(columnIndex)){
                // If the two symbols are equal, we copy the diagonal top-left value to the new cell.
                table[columnIndex][rowIndex] = table[columnIndex - 1][rowIndex - 1];
            }else{

                table[columnIndex][rowIndex] = table[columnIndex][rowIndex -1];
            }

        }

    }

*/





}
