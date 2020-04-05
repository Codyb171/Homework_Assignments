package HomeWork_4;
/* Author Name: Cody Bishop
   Date: 
   Program: 
   Description
*/

import java.util.Scanner;

public class ExamRework {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter quantity of averages to generate: ");
        int numWanted = scan.nextInt();
        double average = (numWanted + 30) / 2;
        double aboveAvg = 0;
        double belowAvg = 0;
        for (int i = 0; i < numWanted; i++)
        {
            int low = numRanger(i,i+15);
            int high = numRanger(i+15, i+30);
            double averagedNum = sumOfAverages(low,high);
            if (averagedNum > average)
            {
                aboveAvg += 1;
            }
            if (averagedNum < average)
            {
                belowAvg+= 1;
            }
            System.out.printf("[%.2f]", averagedNum );
            if ((i + 1) % 3 == 0)
            {
                System.out.print("\n");
            }
        }
        System.out.println("");
        System.out.println(aboveAvg + " " + belowAvg);
        double above = aboveAvg / numWanted;
        double below = belowAvg / numWanted;
        System.out.println(above + " " + below);
        System.out.println("Below " + average + ": " + barMaker(below));
        System.out.println("Above " + average + ": " + barMaker(above));
    }

    public static String barMaker(Double a) {
        String printMe = "Not Valid Percentage!";
        double blanks = 0;
        a = a * 10;
        if (a <= 10) {
            blanks = 10 - a;
            printMe = "[";
            for (int i = 0; i < a; i++) {
                printMe += "#";
            }
            for (int i = 0; i < blanks; i++) {
                printMe += " ";
            }
            printMe += "]";
        }
        return printMe;
    }

    public static int customSearch(String littleString, String bigString) {
        int where = -1;
        int start = 0;
        int end = 0;
        int bigLen = bigString.length();
        for (int i = 0; i < bigLen; i++) {
            String bigTest = bigString.substring(i, i + 1);
            if (bigTest.equals(" ")) {
                end = i;
                String isEqual = bigString.substring(start, end);
                if (isEqual.equals(littleString)) {
                    where = start;
                }
                start = end + 1;
            }
        }
        return where;
    }

    public static int lengthLongestWord(String phrase) {
        int longest = 0;
        int currentWord = 0;
        int len = phrase.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            String testMe = phrase.substring(i, i + 1);
            if (testMe.equals(" ")) {
                end = i;
                currentWord = end - start;
                start = end + 1;
            }
            if (i == len - 1) {
                currentWord = len - (end + 1);
            }
            if (currentWord >= longest) {
                longest = currentWord;
            }
        }
        return longest;
    }

    public static int letterCounter(String phrase, char letter) {
        int frequency = 0;
        int len = phrase.length();
        for (int i = 0; i < len; i++) {
            String testMe = phrase.substring(i, i + 1);
            testMe = testMe.toLowerCase();
            char testLetter = testMe.charAt(0);
            if (testLetter == letter) {
                frequency++;
            }
        }
        return frequency;
    }

    public static String wordLengthOrder(String phrase) {
        String orderedWords = "";
        int len = phrase.length();
        int currentWord;
        int longestWord = lengthLongestWord(phrase);
        for (int i = 1; i <= longestWord; i++)
        {
            int start = 0;
            int end = 0;
            for (int o = 0; o < len; o++)
            {
                String testMe = phrase.substring(o,o+1);
                if (testMe.equals(" "))
                {
                    end = o;
                    currentWord = end - start;
                    if (currentWord == i)
                    {
                        orderedWords += phrase.substring(start, end) + " ";
                    }
                    start = o + 1;
                }
                if (o == len - 1)
                {
                    currentWord = len - (end+1);
                    if (currentWord == i)
                    {
                        orderedWords += phrase.substring(len - currentWord);
                    }

                }

            }
        }
        return orderedWords;
    }
    public static int numRanger(int one, int two)
    {
        int randoNum = (int) (Math.random() * (two - one + 1) + one);
        return randoNum;
    }
    public static double sumOfAverages(int one, int two)
    {
        double average = 0.0;
        int tempOne;
        if (one > two)
        {
            tempOne = one;
            one = two;
            two = tempOne;
        }
        for (int i = 1; i <= 500; i++)
        {
           average += (Math.random() * (two - one + 1) + one);
        }
        average = average/500;
        return average;
    }
}
