package ConditionPractice;

import java.util.Scanner;

public class Conditions2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a, b;
        double x;
        //receive values for a and b
        System.out.println("AX+B=0");
        System.out.println("Please enter A and B to calculate the value of X");
        System.out.print("A:");
        a=scanner.nextInt();
        System.out.print("B:");
        b= scanner.nextInt();
        //AX+B=0
        //X=-B/A
        if(a==0){//cannot divide by 0-> no result
            System.out.println("NO RESULT");
        }else if(b==0){//everything divided by 0 equals to 0 -> infinite results
            System.out.println("infinite results");
        }else{//one result
            x=-1.0*b/a;
            System.out.println("X=" +x);
        }
    }
}
