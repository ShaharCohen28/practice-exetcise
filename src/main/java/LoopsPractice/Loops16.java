package LoopsPractice;

public class Loops16 {
    public static void main(String[] args) {
        final int CHECK_LIMIT=10;
        int number=1, count=0, sumNumber1, sumNumber2;
        //System.out.println(sumOfDividers(number1)==number2);
        while(count<CHECK_LIMIT){
            sumNumber1=sumOfDividers(number);
            sumNumber2=sumOfDividers(sumNumber1);
            if(number==sumNumber2&&sumNumber1!=sumNumber2&&sumNumber1>number){
                System.out.println(++count + ") " + number + " and " + sumNumber1 + " are mates");
            }
            number++;
        }
    }

    public static int sumOfDividers(int num){
        int sum=0;
        for(int divider=1; divider<num; divider++){
            if(num%divider==0){
                sum+=divider;
            }
        }
        return sum;
    }
}
