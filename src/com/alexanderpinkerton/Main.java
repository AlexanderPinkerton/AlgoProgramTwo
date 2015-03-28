package com.alexanderpinkerton;

public class Main {

    public static void main(String[] args) {
	// write your code here

        StringComparisonUtility utility = new StringComparisonUtility();

        //utility.computeEditDistanceTable("ncaatournament","northcarolina");

        //utility.computeEditDistanceTable("agtacgtcat","gtatcgtat");

        System.out.print(utility.findLCS("agtacgtcat","gtatcgtat"));

    }


}
