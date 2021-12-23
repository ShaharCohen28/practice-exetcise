package FunctionsPracrtice;

import java.util.Scanner;

public class Functions2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1, num2, result;

        System.out.println("Please enter two numbers");
        num1=scanner.nextInt();
        num2=scanner.nextInt();

        result=minimumDigits(num1, num2);
        if(result==-1){
            System.out.println("The numbers are in different length");
        }else{
            System.out.println("The new number is: " + result);
        }
    }

    private static int minimumDigits(int num1, int num2) {
        int newNum=0, place=1, minDigit;
        while (num1>0&&num2>0){
            minDigit=Math.min(num1%10, num2%10);
            newNum+=minDigit*place;
            place*=10;
            num1/=10;
            num2/=10;
        }
        /*
        if only one number equals to 0 at the end of the loop,
        it means that the numbers have different length
         */
        if(num1>0||num2>0){
            return -1;
        }else{
            return newNum;
        }
    }
}
