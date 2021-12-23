package ConditionPractice;

import java.util.Scanner;

public class Conditions4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int ADULT_BOOKS = 5;
        final int CHILD_BOOKS = 3;
        int numberOfBooks;
        char memberType;
        boolean bookAtHome = false, adult = false, child = false;
        String answer = "";
        //receive the right type of membership
        System.out.println("What us your member type: adult of child?\nFor adult type a\nFor child type c");
        do {
            memberType = scanner.next().charAt(0);
            switch (memberType) {
                case 'a':
                case 'A':
                    adult = true;
                    break;
                case 'c':
                case 'C':
                    child = true;
                    break;
                default:
                    System.out.println("Invalid input, please enter again");
            }
        } while (!adult && !child);

        System.out.println("Do you have books at home not returned? true/false");
        bookAtHome = scanner.nextBoolean();
        if (bookAtHome) {//doesn't check number of books at home if the user hadn't returned a book
            answer = "You cannot take another book";
        } else {
            System.out.println("Please enter number of books at home");
            numberOfBooks = scanner.nextInt();
            if (adult) {//check for adult membership
                answer=numberOfBooks < ADULT_BOOKS?"You can take another book":"You cannot take another book";
            }
            if (child) {//check for child membership
                answer=numberOfBooks < CHILD_BOOKS?"You can take another book":"You cannot take another book";
            }
        }
        System.out.println(answer);//print answer
    }
}

