package ArraysPractice;

import java.util.Scanner;

public class Arrays6 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        char[] chArr=new char[10];
        boolean isCaps=false;

        System.out.println("Please enter " + chArr.length + " letters, 2 must be capital " +
                "and the rest must be lower-case");
        for (int i=0; i< chArr.length; i++){
            chArr[i]=scanner.next().charAt(0);
        }
        for (int i=0; i< chArr.length; i++){
            System.out.print(chArr[i]+ ", ");
        }
        System.out.println();

        for (int i=0; i< chArr.length; i++){
            if((chArr[i]>='A'&&chArr[i]<='Z')&&!isCaps){
                isCaps=true;
                continue;
            }
            if(isCaps&&!(chArr[i]>='A'&&chArr[i]<='Z')){
                chArr[i]-=32;
            }else{
                isCaps=false;
            }
        }

        for (int i=0; i< chArr.length; i++){
            System.out.print(chArr[i]+ ", ");
        }
        System.out.println();

    }
}
