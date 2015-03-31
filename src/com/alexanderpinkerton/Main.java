package com.alexanderpinkerton;

public class Main {

    public static void main(String[] args) {

        StringComparisonUtility utility = new StringComparisonUtility();
        //utility.setDebug(true);

        //System.out.println(utility.findLCS(args[1],args[0]));
        //System.out.println(utility.computeEditDistance(args[1],args[0]));


        //Example One       0.842105        a g t g t a c t
        //System.out.println(utility.findLCS("agttgtagct","agtgctact"));
        //System.out.println(utility.computeEditDistance("agttgtagct","agtgctact"));

         /*Example Two      0.444444        n c a r n a     n c a o n a     */
        //System.out.println(utility.findLCS("ncaatournament","northcarolina"));
        //System.out.println(utility.computeEditDistance("ncaatournament","northcarolina"));

         /*Example Three    0.666667    a l g o r i t h m s r o c k s i l o v e t h i s c l a s s */
        System.out.println(utility.findLCS("zalgoxrithmsrxocksxzilozxxvethzisclzaxzzsxs", "qalgoriythmsqrowwcksqqwqilowvqethiqsclqawssw"));
        System.out.println(utility.computeEditDistance("zalgoxrithmsrxocksxzilozxxvethzisclzaxzzsxs","qalgoriythmsqrowwcksqqwqilowvqethiqsclqawssw"));



        //Document Example
        //System.out.println(utility.findLCS("agtacgtcat","gtatcgtat"));
        //utility.computeEditDistance("agtacgtcat","gtatcgtat");

    }


}
