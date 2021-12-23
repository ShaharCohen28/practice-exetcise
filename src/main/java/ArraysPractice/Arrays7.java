package ArraysPractice;

import java.util.Scanner;

public class Arrays7 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        final int ARRAY_SIZE=5;
        int[] arr1=new int[ARRAY_SIZE], arr2=new int[ARRAY_SIZE], newArr= new int[ARRAY_SIZE];
        int place1=0, place2=0, placeNew=0;

        System.out.println("Please enter " + ARRAY_SIZE + " sorted numbers for the first array");
        for(int i=0; i<ARRAY_SIZE; i++){
            arr1[i]= scanner.nextInt();
        }
        System.out.println("Please enter " + ARRAY_SIZE + " sorted numbers for the second array");
        for(int i=0; i<ARRAY_SIZE; i++){
            arr2[i]= scanner.nextInt();
        }

        while(place1<ARRAY_SIZE && place2<ARRAY_SIZE){
            if(arr1[place1]==arr2[place2]){
                newArr[placeNew]=arr1[place1];
                place1++;
                place2++;
                placeNew++;
            }else if(arr1[place1]<arr2[place2]){
                place1++;
            }else{
                place2++;
            }
        }
        for(int numbers:arr1){
            System.out.print(numbers + ", ");
        }
        System.out.println();
        for(int numbers:arr2){
            System.out.print(numbers + ", ");
        }
        System.out.println();
        for(int numbers:newArr){
            System.out.print(numbers + ", ");
        }
        System.out.print("\n"+ placeNew);
    }
}
