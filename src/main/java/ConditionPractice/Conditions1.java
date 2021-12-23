package ConditionPractice;

import java.util.Scanner;

public class Conditions1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double salary, expenses, motorcyclePrice, savings=0;
        int countMonth=0;
        //receive information from the user
        System.out.println("Please enter motorcycle price");
        motorcyclePrice=scanner.nextDouble();
        System.out.println("Please enter your salary");
        salary= scanner.nextDouble();;
        System.out.println("Please enter your monthly expenses");
        expenses= scanner.nextDouble();

        //calculate number of months the user have to save money
        if(expenses>=salary){//if the expenses>=salary -> the user cannot save money!
            System.out.println("You have to save money!");
        }else{
            while(savings<motorcyclePrice){//calculate the savings until savings>=motorcycle price
                savings+=salary-expenses;
                countMonth++;//count the months the user have to save money
            }
        }
        //print to the screen the number of months
        System.out.println("You can by the motorcycle in " + countMonth + " months");
    }
}
