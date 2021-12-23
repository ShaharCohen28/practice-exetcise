package FunctionsPracrtice;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Functions11 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String move = "  ";
        int size, pointerEmpty;

        System.out.println("Please enter e number of the size");
        size = scanner.nextInt();
        char[] marblePuzzle = new char[2 * size + 1];
        pointerEmpty = 2 * size;
        initiateMarblePuzzle(marblePuzzle);


        while (!isOK(marblePuzzle, size, pointerEmpty)) {
            printMarblePuzzle(marblePuzzle, move);
            TimeUnit.SECONDS.sleep(1);
            if (checkShiftRight(marblePuzzle, pointerEmpty)) {
                pointerEmpty = switchPlace(marblePuzzle, pointerEmpty - 1, pointerEmpty);
                move = "SR";
                continue;
            }
            if (checkJumpRight(marblePuzzle, pointerEmpty)) {
                pointerEmpty = switchPlace(marblePuzzle, pointerEmpty - 2, pointerEmpty);
                move = "JR";
                continue;
            }
            if (checkShiftLeft(marblePuzzle, pointerEmpty)) {
                pointerEmpty = switchPlace(marblePuzzle, pointerEmpty + 1, pointerEmpty);
                move = "SL";
                continue;
            }
            if (checkJumpLeft(marblePuzzle, pointerEmpty)) {
                pointerEmpty = switchPlace(marblePuzzle, pointerEmpty + 2, pointerEmpty);
                move = "JL";
            }
        }
        printMarblePuzzle(marblePuzzle, move);
        System.out.println("Game Finished");
    }

    /*
    initiate the marble puzzle with 'O' and 'X' at the right places
     */
    public static void initiateMarblePuzzle(char[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (i % 2 == 0) {
                arr[i] = 'O';
            } else {
                arr[i] = 'X';
            }
        }
        arr[arr.length - 1] = ' ';
    }

    /*
    print the current state of the marble puzzle
     */
    public static void printMarblePuzzle(char[] arr, String move) {
        System.out.print(move + "\t");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("|" + arr[i]);
        }
        System.out.print("|\n");
    }

    /*
    check if the board is finished.
    return true if it does, false if not
     */
    public static boolean isOK(char[] arr, int size, int placeEmpty) {
        if(placeEmpty==size){
            //System.out.println(arr[placeEmpty-1]=='O'&&arr[placeEmpty+1]=='X');
            return arr[placeEmpty-1]=='O'&&arr[placeEmpty+1]=='X';
        }
        return false;
    }

    /*
    switch place in the array
    return the empty place back to pointerEmpty
     */
    public static int switchPlace(char[] arr, int place, int placeEmpty) {
        char temp = arr[placeEmpty];
        arr[placeEmpty] = arr[place];
        arr[place] = temp;
        return place;
    }

    public static boolean checkShiftRight(char[] arr, int placeEmpty) {
        if (placeEmpty + 1 >= arr.length) {
            return true;
        } else if (arr[placeEmpty - 1] == 'X') {
            return arr[placeEmpty + 1] == 'X' && arr[placeEmpty + 2] == 'X';
        }
        return false;
    }

    public static boolean checkJumpRight(char[] arr, int placeEmpty) {
        if (placeEmpty - 2 < 0) {
            return false;
        } else return arr[placeEmpty - 1] == 'O' && arr[placeEmpty - 2] == 'X';
    }

    public static boolean checkShiftLeft(char[] arr, int placeEmpty) {
        if (placeEmpty - 2 < 0) {
            return true;
        } else if (arr[placeEmpty + 1] == 'O') {
            return arr[placeEmpty - 1] == 'O' && arr[placeEmpty - 2] == 'O';
        }
        return false;
    }

    public static boolean checkJumpLeft(char[] arr, int placeEmpty) {
        return arr[placeEmpty+1]=='X'&&arr[placeEmpty+2]=='O';
    }


}