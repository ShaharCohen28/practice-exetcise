package ArraysPractice;



public class Arrays12 {
    public static void main(String[] args) {
        final  int ARRAY_LENGTH=4;
        int[] arr=new int[ARRAY_LENGTH];
        char[][] starArr;

        arr=randomValues(arr);
        starArr=new char[ARRAY_LENGTH][findMaxValue(arr)];
        initStarArr(starArr,arr);
        printStarArr(starArr);
        printArr(arr);

    }

    private static int findMaxValue(int[] arr) {
        int max=Integer.MIN_VALUE;
        for (int index = 0; index < arr.length ; index++) {
            if(arr[index]>max){
                max=arr[index];
            }
        }
        return max;
    }

    public static int[] randomValues(int[] arr){
        for(int index=0;index< arr.length;index++){
            arr[index]=(int)(Math.random()*10);
        }
        return arr;
    }

    public static void printArr(int[] arr){
        for(int item:arr){
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void initStarArr(char[][] chArr, int[] arr){
        for(int indexRow=0; indexRow< chArr.length; indexRow++){
            for (int indexCol = 0; indexCol <arr[indexRow] ; indexCol++) {
                chArr[indexRow][indexCol]='*';
            }
            for (int indexCol = chArr[0].length-1; indexCol >=arr[indexRow] ; indexCol--) {
                chArr[indexRow][indexCol]=' ';
            }
        }
    }

    public static void printStarArr(char[][] starArr){
        for(int indexCol=starArr[0].length-1; indexCol>=0 ; indexCol--){
            for (int indexRow = 0; indexRow < starArr.length; indexRow++) {
                System.out.print(starArr[indexRow][indexCol]+ " ");
            }
            System.out.println();
        }
    }
}
