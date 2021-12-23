package LoopsPractice;

public class Loops17 {
    public static void main(String[] args) {
        int num=10,temp,previousNumber=0;
        int countSeries=0, countIndex=0;
        while(countSeries<2) {
            temp = num;
            while (temp >= 10) {
                temp = sumOfDigitsSquare(temp);
            }
            if (temp == 1) {
                System.out.println(++countIndex + ") " + num + " is a happy number");
                if(previousNumber+1==num){
                    countSeries++;
                }else{
                    countSeries=0;
                }
                previousNumber=num;
            }
            num++;
        }

    }

    public static int sumOfDigitsSquare(int num){
        int sum=0, digit;
        while(num>0){
            digit=num%10;
            sum+=(digit*digit);
            num/=10;
        }
        return sum;
    }
}
