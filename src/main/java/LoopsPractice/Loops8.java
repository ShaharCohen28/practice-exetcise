package LoopsPractice;

public class Loops8 {
    public static void main(String[] args) {
        //a is mone and b is machane in the new number
        //j is mone and i is machane in the og number
        int a, b, counter=1;
        double oldNumber, newNumber;
        for(int i=10;i<=99;i++){
            for(int j=10;j<i; j++){
                a=j/10;
                b=i%10;
                if(b==0){
                    continue;
                }
                oldNumber=1.0*j/i;
                newNumber=1.0*a/b;
                if(oldNumber==newNumber){
                    System.out.print(counter++ + ") ");
                    System.out.printf("%d/%d == %d/%d\n",a,b,j,i);
                }
            }
        }
    }
}
