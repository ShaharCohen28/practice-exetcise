package ArraysPractice;

import java.util.Scanner;

public class Arrays17 {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 4) + 4;
        char[][] mat = new char[randomNumber][randomNumber];
        initiateMatrix(mat);
        printMatrix(mat);
        if (isCourse(mat, mat.length - 1, mat[0].length - 1)) {
            System.out.println("There is a course in the matrix");
        } else {
            System.out.println("There is no course in the matrix");
        }

    }

    public static void initiateMatrix(char[][] mat) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PLease enter " + mat.length * mat[0].length +
                " characters to the matrix");
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[row][col] = scanner.next().charAt(0);
            }
        }
    }

    public static void printMatrix(char[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isCourse(char[][] mat, int rowLength, int colLength) {
        boolean isOK = true;
        int rowIndex = 0, colIndex = colLength;

        while (isOK) {
            if (rowIndex == rowLength) {
                isOK = (mat[rowIndex][colIndex] == '|');
                break;
            }
            if (colIndex==0){
                isOK=(mat[rowIndex][colIndex]=='-');
                break;
            }
            if (mat[rowIndex][colIndex] == '|') {
                rowIndex++;
            } else if (mat[rowIndex][colIndex] == '-') {
                colIndex--;
            }else{
                isOK=false;
            }
        }
        return isOK;
    }

}
