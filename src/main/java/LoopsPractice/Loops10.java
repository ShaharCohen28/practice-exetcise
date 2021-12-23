package LoopsPractice;

import java.util.Scanner;

public class Loops10 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int number, partition;
        System.out.println("Please enter a number");
        number= scanner.nextInt();
        System.out.println("Please enter a number for the partition");
        partition=scanner.nextInt();
        System.out.println("The new number is: " + newNumber(number,partition));
    }

    public static int newNumber(int number, int partition){
        int res=0, temp=number,  counter=0;
        int place=(int)Math.pow(10, partition),exponent;
        while (temp>0){
            exponent=(int)Math.pow(place,counter);
            res+=reverseNumber(temp%place)*exponent;
            counter++;
            temp/=place;
        }
        return res;
    }

    public static int reverseNumber(int num){
        int reverse=0;
        while(num>0){
            reverse=reverse*10+num%10;
            num/=10;
        }
        return reverse;
    }
}
