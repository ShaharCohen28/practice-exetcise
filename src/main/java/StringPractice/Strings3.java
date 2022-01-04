package StringPractice;

import java.util.Scanner;

public class Strings3 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        String firstLetterString;

        System.out.println("Please enter a text");
        firstLetterString=getFirstLetter(input.next());
        System.out.println("The first letters in the string are: " + firstLetterString);

    }

    public static String getFirstLetter(String str){
        String[] splitMyText=str.split(" ");
        String newString="";
        char firstLetter;
        boolean hasBeen;

        for (int index = 0; index < splitMyText.length ; index++) {
            hasBeen=false;
            firstLetter =splitMyText[index].charAt(0);
            for (int jndex = 0; jndex <newString.length() ; jndex++) {
                if (newString.charAt(index)== firstLetter){
                    hasBeen=true;
                    break;
                }
            }
            if(!hasBeen){
                newString=newString+firstLetter;
            }
        }

        return newString;
    }
}
