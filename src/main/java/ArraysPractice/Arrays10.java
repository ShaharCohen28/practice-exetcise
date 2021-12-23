package ArraysPractice;

public class Arrays10 {
    public static void main(String[] args) {
        final int ARRAY_SIZE=10;
        char[][] arr=new char[ARRAY_SIZE][ARRAY_SIZE];
        char randomChar=(char)((Math.random()*94)+32);
        int maxCol=-1, appears, maxAppear=0;

        arr=initiateArray(arr);
        printArr(arr);

        for (int col = 0; col <arr[0].length ; col++) {
            appears=searchCharInCol(arr,randomChar,col);
            if(appears>maxAppear){
                maxAppear=appears;
                maxCol=col;
            }
        }

        if(maxCol==-1){
            System.out.println("The character " + randomChar + " doesn't appear in the array");
        }else{
            System.out.println("The character " + randomChar + " appears in the array "
                    + maxAppear + " times in column " + maxCol);
        }
    }

    public static char[][] initiateArray(char[][] arr){
        for(int row=0;row< arr.length;row++){
            for (int col=0;col< arr[0].length;col++){
                arr[row][col]=(char)((Math.random()*94)+32);
            }
        }
        return arr;
    }

    public static void printArr(char[][] arr){
        for(int row=0;row< arr.length;row++){
            for (int col=0;col< arr[0].length;col++){
                System.out.print(arr[row][col] +" ");
            }
            System.out.println();
        }
    }

    public static int searchCharInCol(char[][] arr, char ch, int col){
        int count=0;
        for(int row=0;row<arr.length; row++){
            if(arr[row][col]==ch){
                count++;
            }
        }
        return count;
    }
}
