package io.zipcoder;
import java.util.*;
/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     *           countYZ("day fez"); // Should return 2
     *           countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input){

        // write out a for loop the display all characters of a string

        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char yz = input.charAt(i);
            if ((yz == 'y') || ((yz == 'z')  )) {
                if (i != (input.length() - 1) &&  !Character.isLetter(input.charAt(i + 1))) {
                    count ++ ;
                } else if (i == input.length()-1) {
                    count ++;
                }

            }


        }
        System.out.println();
        return count;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     *
     * example : removeString("Hello there", "llo") // Should return "He there"
     *           removeString("Hello there", "e") //  Should return "Hllo thr"
     *           removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove){

        StringBuffer ans = new StringBuffer();
        // first go through 'base' one character at a time
        for (int i = 0; i < base.length(); i++) {

            //initialize a variable flag that can be counted if characters match in next step
            int flag = 0;

            //nested for loop that goes through the second string 'remove' one char at a time
            for (int j = 0; j < remove.length(); j++) {

                // if the character in 'remove' is equal to a character in 'base' a *flag* is *raised*
                if (base.charAt(i) == remove.charAt(j)) {
                    flag = 1;
                }
            }
            // returns characters to new string 'ans' if the *flag* was not raised on each character
            if (flag != 1)
                ans.append(base.charAt(i));
        }
        //returns ans to a string
        return ans.toString();


    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     *
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     *           containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     *           containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input){

        // these tracker variables will tick up every time 'is' and 'not' are found in the string and count up,
        // will compare these two variables with eachother at the end to determine if #'is' == #'not'
        int isTracker = 0;
        int notTracker = 0;

        // a for loop will track through the string line by line
        for ( int i = 0; i < input.length() -1; i++){
            //find any instances of the letter 'i' and see if
            //it is followed by the letter 's'. will tick up isTracker if conditions are met
            if ( input.charAt(i) == 'i' && input.charAt(i+1) == 's') {
            isTracker ++;
            }
            // same process looking for the word not
            if ( input.charAt(i) == 'n' && input.charAt(i+1) == 'o' && input.charAt(i+2) == 't'){
                notTracker ++;
            }
        }


        boolean b = isTracker == notTracker;
        return b;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     *           gHappy("xxgxx") // Should return  false
     *           gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input){
        //declaring all variables I will need, going to count how many 'g' characters are in the string. then
        //determine if each of those g's are 'happy'. if the number of gCount == happy, boolean will return true.
        int gCount = 0;
        int happy = 0;

        // a for loop to go through the string
        for (int i = 1; i < input.length() -1 ; i++){
            if (input.charAt(i) == 'g'){
                gCount ++;
            }
            if (input.charAt(i) == 'g' && input.charAt(i+1) == 'g' || input.charAt(i-1) == 'g'){
                happy ++;
            }
        }



        boolean results = gCount == happy;

        return results;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     *            countTriple("xxxabyyyycd") // Should return 3
     *            countTriple("a") // Should return 0
     */
    public Integer countTriple(String input){
        // declare a counter that adds 1 for every tripple found
        int trippleCounter = 0;
        //for loop looking through characters in input 1 at a time. stops looking at input -3 so that it does not
        //try to start looking 2 characters ahead of the last two characters which will make it fail testing
        for (int i = 0; i < input.length()-3; i++){

            if (input.charAt(i) == input.charAt(i+1) && input.charAt(i) == input.charAt(i+2)){
                trippleCounter ++;
            }
        }


        return trippleCounter;
    }
}
