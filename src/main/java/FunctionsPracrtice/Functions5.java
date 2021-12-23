package FunctionsPracrtice;

import java.util.Scanner;

public class Functions5 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num;
        char ch;

        System.out.println("Please enter a number");
        num= scanner.nextInt();
        System.out.println("Please enter a character");
        ch=scanner.next().charAt(0);
        printRomb(num,ch);
    }

    public static void printRomb(int num, char ch) {
        for(int i=0; i<num; i++){
            printSign(num-i,ch);
            printSign(2*i,' ');
            printSign(num-i,ch);
            if(i!=num-1){
                System.out.println();
            }
        }
        for (int i = 0; i <=num ; i++) {
            printSign(i,ch);
            printSign(2*(num-i),' ');
            printSign(i,ch);
            System.out.println();
        }
    }
    public static void printSign(int times, char sign){
        for (int i = 0; i <times ; i++) {
            System.out.print(sign);
        }
    }
}
