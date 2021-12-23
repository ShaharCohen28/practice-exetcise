package SortPractice;

import java.util.Scanner;

public class Sort4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        final int ROWS=5, COLS=4;
        int[][] sortedMat=new int[ROWS][COLS];
        initiateMatrix(sortedMat);
        System.out.println("Please enter a number to search in the matrix");
        //binSearchValInMatrix(sortedMat, scanner.nextInt());
        searchValInMatrix(sortedMat, scanner.nextInt());


    }
    public static void initiateMatrix(int[][] mat){
        Scanner scanner=new Scanner(System.in);
        for(int col=0; col<mat[0].length; col++){
            System.out.println("Please enter sorted " + mat.length + " numbers for column " + col);
            for (int row = 0; row <mat.length ; row++) {
                mat[row][col]= scanner.nextInt();
            }
        }
    }

    public static void binSearchValInMatrix(int[][] mat, int number){
        int low, mid, high;
        for (int col = 0; col <mat[0].length ; col++) {
            low=0;
            high=mat.length-1;
            mid=(low+high)/2;
            while(low<high){
                if(mat[mid][col]==number){
                    System.out.println("The number " + number + " is in column " + col);
                    break;
                }else{
                    if(mat[mid][col]<number){
                        low=mid+1;
                        mid=(low+high)/2;
                    }else{
                        high=mid-1;
                        mid=(low+high)/2;
                    }
                }
            }
        }
    }

    public static void searchValInMatrix(int[][] mat, int number){
        for (int col = 0; col <mat[0].length ; col++){
            for (int row = 0; row <mat.length ; row++){
                if(mat[row][col]==number){
                    System.out.println("The number " + number + " is in column " + col);
                    break;
                }
            }
        }
    }
}
