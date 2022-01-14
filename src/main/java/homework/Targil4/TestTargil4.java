package homework.Targil4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestTargil4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> myList = new ArrayList<>();
        int maxLength;
        System.out.println("Please enter 5 strings to the array");
        for (int counter = 0; counter < 5; counter++) {
            myList.add(scanner.next());
        }
        maxLength = findMaxLength(myList);
        System.out.println(maxLength);
        printMaxStrings(myList, maxLength);
    }

    public static void printMaxStrings(List<String> myList, int maxLength) {
        for (String item : myList) {
            if (item.length() == maxLength) {
                System.out.println(item);
            }
        }
    }

    public static int findMaxLength(List<String> myList) {
        int max = 0;
        for (String item : myList) {
            if (item.length() > max) {
                max = item.length();
            }
        }
        return max;
    }
}
