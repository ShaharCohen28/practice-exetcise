package FunctionsPracrtice;

import java.util.Scanner;

public class Functions8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number1, number2, res;

        System.out.println("Please enter the first number");
        number1 = insertNumber(scanner.nextInt());
        System.out.println("Please enter the second number");
        number2 = insertNumber(scanner.nextInt());
        res = add(number1, number2);

        System.out.println("The result is");
        printArr(number1);
        System.out.println("+");
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
        int temp = num;
        for (int index = arr.length-1 ;index >=0 ; index--) {
            arr[index]=temp%10;
            temp/=10;
        }
        return arr;
    }

    public static int[] add(int[] number1, int[] number2) {
        int longer=(Math.max(number1.length, number2.length));
        int[] res = new int[longer+1];
        int carry = 0, indexRes = res.length - 1, currentSum;
        int indexNumber1 = number1.length - 1, indexNumber2 = number2.length - 1;
        do {
            currentSum =number1[indexNumber1] + number2[indexNumber2] + carry;
            res[indexRes] = currentSum % 10;
            carry = currentSum / 10;
            indexNumber1--;
            indexNumber2--;
            indexRes--;
        } while (indexNumber1 >= 0 && indexNumber2 >= 0);
        if (indexNumber1 > indexNumber2) {
            fillResult(res, number1, indexRes, indexNumber1, carry);
        } else if (indexNumber2 > indexNumber1) {
            fillResult(res, number2, indexRes, indexNumber2, carry);
        } else {
            res[indexRes] = carry;
        }
        return res;
    }

    public static void fillResult(int[] res, int[] number, int indexRes, int indexNumber, int carry) {
        int currentSum;
        while (indexNumber >= 0) {
            currentSum=number[indexNumber] + carry;
            res[indexRes] = currentSum % 10;
            carry = currentSum / 10;
            indexNumber--;
            indexRes--;
        }
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
