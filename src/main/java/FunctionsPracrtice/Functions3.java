package FunctionsPracrtice;

public class Functions3 {
    public static void main(String[] args) {
        int counter=1;
        System.out.println("The perfect numbers btw 1 - 10,000 are:");
        for(int i=1; i<=10000; i++){
            if(isPerfectNumber(i)){
                System.out.println(counter++ + ") " + i);
            }
        }
    }

    public static boolean isPerfectNumber(int num){
        int tempNum=num, sumDiv=0;
        //add all the dividers of num to sumDiv
        for(int i=1; i<tempNum; i++){
            if(tempNum%i==0){
                sumDiv+=i;
            }
        }
        return sumDiv==num;
    }
}
