package com.alexanderpinkerton;

public class Main {

    public static void main(String[] args) {
	// write your code here

        StringComparisonUtility utility = new StringComparisonUtility();

        //Example One
        //System.out.println(utility.findLCS("agttgtagct","agtgctact"));
        //utility.computeEditDistance("agttgtagct","agtgctact");

         /*Example Two      0.444444        n c a r n a     n c a o n a     */
        //System.out.println(utility.findLCS("ncaatournament","northcarolina"));
        //utility.computeEditDistance("ncaatournament","northcarolina");



        //Document Example
        System.out.println(utility.findLCS("agtacgtcat","gtatcgtat"));
        utility.computeEditDistance("agtacgtcat","gtatcgtat");

    }


}
