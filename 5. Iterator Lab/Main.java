
/**
 * @author Emran Abbamacha
 */

package com.emran;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numList = new ArrayList<>();

        createList(numList);
        System.out.println("Initial List: ");
        displayList(numList);
        System.out.println();
        //scanAndRemovePairs(numList);
        while(scanAndRemovePairs(numList)){
            scanAndRemovePairs(numList);
        } // end while

    } // end main method


    /**
     * Creates a list of 20 random numbers from 10-99
     *
     * @param numList array list of integers
     */
    public static void createList(ArrayList<Integer> numList){
        Random rand = new Random();
        int minRand = 10;
        int maxRand = 99;
        int range = maxRand - minRand;
        for(int i=0; i<20; i++){
            int randNum = Math.abs(rand.nextInt(range)) + minRand;
            numList.add(randNum);
        } // end for

    } // end createList

    /**
     * Searches through ArrayList to find matching pairs
     *
     * @param numList array list of integers
     * @return true if matching pair was found, false if no matching pairs were found
     */
    public static boolean scanAndRemovePairs(ArrayList<Integer> numList){

        while(true){
            ListIterator<Integer> it = numList.listIterator();

            int num1;
            int num2;

            boolean isRemoved = false;
            while(it.hasNext()){
                num1 = it.next();
                if(!it.hasNext()){
                    break;
                } // end if
                num2 = it.next();
                if(removable(num1, num2)) {
                    System.out.println("\nRemoved pair: " + num1 + " and " + num2);
                    it.remove();
                    it.previous();
                    it.remove();
                    isRemoved = true;
                    continue;
                } // end if
            } // end while

            if(!isRemoved){
                System.out.println("No more matching pairs: ");
                displayList(numList);
                break;
            } // end if

        } // end while

        if(numList.size()==0)
            return true;
        return false;
    } // end scanAndRemovePairs

    /**
     * Tests 2 integers in array list to see if either digit matches
     *
     * @param a first number to test from array list of integers
     * @param b second number to test from array list of integers
     * @return true if both integers match, false if integers do not
     */
    public static boolean removable(Integer a, Integer b){
        if(a / 10 == b / 10 || a % 10 == b % 10){
            return true;
        } // end if
        return false;
    } // end removable

    /**
     * Displays array list
     *
     * @param numList array list of integers
     */
    public static void displayList(ArrayList<Integer> numList){
        ListIterator<Integer> it = numList.listIterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        } // end while
    } // end displayList

} // end Main class