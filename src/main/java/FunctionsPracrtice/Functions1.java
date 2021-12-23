package FunctionsPracrtice;

import java.util.Scanner;

public class Functions1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num;

        System.out.println("Please enter a number");
        num= scanner.nextInt();
        System.out.println("The new number is: " + increaseDigits(num));
    }

    public static int increaseDigits(int num) {
        int newNum=0, digit, place=1;
        while(num>0){
            digit=num%10+1;
            digit%=10;
            newNum+=digit*place;
            place*=10;
            num/=10;
        }
        return  newNum;
    }
}
