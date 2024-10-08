// Name: Laith Wajeeh
// Class: CS 145
// Assignment: Lab 6: Recursion - Pascal
// Sources: stackexchange.com and chatgpt (for converting my desmos functions to java code).
// Purpose: Demonstrates the use of recursion through the printing of pascal's triangle.

import java.util.ArrayList;

public class Recursion {
        // Some color codes I found on stackexchange.
        // Reset
        public static final String RESET = "\033[0m";  // Text Reset

        // Regular Colors
        public static final String RED = "\033[0;31m";     // RED
        public static final String GREEN = "\033[0;32m";   // GREEN
        public static final String BLUE = "\033[0;34m";    // BLUE

    public static void main(String[] args) {
    pascalTri(new ArrayList<Double>(0), new ArrayList<Double>(0),20.0, 20.0);
    System.out.println("");
    }

    //recursively print pascal's triangle. Takes in two empty ArrayLists and two Doubles both the amount of levels you want on the triangle.
    public static void pascalTri(ArrayList<Double> preLevl, ArrayList<Double> curLevl, Double totlLevl, Double curIndex) {

        //determines how many starting spaces are needed to make room for all of the levels; it does this by finding the last middle value's log to determine the needed spacing and making sure it's even.   
        Double spaces = Math.ceil((Math.log10((Math.pow(10, (0.5 * (Math.log10(2) + Math.log10(Math.PI)) + 0.5 * Math.log10(totlLevl) + totlLevl * (Math.log10(totlLevl) - Math.log10(Math.E))))/(Math.pow(10, (0.5 * (Math.log10(2) + Math.log10(Math.PI)) + 0.5 * Math.log10(totlLevl/2) + totlLevl/2 * (Math.log10(totlLevl/2) - Math.log10(Math.E))))*Math.pow(10, (0.5 * (Math.log10(2) + Math.log10(Math.PI)) + 0.5 * Math.log10(totlLevl-totlLevl/2) + (totlLevl-totlLevl/2) * (Math.log10(totlLevl-totlLevl/2) - Math.log10(Math.E))))))))/2 + 0.5 + 1) * 2;
        
        //spaces the lines correctly
        if (curIndex > 0 && curLevl.isEmpty()) {
            System.out.println("");
            System.out.print(String.format("%1$"+(curIndex*spaces/2)+"s", ""));
        } 
        
        if (curIndex > 0) {
            // writes the beginning 1 of each line when on new level of pascal's triangle
            if (preLevl.size() - 1 >= curLevl.size() && !preLevl.isEmpty() && curLevl.isEmpty()) {
                System.out.print(GREEN + "1" + String.format("%1$"+(spaces - 1)+"s", "") + RESET);
                curLevl.add(1.0);
                pascalTri(preLevl, curLevl, totlLevl, curIndex);
            //writes end 1 and new line when the size of the current line exceeds the previous by 2
            } else if (preLevl.size() < curLevl.size() + 1) {
                System.out.println(GREEN + "1" + RESET);
                curLevl.add(1.0);
                pascalTri(curLevl, new ArrayList<Double>(0),totlLevl, curIndex - 1);
            //writes the sum of the two values above it and adds it to the curLevl ArrayList.
            } else {
                double curVal = preLevl.get(curLevl.size() - 1) + preLevl.get(curLevl.size());
                curLevl.add(curVal);
                System.out.print(BLUE + String.format("%.0f", curVal) + String.format("%1$"+(spaces - 1 - Math.floor(Math.log10(curVal)))+"s", "") + RESET);
                pascalTri(preLevl, curLevl, totlLevl, curIndex);
            }
        }
        


    }

}