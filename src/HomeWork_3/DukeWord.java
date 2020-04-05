package HomeWork_3;

import java.util.Scanner;

/* Author Name: Cody Bishop
   Date: 2-13-2020
   Program: Duke_Word
   Description: Duke word is a program that utilizes loops to preform data gathering
   on a string that is input by a user.
*/
public class DukeWord
{
    public static void main(String[] args)
    {
        String phrase;
        int trigger = 0;
//      Create a scanner to import user input
        Scanner scan = new Scanner(System.in);
/*      I don't use the trigger variable here because I couldn't find the proper way to code this
        Therefore i used a break to test before any other computation happens. thus creating an infinite loop in
        Theory but the break function allows the program to exit */
        while (trigger != 1)
        {

            System.out.println("=====================================\n" +
                    "Please enter a new phrase to process (\"-1 to quit\"):");
            phrase=scan.nextLine();
//          Here is the test to see if the exit code is input by the user and then the system breaks to outside of the loop
            if(phrase.equals("-1"))
            {
                break;
            }
//          here I create variables to store important information critical to the program
            int NumOfA = 0;
            int NumOfE = 0;
            int NumOfI = 0;
            int NumOfO = 0;
            int NumOfU = 0;
            String ShortWord;
            String LongWord;
/*          In an attempt to decrease the amount of times i typed phrase.length() I created a variable this helps reduce
            the amount of processing the program does unnecessarily */
            int PhraseLength = phrase.length();
            int NumChar;
            int NumSpace = 0;
            int NumWords;
            int LengthOfShort = PhraseLength;
            int LengthOfLong = 0;
/*           In an attempt to reduce the amount of loops in my program i made one large loop the tested a single character
            everytime the loops excecuted. This allowed me to check for all required datatypes while reducing redundancy*/
            for(int s = 0;s < PhraseLength;s++)
            {
//              Here i create a string that is the test value for the loop. It creates a single character string
                String TestMe = phrase.substring(s,(s+1));
//              The purpose of this is to make sure that any characters are tested properly regardless of case
                TestMe = TestMe.toLowerCase();
/*              Below i have if statements for each test case and increment the variable that contains the count as
                required*/
                if (TestMe.equals("a"))
                {
                    NumOfA++;
                }
                if (TestMe.equals("e"))
                {
                    NumOfE++;
                }
                if (TestMe.equals("i"))
                {
                    NumOfI++;
                }
                if (TestMe.equals("o"))
                {
                    NumOfO++;
                }
                if (TestMe.equals("u"))
                {
                    NumOfU++;
                }
/*              I used a variable to count the number of spaces in the program so that i count remove any of them from
                the character count and to calculate the words in the string   */
                if (TestMe.equals(" "))
                {
                    NumSpace++;
                }
            }
//          This assigns the number of words based on how many spaces are present
            if(NumSpace == 0)
            {
                NumWords = 1;
            }
            else
            {
                NumWords = NumSpace + 1;
            }
//          this is the math to calculate the number of characters in the string
            NumChar = PhraseLength - NumSpace;
//          Starting here I create a logical method to find the minimum and maximum words in the string
            int End = 0;
            int Start = 0;
            int MinStart = 0;
            int MaxStart = 0;
            while (End <= PhraseLength)
            {
//              Here the Function counts the length of a word and stops at a space
                int LengthOfWord = 0;
                if (End < PhraseLength && phrase.charAt(End) != ' ')
                {
                    End++;
                }
/*
                Once the loop finds a space the program moves to the else statement and creates a word length variable
                to test against the current word lengths in both short and long if the word length meets the criteria
                the program updates the indexes of that word
*/
                else
                {
                     LengthOfWord = End - Start;

                    if (LengthOfWord <= LengthOfShort)
                    {
                        LengthOfShort = LengthOfWord;
                        MinStart = Start;
                    }

                    if (LengthOfWord >= LengthOfLong)
                    {
                        LengthOfLong = LengthOfWord;
                        MaxStart = Start;
                    }
                    End++;
                    Start = End;
                }
            }
/*
            After exiting the loop the final values are used to create a substring function to assign the correct words
            to the respective variables
*/
            ShortWord = phrase.substring(MinStart, MinStart + LengthOfShort);
            LongWord = phrase.substring(MaxStart, MaxStart + LengthOfLong);
//          Now that all processing is complete the program prints all the required returns for the user to see
            System.out.println("========Processing Complete============");
            System.out.println("Vowel Count: ");
            System.out.println("a: " + NumOfA + " e: " + NumOfE + " i: " + NumOfI + " o: " + NumOfO +
                    " u: " + NumOfU);
            System.out.println("Longest Word: " + "\""+ LongWord + "\", length: " + LengthOfLong);
            System.out.println("Shortest Word: " + "\""+ ShortWord + "\", length: " + LengthOfShort);
            System.out.println("Overall Quantity of Words: " + NumWords + ", and characters: " + NumChar);
        }
    }

}
