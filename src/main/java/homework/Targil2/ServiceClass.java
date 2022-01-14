package homework.Targil2;

public abstract class ServiceClass {

    public static double getAverage(int a, int b, int c){
        return (double)(a+b+c)/3;
    }

    public static int getRandomNumber(int max, int min){
        return (int)(Math.random()*(max-min)+min);
    }

    public static boolean isEven(int num){
        return num%2==0;
    }

    public static boolean isOdd(int num){
        return num%2==1;
    }
}
