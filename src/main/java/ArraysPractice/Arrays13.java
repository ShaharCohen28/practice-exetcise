package ArraysPractice;

public class Arrays13 {
    public static void main(String[] args) {
        int[][] mat;
        int randomSize=(int)(Math.random()*4)+4, previous=0;
        mat=snakeMatrix(randomSize,randomSize);
        printMatrix(mat);

    }

    public static int[][] snakeMatrix(int rowSize, int colSize){
        int[][] mat=new int[rowSize][colSize];
        boolean directionDown=true;
        int previous=0;
        for (int col = mat[0].length-1; col >=0 ; col--) {
            if(directionDown) {
                for (int row = 0; row < mat.length; row++) {
                    mat[row][col] = ++previous;
                }
            }else{
                for (int row = mat.length-1; row >=0 ; row--) {
                    mat[row][col] = ++previous;
                }
            }
            directionDown=!directionDown;
        }
        return mat;
    }

    public static void printMatrix(int[][] mat){
        for (int row = 0; row < mat.length ; row++) {
            for (int col = 0; col <mat[0].length ; col++) {
                System.out.print(((mat[row][col]<10)?" ":"") + mat[row][col] + " ");
            }
            System.out.println();
        }
    }
}
