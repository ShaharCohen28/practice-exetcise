package LoopsPractice;

import java.util.Scanner;

public class Loops4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int id, checkDigit, restID, place=1, resultDigit, sum=0, tempDigit;

        System.out.println("Please enter id number");
        id=scanner.nextInt();
        checkDigit=id%10;
        restID=id/10;

        while (restID>0){
            tempDigit=restID%10;
            tempDigit*=(place%2)+1;
            place++;
            sum+=tempDigit/10;
            sum+=tempDigit%10;
            restID/=10;
        }
        resultDigit=10-sum%10;
        resultDigit%=10;
        //System.out.println("result digit: "+ resultDigit+ "\ncheck digit: " + checkDigit);
        if(resultDigit==checkDigit){
            System.out.println("Valid id");
        }else{
            System.out.println("Invalid id");
        }
    }
}
