package ConditionPractice;

import java.util.Scanner;

public class Conditions5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int bagrut, psycometric, mathGrade, englishGrade;
        double avg;
        //String answer="";
        boolean accepted=false;

        System.out.println("Please enter your bagrut average");
        bagrut=scanner.nextInt();
        if(bagrut>=102){
            //answer="accepted";
            accepted=true;
        }else{
            System.out.println("Please enter your psycometric result");
            psycometric=scanner.nextInt();
            if(psycometric>=700){
                System.out.println("Please enter your math result");
                mathGrade=scanner.nextInt();
                System.out.println("Please enter your english result");
                englishGrade=scanner.nextInt();
                if(mathGrade>=145&&englishGrade>=120){
                    //answer="accepted";
                    accepted=true;
                }
            }
            if(psycometric>=600&&!accepted){
                avg=(psycometric*0.8)+(bagrut/1.2);
                //answer=avg>=600?"accepted":"not accepted";
                accepted=avg>=600;
            }
        }
        System.out.println(accepted?"accepted":"not accepted");
    }
}
