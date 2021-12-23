package ConditionPractice;

import java.util.Scanner;

public class Conditions3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int gift=0, drivingTime, yearsKnown;
        boolean relatives=false, closeFriends=false;

        System.out.println("Are you related to the couple? true/false");
        relatives=scanner.nextBoolean();
        if(relatives){
            gift=1000;
        }else{
            System.out.println("Are you close friends with the couple? true/false");
            closeFriends=scanner.nextBoolean();
            if(closeFriends){
              gift=500;
            }else {
                gift=250;
            }
            System.out.println("How many years do you know the couple?");
            yearsKnown= scanner.nextInt();
            System.out.println("Enter time of driving to the event in minutes");
            drivingTime=scanner.nextInt();

            if(yearsKnown>3){
                gift+=50;
            }
            if(drivingTime/60>=1){
                gift-=50;
            }
        }

        System.out.println("The recommended gift for the wedding is " + gift);
    }
}
