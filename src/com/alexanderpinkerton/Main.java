package com.alexanderpinkerton;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * Created by Alexander Pinkerton on 3/26/15.
 *
 **/


public class Main {

    public static void main(String[] args) {

        StringComparisonUtility utility = new StringComparisonUtility();
        //utility.setDebug(true);

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(args[0]));
            BufferedReader  br2 = new BufferedReader(new FileReader(args[1]));
            String x = br2.readLine();
            String y = br1.readLine();
            System.out.println(utility.computeEditDistance(x,y));
            System.out.println(utility.findLCS(x,y));
        } catch (IOException e) {
            System.out.println("Invalid or Missing File Arguments.");
        }


        //Example One       0.842105        a g t g t a c t
        //System.out.println(utility.findLCS("agttgtagct","agtgctact"));
        //System.out.println(utility.computeEditDistance("agttgtagct","agtgctact"));

    }


}
