package homework.Targil2;

public class TestTargil2 {
    public static void main(String[] args) {
        int num1=2, num2=3, num3=10;
        System.out.println("first number: " + num1
                + "\nSecond number: " + num2
                + "\nThird number: " + num3);
        System.out.println("The average is: " + ServiceClass.getAverage(num1, num2,num3));
        System.out.printf("Random number between %d - %d: %d\n"
                ,num1, num3, ServiceClass.getRandomNumber(num1,num3));
        System.out.println("Number " + num1 + " is " + (ServiceClass.isEven(num1)?"even":"odd"));
        System.out.println("Number " + num2 + " is " + (ServiceClass.isOdd(num2)?"odd":"even"));
    }

}
