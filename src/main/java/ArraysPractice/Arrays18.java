package ArraysPractice;

import java.util.Scanner;

public class Arrays18 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] number1, number2, res;

        System.out.println("Please enter the first number");
        number1 = insertNumber(scanner.nextInt());
        System.out.println("Please enter the second number");
        number2 = insertNumber(scanner.nextInt());

        res=multiplyNumbers(number1,number2);

        System.out.println("The result is");
        printArr(number1);
        System.out.println("x");
        printArr(number2);
        System.out.println("=");
        printArr(res);
    }

    public static int numberLength(int num) {
        int count = 0, temp = num;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        return count;
    }

    public static int[] insertNumber(int num) {
        int[] arr = new int[numberLength(num)];
        int index = arr.length - 1, temp = num;
        while (temp > 0) {
            arr[index--] = temp % 10;
            temp /= 10;
        }
        return arr;
    }

    public static int[] add(int[] number1, int[] number2) {
        int[] res = new int[number1.length + number2.length];
        int carry = 0, indexRes = res.length - 1;
        int indexNumber1 = number1.length - 1, indexNumber2 = number2.length - 1;
        do {
            res[indexRes] = (number1[indexNumber1] + number2[indexNumber2] + carry) % 10;
            carry = (number1[indexNumber1] + number2[indexNumber2] + carry) / 10;
            indexNumber1--;
            indexNumber2--;
            indexRes--;
        } while (indexNumber1 >= 0 && indexNumber2 >= 0);

        if (indexNumber1 > indexNumber2) {
            fillResult(res, number1, indexRes, indexNumber1, carry);
        } else if (indexNumber2 > indexNumber1) {
            fillResult(res, number2, indexRes, indexNumber2, carry);
        }else{
            res[indexRes]=carry;
        }

        return res;
    }

    public static void fillResult(int[] res, int[] number, int indexRes, int indexNumber, int carry) {
        while (indexNumber >= 0) {
            res[indexRes] = (number[indexNumber] + carry) % 10;
            carry = (number[indexNumber] + carry) / 10;
            indexNumber--;
            indexRes--;
        }
    }

    public static int[] multiplyDigit(int[] number, int digit){
        int[] res=new int[number.length+1];
        int carry=0, indexNumber=number.length-1, indexRes=res.length-1;

        do{
            res[indexRes]=(number[indexNumber]*digit+carry)%10;
            carry=(number[indexNumber]*digit)/10;
            indexNumber--;
            indexRes--;
        }while(indexNumber>=0);
        res[indexRes]=carry;

        return res;
    }

    public static int[] multiplyByTen(int[] number, int place){
        int[] res=new int[number.length+place];
        for (int index = 0; index <number.length ; index++) {
            res[index]=number[index];
        }
        return res;
    }

    public static int[] multiplyNumbers(int[] number1, int [] number2){
        int[] finalResult=new int[number1.length], tempCalc;
        int indexNumber2=number2.length-1, place=0;
        do{
            tempCalc=multiplyDigit(number1,number2[indexNumber2--]);
            tempCalc=multiplyByTen(tempCalc,place++);
            printArr(tempCalc);
            finalResult=add(finalResult,tempCalc);
        }while(indexNumber2>=0);
        return finalResult;
    }

    public static void printArr(int[] number) {
        boolean leadingZero = true;
        for (int index = 0; index < number.length; index++) {
            if (number[index] != 0 && leadingZero) {
                leadingZero = false;
            }
            if (number[index] == 0) {
                System.out.print(leadingZero ? "" : number[index]);
            } else {
                System.out.print(number[index]);
            }
        }
        System.out.println();
    }
}
