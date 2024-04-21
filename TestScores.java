import java.util.Random;
import java.util.Scanner;
public class TestScores {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Random randGen = new Random();
        //NEED help on step 6
        // CREATED VARIABLES
        int userinput;
        //Number of test scores
        final int SIZE = randGen.nextInt(3,4) ;

        //CREATED ARRAYS
        //testscore array
        int[] testscore = new int[SIZE];
        //letter grade array
        char[] grade = new char[SIZE];

        System.out.println("Enter you " + SIZE + " test scores");
        //LOOP TO ENTER IN TEST SCORES
        for (int i = 0; i < SIZE; i++){
            System.out.print("Enter test " + (i +1)+ " score: ");
            testscore[i] = scanner.nextInt();
        }
        //LETTER GRADE ARRAY LOOP
        for (int j = 0; j< SIZE; j++){
            grade[j] = getLetterGrade(testscore[j]);
        }
        printGrades(testscore, grade);
        printHighestScore(testscore);
        printLowestScore(testscore);
        printAverageScore(testscore);
        scanner.close();

    }
    //GETLETTERGRADE METHOD
    //is return correct
    public static char getLetterGrade(int testscore){
        //CREATED VARIABLES
        //char A, B, C, D, F;
        char letterG;
        if (testscore >= 90){
           letterG = 'A';

        }
        else if (testscore >= 80){
            letterG = 'B';

        }
        else if (testscore >= 70){
            letterG = 'C';
        }
        else if (testscore >= 60){
            letterG = 'D';
        }
        else{
           letterG= 'F';
        }
        return  letterG;
    }
    //PRINTGRADES METHOD
    //how to format
    public static void printGrades(int testscorearray[],char lettergradearray[]){
        System.out.printf("%-20s %-20s\n", "Score", "Grade");
        for (int i = 0; i < testscorearray.length; i++){
           System.out.printf("%-12d%13c\n", testscorearray[i], lettergradearray[i]);
        }
    }
    //PRINTHIGHESTSCORE METHOD
    public static void printHighestScore(int testscorearray[]){
        int currenthigh = 0;
        for (int i = 0; i < testscorearray.length; i++){
            if (testscorearray[i] > currenthigh){
                currenthigh = testscorearray[i];
            }
        }
        System.out.println("The highest score is " + currenthigh);
    }

    //PRINTLOWESTSCORE METHOD
    public static void printLowestScore(int testscorearray[]){
        int currentlow = 100;
        for (int i = 0; i < testscorearray.length; i++){
            if (testscorearray[i] < currentlow){
                currentlow = testscorearray[i];
            }
        }
        System.out.println("The lowest score is " + currentlow);
    }

    //PRINTAVERAGESCORE METHOD
    public static void printAverageScore(int testscorearray[]){
        int currentvalue = 0;
        double average;
        for (int i = 0; i < testscorearray.length; i++){
            currentvalue = currentvalue + testscorearray[i];
        }
        average = currentvalue/testscorearray.length;
        System.out.printf("Average score is %.1f", average);
    }
}
