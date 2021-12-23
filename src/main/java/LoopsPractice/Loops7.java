package LoopsPractice;

import java.util.Scanner;

public class Loops7 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1, num2, finalResult, addResult, subResult/*, place*/;
        char operator;
        boolean isOK=true;

        System.out.println("Please enter an add expression btw two digits." +
                "\nTo end, enter a subduction expression btw two digits");
        do{
            num1= scanner.nextInt();
            operator=scanner.next().charAt(0);
            num2=scanner.nextInt();
            if(operator=='-'){
                isOK=false;
            }else{
                //place=1;
                subResult=num1-num2;
                System.out.println(subResult);
                addResult=num1+num2;
                System.out.println(addResult);
                finalResult=addResult;
                while(addResult>0){
                    subResult*=10;
                    System.out.println(finalResult);
                    addResult/=10;
                    System.out.println(subResult);
                }
                finalResult+=subResult;
                System.out.printf("%d %c %d = %d\n",num1, operator, num2, finalResult);

            }
        }while(isOK);
        System.out.println("Finish code, have a nice da :)");
    }
}
