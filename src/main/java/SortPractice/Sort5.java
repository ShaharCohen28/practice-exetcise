package SortPractice;

public class Sort5 {
    public static void main(String[] args) {
        final int ROWS = 4, COLS = 4;
        int[][] mat = new int[ROWS][COLS];
        /*
        System.out.println("targil 5: bubble sort");
        randomValues(mat);
        printMatrix(mat);
        bubbleSortMatrix(mat, mat.length, mat[0].length);
        System.out.println();
        printMatrix(mat);
        */
        System.out.println("targil 6: selection sort");
        randomValues(mat);
        printMatrix(mat);
        selectionSortMatrix(mat, mat.length, mat[0].length);
        System.out.println();
        printMatrix(mat);

    }

    public static void randomValues(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                mat[row][col] = (int) (Math.random() * 89) + 10;
            }
        }
    }

    public static void printMatrix(int[][] mat) {
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                System.out.print(mat[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void bubbleSortMatrix(int[][] mat, int rows, int cols) {
        int temp, size = rows * cols;

        for (int i = 0; i < size; i++) {
            for (int index = 0; index < size - i - 1; index++) {
                if (mat[index / cols][index % cols] > mat[(index + 1) / cols][(index + 1) % cols]) {
                    temp = mat[index / cols][index % cols];
                    mat[index / cols][index % cols] = mat[(index + 1) / cols][(index + 1) % cols];
                    mat[(index + 1) / cols][(index + 1) % cols] = temp;
                    //swap(mat[index / cols][index % cols],mat[(index + 1) / cols][(index + 1) % cols]);
                }
            }
        }
    }

    public static void selectionSortMatrix(int[][] mat, int rows, int cols) {
        int temp, size = rows * cols, minRow, minCol;
        for (int i = 0; i < size; i++) {
            minRow = 1;
            minCol = 1;
            for (int index = i + 1; index < size; index++) {
                if (mat[index / cols][index % cols] < mat[minRow][minCol]) {
                    minRow = index / cols;
                    minRow = index % cols;
                }
            }
            if (minRow != 1 || minCol != 1) {
                temp = mat[i / cols][i % cols];
                mat[i / cols][i % cols] = mat[minRow][minCol];
                mat[minRow][minCol] = temp;
                //swap(mat[i / cols][i % cols],mat[minRow][minCol]);
            }
        }
    }

    public static void swap(int bigNumber, int smallNumber){
        int temp=bigNumber;
        bigNumber=smallNumber;
        smallNumber=temp;
    }
}
