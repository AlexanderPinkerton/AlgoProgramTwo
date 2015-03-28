package com.alexanderpinkerton;

public class Main {

    public static void main(String[] args) {
	// write your code here

        StringComparisonUtility utility = new StringComparisonUtility();

        //Example One
        //System.out.print(utility.findLCS("agttgtagct","agtgctact"));

         /*Example Two      0.444444        n c a r n a     n c a o n a     */
        System.out.print(utility.findLCS("ncaatournament","northcarolina"));



        //Document Example
        //System.out.print(utility.findLCS("agtacgtcat","gtatcgtat"));

    }


}
