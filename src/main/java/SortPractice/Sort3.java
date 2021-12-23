package SortPractice;

import java.util.Scanner;

public class Sort3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter a string");
        String word=scanner.next();
        System.out.println(word);
        System.out.println(sortString(word));
    }

    public static char[] sortString(String word){
        char[] arr=word.toCharArray();
        char temp;
        for(int i=0; i<arr.length-1; i++){
            for (int j = 0; j < arr.length-i-1 ; j++) {
                if(Character.toUpperCase(arr[j])>Character.toUpperCase(arr[j+1])){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        return arr;
    }
}
